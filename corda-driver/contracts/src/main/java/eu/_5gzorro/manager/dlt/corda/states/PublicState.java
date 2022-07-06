package eu._5gzorro.manager.dlt.corda.states;

import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class PublicState implements ContractState, LinearState {

  private UniqueIdentifier id;
  private Party owner;

  public PublicState(UniqueIdentifier id, Party owner) {
    this.id = id;
    this.owner = owner;
  }

  @NotNull
  @Override
  public List<AbstractParty> getParticipants() {
    List<AbstractParty> parties = Arrays.asList(owner);
    return parties;
  }

  @NotNull
  @Override
  public UniqueIdentifier getLinearId() {
    return id;
  }

  public Party getOwner() {
    return owner;
  }
}
