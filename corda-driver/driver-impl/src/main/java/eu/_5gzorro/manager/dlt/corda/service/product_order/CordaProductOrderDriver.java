package eu._5gzorro.manager.dlt.corda.service.product_order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;
import eu._5gzorro.config.CustomInstantDeserializer;
import eu._5gzorro.config.CustomOffsetDateTimeSerializer;
import eu._5gzorro.manager.dlt.corda.flows.product_order.*;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.dlt.corda.states.RejectionReason;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOrderDetails;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.domain.events.ProductOrderUpdateEvent;
import eu._5gzorro.manager.domain.events.enums.OrderUpdateType;
import eu._5gzorro.manager.service.ProductOrderDriver;
import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import eu._5gzorro.manager.utils.ZipUtils;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.crypto.SecureHash;
import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.messaging.DataFeed;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.QueryCriteria;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.OffsetDateTime;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CordaProductOrderDriver
    extends RPCSyncService<eu._5gzorro.manager.dlt.corda.states.ProductOrder>
    implements ProductOrderDriver {
  private static final Logger log = LoggerFactory.getLogger(CordaProductOrderDriver.class);

  private final DIDToDLTIdentityService didToDLTIdentityService;
  private final CordaRPCOps rpcClient;
  private final ReplaySubject<CordaProductOrderDriver.UpdateWrapper> subject =
      ReplaySubject.create();

  private final List<String> governanceNodeNames;

  public CordaProductOrderDriver(
      DIDToDLTIdentityService didToDLTIdentityService,
      NodeRPC nodeRPC,
      List<String> governanceNodeNames) {
    super(nodeRPC, eu._5gzorro.manager.dlt.corda.states.ProductOrder.class);
    this.didToDLTIdentityService = didToDLTIdentityService;
    this.rpcClient = nodeRPC.getClient();
    this.governanceNodeNames = governanceNodeNames;
    setup();
  }

  @Override
  public void setup() {
    QueryCriteria.VaultQueryCriteria criteria =
        new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.UNCONSUMED);

    this.beginTracking(
        criteria,
        this::handleUpdate,
        stateAndRef ->
            subject.onNext(
                new CordaProductOrderDriver.UpdateWrapper()
                    .setProductOrder(stateAndRef.getState().getData())
                    .setDeduplicationId(stateAndRef.getRef().getTxhash().toString())
                    .setUpdateType(OrderUpdateType.PUBLISH)));

    trackRejections();
  }

  private void handleUpdate(
      @NotNull final Vault.Update<eu._5gzorro.manager.dlt.corda.states.ProductOrder> update) {
    Optional<StateAndRef<eu._5gzorro.manager.dlt.corda.states.ProductOrder>> optionalConsumed =
        update.getConsumed().stream().findAny();
    Optional<StateAndRef<eu._5gzorro.manager.dlt.corda.states.ProductOrder>> optionalProduced =
        update.getProduced().stream().findAny();

    OrderUpdateType updateType = null;

    if (optionalConsumed.isPresent()) {
      ProductOrder consumedOrder = optionalConsumed.get().getState().getData();

      OrderState consumedOrderState = consumedOrder.getState();

      if (optionalProduced.isPresent()) { // must be approved
        OrderState producedOrderState = optionalProduced.get().getState().getData().getState();
        if (consumedOrderState == OrderState.PROPOSED
            && producedOrderState == OrderState.APPROVED) { // approved
          updateType = OrderUpdateType.APPROVE;
        } else if (consumedOrderState == OrderState.APPROVED
            && producedOrderState == OrderState.ACTIVE) { // provisioned
          updateType = OrderUpdateType.PROVISION;
        } else if (consumedOrderState == OrderState.ACTIVE
            && producedOrderState == OrderState.CHANGE_ACTIVE) { // approved
          updateType = OrderUpdateType.PROPOSE_CHANGE;
        } else if (consumedOrderState == OrderState.CHANGE_ACTIVE
            && producedOrderState == OrderState.APPROVED) { // accept change
          updateType = OrderUpdateType.ACCEPT_CHANGE;
        } else if (consumedOrderState == OrderState.CHANGE_ACTIVE
            && producedOrderState == OrderState.ACTIVE) { // reject change
          updateType = OrderUpdateType.REJECT_CHANGE;
        }
      } else {
        updateType = OrderUpdateType.END;
      }
    }

    OrderUpdateType finalUpdateType = updateType;
    update
        .getProduced()
        .forEach(
            produced ->
                subject.onNext(
                    new CordaProductOrderDriver.UpdateWrapper()
                        .setProductOrder(produced.getState().getData())
                        .setDeduplicationId(produced.getRef().getTxhash().toString())
                        .setUpdateType(finalUpdateType)));
  }

  public static class UpdateWrapper {
    private eu._5gzorro.manager.dlt.corda.states.ProductOrder productOrder;
    private OrderUpdateType updateType;
    private String deduplicationId;

    public eu._5gzorro.manager.dlt.corda.states.ProductOrder getProductOrder() {
      return productOrder;
    }

    public CordaProductOrderDriver.UpdateWrapper setProductOrder(
        eu._5gzorro.manager.dlt.corda.states.ProductOrder productOrder) {
      this.productOrder = productOrder;
      return this;
    }

    public OrderUpdateType getUpdateType() {
      return updateType;
    }

    public CordaProductOrderDriver.UpdateWrapper setUpdateType(OrderUpdateType updateType) {
      this.updateType = updateType;
      return this;
    }

    public String getDeduplicationId() {
      return deduplicationId;
    }

    public UpdateWrapper setDeduplicationId(String deduplicationId) {
      this.deduplicationId = deduplicationId;
      return this;
    }
  }

  private void trackRejections() {
    QueryCriteria.VaultQueryCriteria criteria =
        new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.UNCONSUMED);

    rpcClient
        .vaultQueryByCriteria(criteria, RejectionReason.class)
        .getStates()
        .forEach(
            record ->
                subject.onNext(
                    new UpdateWrapper()
                        .setProductOrder(new ProductOrder(record.getState().getData().getOrderId()))
                        .setUpdateType(OrderUpdateType.REJECT)));

    DataFeed<Vault.Page<RejectionReason>, Vault.Update<RejectionReason>> dataFeed =
        client.startTracking(RejectionReason.class, criteria);

    dataFeed
        .getUpdates()
        .subscribe(
            updateRecord ->
                updateRecord
                    .getProduced()
                    .forEach(
                        produced ->
                            subject.onNext(
                                new UpdateWrapper()
                                    .setProductOrder(
                                        new ProductOrder(
                                            produced.getState().getData().getOrderId()))
                                    .setDeduplicationId(produced.getRef().getTxhash().toString())
                                    .setUpdateType(OrderUpdateType.REJECT))),
            error -> log.error("Error in {} tracking", RejectionReason.class.getName(), error),
            () -> {});
  }

  private Party findGovernanceNode() {
    return governanceNodeNames.stream()
        .map(CordaX500Name::parse)
        .map(rpcClient::wellKnownPartyFromX500Name)
        .findAny()
        .orElseThrow(() -> new RuntimeException("No governance node was found"));
  }

  @Override
  public Observable<ProductOrderUpdateEvent> productOrderObservable() {
    return subject.map(
        updateWrapper -> {
          ProductOrder productOrder = updateWrapper.getProductOrder();

          ObjectMapper objectMapper = new ObjectMapper();
          ThreeTenModule module = new ThreeTenModule();
          module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
          objectMapper.registerModule(module);
          ProductOrderDetails order = objectMapper.convertValue(ZipUtils.unzipObject(
                  rpcClient.openAttachment(productOrder.getModel()), objectMapper), ProductOrderDetails.class);

          return new ProductOrderUpdateEvent()
              .setUpdateType(updateWrapper.getUpdateType())
              .setDeduplicationId(updateWrapper.getDeduplicationId())
              .setProductOrder(order.getProductOrder())
              .setDid(order.getSupplierDid())
              .setInvitations(productOrder.getDidInvitations())
              .setIdentifier(productOrder.getLinearId().getId().toString());
        });
  }

  @Override
  public void publishProductOrder(
      ProductOrderDetails orderDetails,
      Map<String, Invitation> invitations,
      Collection<VerifiableCredential> verifiableCredentials,
      VerifiableCredential identityCredential) {
    log.info("Publishing Product Order.");

    log.info("Retrieving Ledger Identity for Supplier DID {}.", orderDetails.getSupplierDid());
    String x500Name = didToDLTIdentityService.resolveIdentity(orderDetails.getSupplierDid());
    log.info("Ledger Identity retrieved.");

    Party supplier = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse(x500Name));
    ObjectMapper objectMapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addSerializer(OffsetDateTime.class, new CustomOffsetDateTimeSerializer());
    objectMapper.registerModule(module);

    try {
      ProductOrder productOrderState =
          new ProductOrder(
              new UniqueIdentifier(),
              rpcClient.nodeInfo().getLegalIdentities().get(0),
              supplier,
              findGovernanceNode(),
              null, // spectrumRegulator
              null, // TODO
              rpcClient.uploadAttachment(ZipUtils.zipObject(orderDetails, objectMapper)),
              null,
              OrderState.PROPOSED,
              OfferType.GENERAL, // TODO
              orderDetails.getValidFor(),
              invitations);

      rpcClient.startFlowDynamic(PublishProductOrderFlow.PublishProductOrderInitiator.class, productOrderState);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void approveProductOrder(String orderId) {
    rpcClient.startFlowDynamic(
        ApproveProductOrderFlow.ApproveProductOrderInitiator.class,
        UniqueIdentifier.Companion.fromString(orderId));
  }

  @Override
  public void acceptChangeProposalProductOrder(String orderId) {
    rpcClient.startFlowDynamic(
        AcceptChangeProductOrderFlow.AcceptChangeProductOrderInitiator.class,
        UniqueIdentifier.Companion.fromString(orderId));
  }

  @Override
  public void endProductOrder(String orderId) {
    rpcClient.startFlowDynamic(
        EndProductOrderFlow.EndProductOrderInitiator.class,
        UniqueIdentifier.Companion.fromString(orderId));
  }

  @Override
  public void proposeChangeProductOrder(
      String orderId, ProductOrderDetails orderDetails, Map<String, Invitation> invitations) {

    try {
      SecureHash attachmentHash =
          rpcClient.uploadAttachment(ZipUtils.zipObject(orderDetails, new ObjectMapper()));

      rpcClient.startFlowDynamic(
          ProposeChangeProductOrderFlow.ProposeChangeProductOrderInitiator.class,
          UniqueIdentifier.Companion.fromString(orderId),
          attachmentHash,
          null,
          OfferType.GENERAL, // TODO
          orderDetails.getValidFor(),
          invitations);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void provisionProductOrder(String orderId) {
    rpcClient.startFlowDynamic(
        ProvisionProductOrderFlow.ProvisionProductOrderInitiator.class,
        UniqueIdentifier.Companion.fromString(orderId));
  }

  @Override
  public void rejectChangeProductOrder(String orderId) {
    rpcClient.startFlowDynamic(
        RejectChangeProductOrderFlow.RejectChangeProductOrderInitiator.class,
        UniqueIdentifier.Companion.fromString(orderId));
  }

  @Override
  public void rejectProductOrder(String orderId, String rejectionReason) {
    rpcClient.startFlowDynamic(
        RejectProductOrderFlow.RejectProductOrderInitiator.class,
        UniqueIdentifier.Companion.fromString(orderId),
        rejectionReason);
  }
}
