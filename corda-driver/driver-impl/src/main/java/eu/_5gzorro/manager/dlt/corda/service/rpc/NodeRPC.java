package eu._5gzorro.manager.dlt.corda.service.rpc;

import static kotlin.collections.SetsKt.setOf;

import javax.annotation.PostConstruct;
import net.corda.client.rpc.CordaRPCClient;
import net.corda.client.rpc.CordaRPCConnection;
import net.corda.client.rpc.GracefulReconnect;
import net.corda.core.contracts.ContractState;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.messaging.DataFeed;
import net.corda.core.node.services.Vault.Page;
import net.corda.core.node.services.Vault.Update;
import net.corda.core.node.services.vault.PageSpecification;
import net.corda.core.node.services.vault.QueryCriteria;
import net.corda.core.node.services.vault.Sort;
import net.corda.core.node.services.vault.SortAttribute;
import net.corda.core.utilities.NetworkHostAndPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NodeRPC {

  private static final Logger log = LoggerFactory.getLogger(NodeRPC.class);

  private final String host;
  private final int rpcPort;
  private final String username;
  private final String password;

  private CordaRPCConnection rpcConnection;
  private CordaRPCOps client;

  public NodeRPC(
      String host,
      int rpcPort,
      String username,
      String password) {
    this.host = host;
    this.rpcPort = rpcPort;
    this.username = username;
    this.password = password;
  }

  @PostConstruct
  public void initialiseNodeRPCConnection() {
    GracefulReconnect gracefulReconnect = new GracefulReconnect(
        () -> {
          log.info("on disconnect");
        },
        () -> {
          log.info("on reconnect");

        }
    );
    NetworkHostAndPort rpcAddress = new NetworkHostAndPort(host, rpcPort);
    CordaRPCClient rpcClient = new CordaRPCClient(rpcAddress);
    rpcConnection = rpcClient.start(username, password, gracefulReconnect);
    client = rpcConnection.getProxy();
  }

  public CordaRPCOps getClient() {
    return client;
  }

  public <T extends ContractState> DataFeed<Page<T>, Update<T>>
  startTracking(Class<T> clazz, QueryCriteria queryCriteria) {
    PageSpecification pageSpecification = new PageSpecification();
    SortAttribute sortAttribute = new SortAttribute.Standard(Sort.CommonStateAttribute.STATE_REF_TXN_ID);
    Sort sort = new Sort(setOf(new Sort.SortColumn(sortAttribute, Sort.Direction.ASC)));

    return client.vaultTrackBy(queryCriteria, pageSpecification, sort, clazz);
  }
}
