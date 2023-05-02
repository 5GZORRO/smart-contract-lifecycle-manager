package eu._5gzorro.manager.dlt.corda.service.product_order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;
import eu._5gzorro.config.CustomInstantDeserializer;
import eu._5gzorro.config.CustomOffsetDateTimeSerializer;
import eu._5gzorro.elicense.models.LicenseTerm;
import eu._5gzorro.manager.dlt.corda.flows.product_order.EndProductOrderFlow;
import eu._5gzorro.manager.dlt.corda.flows.product_order.PublishProductOrderFlow;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOrderDetails;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.domain.events.ProductOrderUpdateEvent;
import eu._5gzorro.manager.domain.events.enums.OrderUpdateType;
import eu._5gzorro.manager.service.ProductOrderDriver;
import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import eu._5gzorro.tm_forum.models.product_order.ProductOrderDto;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import kotlin.Pair;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.messaging.FlowHandle;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.QueryCriteria;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.OffsetDateTime;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class CordaProductOrderDriver extends RPCSyncService<eu._5gzorro.manager.dlt.corda.states.ProductOrder> implements ProductOrderDriver {
    private static final Logger log = LoggerFactory.getLogger(CordaProductOrderDriver.class);

    private final DIDToDLTIdentityService didToDLTIdentityService;
    private final CordaRPCOps rpcClient;
    private final ReplaySubject<CordaProductOrderDriver.UpdateWrapper> subject = ReplaySubject.create();

    private final List<String> governanceNodeNames;
    private final List<String> regulatorNodeNames;

    public CordaProductOrderDriver(
        DIDToDLTIdentityService didToDLTIdentityService,
        NodeRPC nodeRPC,
        List<String> governanceNodeNames,
        List<String> regulatorNodeNames) {
        super(nodeRPC, eu._5gzorro.manager.dlt.corda.states.ProductOrder.class);
        this.didToDLTIdentityService = didToDLTIdentityService;
        this.rpcClient = nodeRPC.getClient();
        this.governanceNodeNames = governanceNodeNames;
        this.regulatorNodeNames = regulatorNodeNames;
        setup();
    }

    @Override
    public void setup() {
        QueryCriteria.VaultQueryCriteria unconsumedCriteria =
            new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.UNCONSUMED);

        this.beginTracking(
            unconsumedCriteria,
            this::handleUpdate,
            stateAndRef ->
                subject.onNext(
                    new CordaProductOrderDriver.UpdateWrapper()
                        .setProductOrder(stateAndRef.getState().getData())
                        .setDeduplicationId(stateAndRef.getRef().getTxhash().toString())
                        .setUpdateType(OrderUpdateType.PUBLISH)
                )
        );

        QueryCriteria.VaultQueryCriteria consumedCriteria =
            new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.CONSUMED);

        this.beginTrackingConsumed(
            consumedCriteria,
            this::handleDelete,
            stateAndRef ->
                subject.onNext(
                    new CordaProductOrderDriver.UpdateWrapper()
                        .setProductOrder(stateAndRef.getState().getData())
                        .setDeduplicationId(stateAndRef.getRef().getTxhash().toString())
                        .setUpdateType(OrderUpdateType.END)
                )
        );
    }

    private void handleUpdate(@NotNull final Vault.Update<eu._5gzorro.manager.dlt.corda.states.ProductOrder> update) {
        Optional<StateAndRef<eu._5gzorro.manager.dlt.corda.states.ProductOrder>> optionalConsumed = update.getConsumed().stream().findAny();

        OrderUpdateType updateType;

        if (optionalConsumed.isPresent()) {
            updateType = OrderUpdateType.UPDATE;
        } else {
            updateType = OrderUpdateType.PUBLISH;
        }

        update.getProduced().forEach(
            order ->
                subject.onNext(
                    new CordaProductOrderDriver.UpdateWrapper()
                        .setProductOrder(order.getState().getData())
                        .setDeduplicationId(order.getRef().getTxhash().toString())
                        .setUpdateType(updateType)
                )
        );
    }

    private void handleDelete(@NotNull final Vault.Update<eu._5gzorro.manager.dlt.corda.states.ProductOrder> delete) {
        delete.getConsumed().forEach(
            order ->
                subject.onNext(
                    new CordaProductOrderDriver.UpdateWrapper()
                        .setProductOrder(order.getState().getData())
                        .setDeduplicationId(order.getRef().getTxhash().toString())
                        .setUpdateType(OrderUpdateType.END)
                )
        );
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

    private Party findGovernanceNode() {
        return governanceNodeNames.stream()
            .map(CordaX500Name::parse)
            .map(rpcClient::wellKnownPartyFromX500Name)
            .findAny()
            .orElseThrow(() -> new RuntimeException("No governance node was found"));
    }

    private Party findRegulatorNode() {
        return regulatorNodeNames.stream()
            .map(CordaX500Name::parse)
            .map(rpcClient::wellKnownPartyFromX500Name)
            .findAny()
            .orElseThrow(() -> new RuntimeException("No regulator node was found"));
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

                return new ProductOrderUpdateEvent()
                    .setUpdateType(updateWrapper.getUpdateType())
                    .setDeduplicationId(updateWrapper.getDeduplicationId())
                    .setProductOrder(productOrder.getProductOrder())
                    .setDid(productOrder.getOfferDid())
                    .setInvitations(productOrder.getDidInvitations())
                    .setIdentifier(productOrder.getLinearId().getId().toString())
                    .setDeleted(updateWrapper.getUpdateType().equals(OrderUpdateType.END))
                    .setSpectrum(OfferType.SPECTRUM.equals(productOrder.getOfferType()))
                    .setSellerName(productOrder.getSeller().getName().toString());
            });
    }

    @Override
    public void publishProductOrder(
        ProductOrderDetails orderDetails,
        Map<String, Invitation> invitations,
        Collection<VerifiableCredential> verifiableCredentials,
        VerifiableCredential identityCredential,
        List<ServiceLevelAgreement> serviceLevelAgreements,
        List<Pair<LicenseTerm, String>> licenseTerms) {

        log.info("Publishing Product Order.");

        log.info("Retrieving Ledger Identity for Supplier DID {}.", orderDetails.getSupplierDid());
        String x500Name = didToDLTIdentityService.resolveIdentity(orderDetails.getSupplierDid());
        log.info("x500 name Ledger Identity: " + x500Name);
        log.info("Ledger Identity retrieved.");

        Party supplier = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse(x500Name));
//        Party supplier = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse("O=OperatorB,OU=Zurich,L=47.38/8.54/Zurich,C=CH"));
//        Party supplier = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse("O=OperatorC,OU=Barcelona,L=41.39/2.15/Barcelona,C=ES"));
        log.info("supplier: {}", supplier != null ? supplier.toString() : null);

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(OffsetDateTime.class, new CustomOffsetDateTimeSerializer());
        objectMapper.registerModule(module);

        OfferType offerType;
        if ("Spectrum".equals(orderDetails.getProductOrder().getCategory())) {
            offerType = OfferType.SPECTRUM;
        } else {
            offerType = OfferType.GENERAL;
        }

        ProductOrder productOrderState =
            new ProductOrder(
                new UniqueIdentifier(),
                rpcClient.nodeInfo().getLegalIdentities().get(0),
                supplier,
                findGovernanceNode(),
                findRegulatorNode(),
                null, // TODO
                null,
                OrderState.PROPOSED,
                offerType,
                orderDetails.getValidFor(),
                invitations,
                orderDetails.getProductOrder(),
                orderDetails.getSupplierDid(),
                orderDetails.getOrderDid()
            );

        log.info("Starting Publish flow for Product Order {}.", orderDetails.getProductOrder().getId());

        rpcClient.startFlowDynamic(PublishProductOrderFlow.PublishProductOrderInitiator.class,
            productOrderState, orderDetails.getOrderDid(), serviceLevelAgreements, licenseTerms);
    }

    @Override
    public void endProductOrder(String orderDid, String offerDid) throws ExecutionException, InterruptedException {
        FlowHandle<UniqueIdentifier> uniqueIdentifierFlowHandle = rpcClient.startFlowDynamic(EndProductOrderFlow.EndProductOrderInitiator.class, orderDid, offerDid);
        uniqueIdentifierFlowHandle.getReturnValue().toCompletableFuture().get();
    }

    @Override
    public List<ProductOrderDto> getOwnProductOrder() {
        Vault.Page<ProductOrder> productOrderPage = rpcClient.vaultQuery(ProductOrder.class);
        List<ProductOrderDto> productOrderDtos = new ArrayList<>();
        for (StateAndRef<ProductOrder> productOrderStateAndRef : productOrderPage.getStates()) {
            ProductOrder productOrder = productOrderStateAndRef.getState().getData();
            if (productOrder.getBuyer().equals(rpcClient.nodeInfo().getLegalIdentities().get(0))) {
                productOrderDtos.add(convertToDto(productOrder));
            }
        }
        return productOrderDtos;
    }

    private ProductOrderDto convertToDto(ProductOrder productOrder) {
        return new ProductOrderDto(productOrder.getSeller().getName().toString(), productOrder.getOfferDid(), new Date(productOrder.getProductOrder().getRequestedCompletionDate()));
    }

}
