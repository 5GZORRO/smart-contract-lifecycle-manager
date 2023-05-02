package eu._5gzorro.manager.dlt.corda.flows.regulator;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import net.corda.core.flows.*;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.util.Collections;

import static net.corda.core.contracts.ContractsDSL.requireThat;

@InitiatingFlow
public class GatherRegulatorSignatureFlow extends ExtendedFlowLogic<SignedTransaction> {
  private final SignedTransaction partiallySignedTx;
  private final Party regulatorParty;

  public GatherRegulatorSignatureFlow(
      SignedTransaction partiallySignedTx,
      Party regulatorParty) {
    this.partiallySignedTx = partiallySignedTx;
    this.regulatorParty = regulatorParty;
  }

  @Suspendable
  @Override
  public SignedTransaction call() throws FlowException {
    return subFlow(new CollectSignaturesFlow(
        partiallySignedTx,
        Collections.singletonList(initiateFlow(regulatorParty)))
    );
  }

  @InitiatedBy(GatherRegulatorSignatureFlow.class)
  public static class GatherRegulatorSignatureResponder extends ExtendedFlowLogic<SignedTransaction> {

    private final FlowSession counterPartySession;

    public GatherRegulatorSignatureResponder(FlowSession counterPartySession) {
      this.counterPartySession = counterPartySession;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      SignTransactionFlow flow = new SignTransactionFlow(counterPartySession) {
        @Override
        protected void checkTransaction(SignedTransaction stx) throws FlowException {
          requireThat(require -> {
            require.using("Signed everything for now", true);
            // TODO perform necessary checks by regulator node
            return null;
          });
        }
      };

      return subFlow(flow);
    }
  }
}
