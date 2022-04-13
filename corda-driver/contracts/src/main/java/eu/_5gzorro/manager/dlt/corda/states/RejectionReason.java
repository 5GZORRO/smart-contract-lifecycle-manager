package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.StaticPointer;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@BelongsToContract(ProductOrderContract.class)
public class RejectionReason implements ContractState {
  private final Party buyer;
  private final Party seller;

  private final UniqueIdentifier orderId;
  private final StaticPointer<ProductOrder> productOrderRef;
  private final String rejectionReason;

  @ConstructorForDeserialization
  public RejectionReason(Party buyer, Party seller, UniqueIdentifier orderId, StaticPointer<ProductOrder> productOrderRef, String rejectionReason) {
    this.buyer = buyer;
    this.seller = seller;
    this.orderId = orderId;
    this.productOrderRef = productOrderRef;
    this.rejectionReason = rejectionReason;
  }

  @NotNull
  @Override
  public List<AbstractParty> getParticipants() {
    return Arrays.asList(buyer, seller);
  }

  public Party getBuyer() {
    return buyer;
  }

  public Party getSeller() {
    return seller;
  }

  public StaticPointer<ProductOrder> getProductOrderRef() {
    return productOrderRef;
  }

  public String getRejectionReason() {
    return rejectionReason;
  }

  public UniqueIdentifier getOrderId() {
    return orderId;
  }
}
