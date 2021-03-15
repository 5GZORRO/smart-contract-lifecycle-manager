package eu._5gzorro.manager.dlt.corda.service.rpc;

import java.util.function.Consumer;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.messaging.DataFeed;
import net.corda.core.node.services.Vault.Page;
import net.corda.core.node.services.Vault.Update;
import net.corda.core.node.services.vault.QueryCriteria.VaultQueryCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.functions.Action1;

public abstract class RPCSyncService<T extends ContractState> {
  private static final Logger log = LoggerFactory.getLogger(RPCSyncService.class);

  final Class<T> typeParameterClass;
  protected final NodeRPC client;

  public RPCSyncService(
      NodeRPC client,
      Class<T> typeParameterClass) {
    this.client = client;
    this.typeParameterClass = typeParameterClass;
  }

  public abstract void setup();

  protected void beginTracking(
      VaultQueryCriteria criteria,
      Action1<Update<T>> updateFunction,
      Consumer<StateAndRef<T>> forEachRecordOnStartup
  ) {
    client.getClient()
        .vaultQueryByCriteria(criteria, typeParameterClass).getStates()
        .forEach(forEachRecordOnStartup);

    DataFeed<Page<T>, Update<T>> dataFeed
        = client.startTracking(typeParameterClass, criteria);

    dataFeed.getUpdates()
        .subscribe(
            updateFunction,
            error -> log.error("Error in {} tracking", typeParameterClass.getName(), error),
            () -> {}
        );
  }
}
