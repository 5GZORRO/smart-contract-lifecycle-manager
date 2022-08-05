package eu._5gzorro.manager.dlt.corda.flows.product_order;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.elicense.models.LicenseTerm;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import eu._5gzorro.manager.dlt.corda.flows.license.PublishLicenseTermFlow;
import eu._5gzorro.manager.dlt.corda.flows.sla.PublishServiceLevelAgreementFlow;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.LTState;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.models.types.SLAState;
import eu._5gzorro.manager.dlt.corda.states.LicenseTermState;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.dlt.corda.states.ServiceLevelAgreementState;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;

import static net.corda.core.contracts.ContractsDSL.requireThat;

@InitiatingFlow
public class PublishProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {

  private final ProductOrder productOrder;
  private final String productOrderDID;
  private final Set<FlowSession> sessions;
  private final List<ServiceLevelAgreement> serviceLevelAgreements;
  private final List<Pair<LicenseTerm, String>> licenseTerms;

  public PublishProductOrderFlow(ProductOrder productOrder,
                                 String productOrderDID,
                                 Set<FlowSession> sessions,
                                 List<ServiceLevelAgreement> serviceLevelAgreements,
                                 List<Pair<LicenseTerm, String>> licenseTerms) {
    this.productOrder = productOrder;
    this.productOrderDID = productOrderDID;
    this.sessions = sessions;
    this.serviceLevelAgreements = serviceLevelAgreements;
    this.licenseTerms = licenseTerms;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    List<PublicKey> requiredSigners = productOrder.getRequiredSigners();

    Command<ProductOrderContract.ProductOrderCommand.Publish> command =
        new Command<>(new ProductOrderContract.ProductOrderCommand.Publish(), requiredSigners);

    TransactionBuilder txBuilder =
        new TransactionBuilder(firstNotary()).addCommand(command).addOutputState(productOrder);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);

    // Add spectrum session if spectrum offer
    if (productOrder.getOfferType() == OfferType.SPECTRUM) {
      sessions.add(initiateFlow(productOrder.getSpectrumRegulator()));
    }

    signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

    subFlow(new FinalityFlow(signedTransaction, sessions));

    for(ServiceLevelAgreement serviceLevelAgreement : serviceLevelAgreements) {
      ServiceLevelAgreementState serviceLevelAgreementState =
              new ServiceLevelAgreementState(
                      new UniqueIdentifier(),
                      serviceLevelAgreement,
                      SLAState.IN_PLACE,
                      productOrderDID,
                      productOrder.getBuyer(),
                      productOrder.getSeller(),
                      productOrder.getGovernanceParty());

      subFlow(new PublishServiceLevelAgreementFlow.PublishServiceLevelAgreementFlowInitiator(serviceLevelAgreementState));
    }

    for(Pair<LicenseTerm, String> licenseTerm : licenseTerms) {
      LicenseTermState licenseTermState =
              new LicenseTermState(
                      new UniqueIdentifier(),
                      licenseTerm.component1(),
                      LTState.IN_PLACE,
                      productOrderDID,
                      licenseTerm.component2(),
                      productOrder.getBuyer(),
                      productOrder.getSeller(),
                      productOrder.getGovernanceParty()
              );

      subFlow(new PublishLicenseTermFlow.PublishLicenseTermFlowInitiator(licenseTermState));
    }

    return productOrder.getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class PublishProductOrderInitiator extends ExtendedFlowLogic<UniqueIdentifier> {

    private final ProductOrder productOrder;
    private final String productOrderDID;
    private final List<ServiceLevelAgreement> serviceLevelAgreements;
    private final List<Pair<LicenseTerm, String>> licenseTerms;

    public PublishProductOrderInitiator(ProductOrder productOrder,
                                        String productOrderDID,
                                        List<ServiceLevelAgreement> serviceLevelAgreements,
                                        List<Pair<LicenseTerm, String>> licenseTerms) {
      this.productOrder = productOrder;
      this.productOrderDID = productOrderDID;
      this.serviceLevelAgreements = serviceLevelAgreements;
      this.licenseTerms = licenseTerms;
    }

    @Suspendable
    @Override
    public UniqueIdentifier call() throws FlowException {
      // Open sessions with all other nodes as we want to share product offering with them
      Set<FlowSession> sessions =
          initiateFlows(SetsKt.setOf(productOrder.getSeller(), productOrder.getGovernanceParty()));

      return subFlow(new PublishProductOrderFlow(productOrder, productOrderDID,
              sessions, serviceLevelAgreements, licenseTerms));
    }
  }

  @InitiatedBy(PublishProductOrderInitiator.class)
  public static class PublishProductOrderResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public PublishProductOrderResponder(FlowSession counterParty) {
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      subFlow(
          new SignTransactionFlow(counterParty) {
            @Override
            protected void checkTransaction(SignedTransaction stx) throws FlowException {
              requireThat(
                  require -> {
                    ProductOrder productOrder =
                        (ProductOrder) stx.getCoreTransaction().getOutput(0);

                    // TODO perform various checks here i.e if spectrum party then check operator
                    // authorised on this spectrum

                    return null;
                  });
            }
          });

      return subFlow(new ReceiveFinalityFlow(counterParty));
    }
  }
}
