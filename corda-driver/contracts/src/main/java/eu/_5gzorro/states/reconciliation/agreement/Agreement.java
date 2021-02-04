package eu._5gzorro.states.reconciliation.agreement;

import eu._5gzorro.contracts.EstablishAgreementContract;
import eu._5gzorro.models.types.AgreementStatus;
import java.util.List;
import kotlin.collections.CollectionsKt;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

@BelongsToContract(EstablishAgreementContract.class)
public class Agreement implements LinearState {
  private AgreementStatus status;
  private UniqueIdentifier linearId;
  private Party proposer;
  private Party proposee;

  public Agreement(
      AgreementStatus status,
      UniqueIdentifier linearId,
      Party proposer,
      Party proposee) {
    this.status = status;
    this.linearId = linearId;
    this.proposer = proposer;
    this.proposee = proposee;
  }

  @NotNull
  @Override
  public UniqueIdentifier getLinearId() {
    return this.linearId;
  }

  @NotNull
  @Override
  public List<AbstractParty> getParticipants() {
    return CollectionsKt.listOf(proposer, proposee);
  }

  public AgreementStatus getStatus() {
    return status;
  }

  public Party getProposer() {
    return proposer;
  }

  public Party getProposee() {
    return proposee;
  }

  public static final class ReconciliationAgreementBuilder {
    private AgreementStatus status;
    private UniqueIdentifier linerId;
    private Party proposer;
    private Party proposee;

    public ReconciliationAgreementBuilder() {}

    public static ReconciliationAgreementBuilder aReconciliationAgreement() {
      return new ReconciliationAgreementBuilder();
    }

    public ReconciliationAgreementBuilder copy(Agreement agreement) {
      this.status = agreement.status;
      this.linerId = agreement.linearId;
      this.proposer = agreement.proposer;
      this.proposee = agreement.proposee;
      return this;
    }

    public ReconciliationAgreementBuilder setStatus(AgreementStatus status) {
      this.status = status;
      return this;
    }

    public ReconciliationAgreementBuilder setLinerId(UniqueIdentifier linerId) {
      this.linerId = linerId;
      return this;
    }

    public ReconciliationAgreementBuilder setProposer(Party proposer) {
      this.proposer = proposer;
      return this;
    }

    public ReconciliationAgreementBuilder setProposee(Party proposee) {
      this.proposee = proposee;
      return this;
    }

    public Agreement build() {
      return new Agreement(status, linerId, proposer, proposee);
    }
  }
}
