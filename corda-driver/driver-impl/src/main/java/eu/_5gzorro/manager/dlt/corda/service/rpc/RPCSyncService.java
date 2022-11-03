package eu._5gzorro.manager.dlt.corda.service.rpc;

import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.messaging.DataFeed;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.Vault.Page;
import net.corda.core.node.services.Vault.Update;
import net.corda.core.node.services.vault.PageSpecification;
import net.corda.core.node.services.vault.QueryCriteria.VaultQueryCriteria;
import net.corda.core.node.services.vault.Sort;
import net.corda.core.node.services.vault.SortAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static net.corda.core.node.services.vault.QueryCriteriaUtils.DEFAULT_PAGE_NUM;
import static net.corda.core.node.services.vault.QueryCriteriaUtils.DEFAULT_PAGE_SIZE;

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
    int pageNumber = DEFAULT_PAGE_NUM;
    List<StateAndRef<T>> states = new ArrayList<>();
    long totalResults;
    do {
      PageSpecification pageSpecification = new PageSpecification(pageNumber, DEFAULT_PAGE_SIZE);
      Vault.Page<T> results = client.getClient().vaultQueryByWithPagingSpec(typeParameterClass, criteria, pageSpecification);
      totalResults = results.getTotalStatesAvailable();
      states.addAll(results.getStates());
      pageNumber++;
    } while(((long) DEFAULT_PAGE_SIZE * (pageNumber - 1) <= totalResults));

    states.forEach(forEachRecordOnStartup);

    DataFeed<Page<T>, Update<T>> dataFeed
        = client.startTracking(typeParameterClass, criteria);

    dataFeed.getUpdates()
        .subscribe(
            updateFunction,
            error -> log.error("Error in {} tracking", typeParameterClass.getName(), error),
            () -> {}
        );
  }

  protected void beginTrackingConsumed(
      VaultQueryCriteria criteria,
      Action1<Update<T>> updateFunction,
      Consumer<StateAndRef<T>> forEachRecordOnStartup
  ) {
    List<StateAndRef<T>> states = new ArrayList<>();
    Sort.SortColumn sortByUid = new Sort.SortColumn(new SortAttribute.Standard(Sort.LinearStateAttribute.UUID), Sort.Direction.DESC);
    Vault.Page<T> results = client.getClient().vaultQueryByWithSorting(typeParameterClass, criteria, new Sort(Collections.singletonList(sortByUid)));
    if (!results.getStates().isEmpty()) {
      states.add(results.getStates().get(0));
    }

    states.forEach(forEachRecordOnStartup);

    DataFeed<Page<T>, Update<T>> dataFeed
        = client.startTracking(typeParameterClass, criteria);

    dataFeed.getUpdates()
        .subscribe(
            updateFunction,
            error -> log.error("Error in {} tracking", typeParameterClass.getName(), error),
            () -> {
            }
        );
  }
}
