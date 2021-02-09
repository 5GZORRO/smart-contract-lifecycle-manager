package eu._5gzorro.flows.sync;

import static java.util.stream.Collectors.toList;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.states.PublicState;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.StateRef;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowSession;
import net.corda.core.flows.InitiatedBy;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.ReceiveTransactionFlow;
import net.corda.core.flows.SendTransactionFlow;
import net.corda.core.flows.StartableByService;
import net.corda.core.identity.AbstractParty;
import net.corda.core.node.StatesToRecord;
import net.corda.core.node.services.Vault.StateStatus;
import net.corda.core.node.services.vault.BinaryComparisonOperator;
import net.corda.core.node.services.vault.ColumnPredicate.BinaryComparison;
import net.corda.core.node.services.vault.QueryCriteria;
import net.corda.core.node.services.vault.QueryCriteria.LinearStateQueryCriteria;
import net.corda.core.node.services.vault.QueryCriteria.TimeCondition;
import net.corda.core.node.services.vault.QueryCriteria.TimeInstantType;
import net.corda.core.node.services.vault.QueryCriteria.VaultQueryCriteria;
import net.corda.core.node.services.vault.Sort;
import net.corda.core.node.services.vault.Sort.Direction;
import net.corda.core.node.services.vault.Sort.VaultStateAttribute;
import net.corda.core.node.services.vault.SortAttribute;
import net.corda.core.serialization.CordaSerializable;
import net.corda.core.transactions.SignedTransaction;

/**
 * Flow expects the contract state being synced to be extended from PublicState
 */
@InitiatingFlow
public class SyncPublicStatesFlow extends ExtendedFlowLogic<SignedTransaction> {
  private final Class<? extends PublicState> clazz;
  private final FlowSession counterPartySession;

  public SyncPublicStatesFlow(
      Class<? extends PublicState> clazz,
      FlowSession counterPartySession) {
    this.clazz = clazz;
    this.counterPartySession = counterPartySession;
  }

  @Suspendable
  @Override
  public SignedTransaction call() throws FlowException {
    SortAttribute sortAttribute = new SortAttribute.Standard(VaultStateAttribute.RECORDED_TIME);
    Sort sort = new Sort(SetsKt.setOf(new Sort.SortColumn(sortAttribute, Direction.DESC)));

    QueryCriteria criteria = new LinearStateQueryCriteria()
        .withParticipants(Collections.singletonList(counterPartySession.getCounterparty()));

    // Get hash of most recent recorded contract state on our node published from this counterparty
    List<? extends StateAndRef<? extends PublicState>> stateAndRefs = getServiceHub().getVaultService()
        .queryBy(clazz, criteria, sort)
        .getStates();

    SyncQuery query;
    if(stateAndRefs.isEmpty()) {
      query = new SyncQuery(null, clazz);
    } else {
      query = new SyncQuery(stateAndRefs.get(0).getRef(), clazz);
    }

    Integer numOfTxs = counterPartySession.sendAndReceive(Integer.class, query)
          .unwrap(x -> x);

    for(int i = 0; i < numOfTxs; i++) {
      subFlow(new ReceiveTransactionFlow(counterPartySession, true, StatesToRecord.ALL_VISIBLE));
    }

    return null;
  }

  @InitiatingFlow
  @StartableByService
  public static class SyncPublicStatesInitiator extends ExtendedFlowLogic<SignedTransaction> {
    private final Class<? extends PublicState> clazz;
    private final AbstractParty counterParty;

    public SyncPublicStatesInitiator(Class<? extends PublicState> clazz, AbstractParty counterParty) {
      this.clazz = clazz;
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      return subFlow(new SyncPublicStatesFlow(clazz, initiateFlow(counterParty)));
    }
  }

  @InitiatedBy(SyncPublicStatesInitiator.class)
  public static class SyncPublicStatesResponder extends ExtendedFlowLogic<Void> {
    private final FlowSession counterPartySession;

    public SyncPublicStatesResponder(FlowSession counterPartySession) {
      this.counterPartySession = counterPartySession;
    }

    @Suspendable
    @Override
    public Void call() throws FlowException {

      SyncQuery query = counterPartySession.receive(SyncQuery.class).unwrap(x -> x);

      List<? extends StateAndRef<? extends PublicState>> stateAndRefs;
      if (query.getStateRef() == null) {
        // Null means never synced before so start from beginning...
        stateAndRefs = getServiceHub()
            .getVaultService()
            .queryBy(query.getClazz())
            .getStates();
      } else {
        // Getting the time the state was recorded for queried StateRef
        QueryCriteria queryByStateRefCriteria = new VaultQueryCriteria()
            .withStateRefs(Arrays.asList(query.getStateRef()));
        Instant recordedTime = getServiceHub().getVaultService()
            .queryBy(query.getClazz(), queryByStateRefCriteria)
            .getStatesMetadata()
            .get(0)
            .getRecordedTime();

        // Getting the states recorded after that time.
        TimeCondition queryAfterTimeExpression = new TimeCondition(
            TimeInstantType.RECORDED,
            new BinaryComparison<>(BinaryComparisonOperator.GREATER_THAN_OR_EQUAL, recordedTime)
        );
        QueryCriteria queryAfterTimeCriteria = new VaultQueryCriteria()
            .withStatus(StateStatus.ALL)
            .withTimeCondition(queryAfterTimeExpression);

        stateAndRefs = getServiceHub()
            .getVaultService()
            .queryBy(query.getClazz(), queryAfterTimeCriteria)
            .getStates();
      }

      // Find the transaction that created this state.
      List<SignedTransaction> signedTxs = stateAndRefs.stream()
          .map(stateAndRef -> stateAndRef.getRef().getTxhash())
          .map(hash -> getServiceHub().getValidatedTransactions().getTransaction(hash))
          .collect(toList());

      counterPartySession.send(signedTxs.size());

      for(SignedTransaction tx : signedTxs) {
        subFlow(new SendTransactionFlow(counterPartySession, tx));
      }

      return null;
    }
  }

  @CordaSerializable
  public static class SyncQuery {
    private final StateRef stateRef;
    private final Class<? extends PublicState> clazz;

    public SyncQuery(StateRef stateRef, Class<? extends PublicState> clazz) {
      this.stateRef = stateRef;
      this.clazz = clazz;
    }

    public StateRef getStateRef() {
      return stateRef;
    }

    public Class<? extends PublicState> getClazz() {
      return clazz;
    }
  }
}
