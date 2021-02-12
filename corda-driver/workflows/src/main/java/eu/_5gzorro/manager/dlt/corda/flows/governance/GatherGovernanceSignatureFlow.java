package eu._5gzorro.manager.dlt.corda.flows.governance;

import static net.corda.core.contracts.ContractsDSL.requireThat;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import java.util.Collections;
import net.corda.core.flows.CollectSignaturesFlow;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowSession;
import net.corda.core.flows.InitiatedBy;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.SignTransactionFlow;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

@InitiatingFlow
public class GatherGovernanceSignatureFlow extends ExtendedFlowLogic<SignedTransaction> {
  private final SignedTransaction partiallySignedTx;
  private final Party governanceParty;

  public GatherGovernanceSignatureFlow(
      SignedTransaction partiallySignedTx,
      Party governanceParty) {
    this.partiallySignedTx = partiallySignedTx;
    this.governanceParty = governanceParty;
  }

  @Suspendable
  @Override
  public SignedTransaction call() throws FlowException {
    return subFlow(new CollectSignaturesFlow(
        partiallySignedTx,
        Collections.singletonList(initiateFlow(governanceParty)))
    );
  }

  @InitiatedBy(GatherGovernanceSignatureFlow.class)
  public static class GatherGovernanceSignatureResponder extends ExtendedFlowLogic<SignedTransaction> {

    private final FlowSession counterPartySession;

    public GatherGovernanceSignatureResponder(FlowSession counterPartySession) {
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
            // TODO perform necessary checks by governance node
            return null;
          });
        }
      };

      return subFlow(flow);
    }
  }
}
