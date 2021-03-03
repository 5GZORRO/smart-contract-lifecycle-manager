package eu._5gzorro.manager.dlt.corda.oracle.flow;

import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.crypto.TransactionSignature;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.FlowSession;
import net.corda.core.transactions.FilteredTransaction;
import net.corda.core.transactions.FilteredTransactionVerificationException;
import net.corda.core.utilities.ProgressTracker;
import org.jetbrains.annotations.Nullable;
import eu._5gzorro.manager.dlt.corda.oracle.service.Oracle;

//@InitiatedBy(Object.class)
public class SignHandler extends FlowLogic<Void> {
  private static final ProgressTracker.Step RECEIVING = new ProgressTracker.Step("Receiving sign request.");
  private static final ProgressTracker.Step SIGNING = new ProgressTracker.Step(
      "Signing filtered transaction.");
  private static final ProgressTracker.Step SENDING = new ProgressTracker.Step("Sending sign response.");

  private final ProgressTracker progressTracker = new ProgressTracker(RECEIVING, SIGNING, SENDING);

  private final FlowSession session;

  public SignHandler(FlowSession session) {
    this.session = session;
  }

  @Nullable
  @Override
  public ProgressTracker getProgressTracker() {
    return progressTracker;
  }

  @Suspendable
  @Override
  public Void call() throws FlowException {
    progressTracker.setCurrentStep(RECEIVING);
    FilteredTransaction request = session.receive(FilteredTransaction.class).unwrap(it -> it);

    progressTracker.setCurrentStep(SIGNING);
    TransactionSignature response;
    try {
      response = getServiceHub().cordaService(Oracle.class).sign(request, session.getCounterparty());
    } catch (FilteredTransactionVerificationException e) {
      throw new FlowException(e);
    }

    progressTracker.setCurrentStep(SENDING);
    session.send(response);
    return null;
  }

}
