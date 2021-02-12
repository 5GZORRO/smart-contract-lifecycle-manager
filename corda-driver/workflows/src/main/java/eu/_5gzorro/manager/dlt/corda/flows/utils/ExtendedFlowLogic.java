package eu._5gzorro.manager.dlt.corda.flows.utils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.FlowSession;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.node.services.Vault.StateStatus;
import net.corda.core.node.services.vault.QueryCriteria;
import net.corda.core.node.services.vault.QueryCriteria.LinearStateQueryCriteria;

/**
 * Extends Corda's FlowLogic class to provide extra utility functions such as finding the first notary or
 * initiating flows with multiple parties
 * @see net.corda.core.flows.FlowLogic
 * @param <T> Flows return type
 */
public abstract class ExtendedFlowLogic<T> extends FlowLogic<T> {

  public Party firstNotary() {
    return getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
  }

  public Set<FlowSession> initiateFlows(Iterable<AbstractParty> parties) throws FlowException {
    HashSet<FlowSession> sessions = new HashSet<>();

    for(AbstractParty party : parties) {
      Optional<Party> wellKnownParty = Optional.ofNullable(getServiceHub().getIdentityService().wellKnownPartyFromAnonymous(party));

      if(!wellKnownParty.isPresent()) throw new FlowException("Cannot resolve party.");
      sessions.add(initiateFlow(wellKnownParty.get()));
    }

    return sessions;
  }

  public Party getPartyFromX500(CordaX500Name partyName) {
    Party oracle =
        getServiceHub()
            .getNetworkMapCache()
            .getNodeByLegalName(partyName)
            .getLegalIdentities()
            .get(0);
    if (oracle == null) throw new IllegalArgumentException("Party not found");
    return oracle;
  }

  public <R extends ContractState> StateAndRef<R> findStateWithLinearId(Class<R> type, UniqueIdentifier id) {
    QueryCriteria inputCriteria = new LinearStateQueryCriteria(
        null,
        CollectionsKt.listOf(id),
        StateStatus.UNCONSUMED,
        null);

    return getServiceHub()
        .getVaultService()
        .queryBy(type, inputCriteria)
        .getStates().get(0);
  }
}
