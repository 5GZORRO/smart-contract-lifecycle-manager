package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

/** An identified part of the order. A product order is decomposed into one or more order items. */
public class OrderItem {
  private String id;
  private ActionType action;
  private StateType state;
  private Long quantity;
  private String atType;
  private String atSchemaLocation;
  private AppointmentRef appointment;
  private BillingAccountRef billingAccount;
  private List<OrderPrice> itemPrice = null;
  private List<OrderPrice> itemTotalPrice = null;
  private ProductOfferingRef productOffering;
  private Product product;
  private List<OrderItemRelationShip> orderItemRelationship = null;
  private List<QualificationRef> qualification = null;
  private List<PaymentRef> payment = null;
  private List<OrderTerm> itemTerm = null;
  private List<OrderItem> orderItem = null;

  public OrderItem id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the line item (generally it is a sequence number 01, 02, 03, ...)
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OrderItem action(ActionType action) {
    this.action = action;
    return this;
  }

  /**
   * Get action
   *
   * @return action
   */
  public ActionType getAction() {
    return action;
  }

  public void setAction(ActionType action) {
    this.action = action;
  }

  public OrderItem state(StateType state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   *
   * @return state
   */
  public StateType getState() {
    return state;
  }

  public void setState(StateType state) {
    this.state = state;
  }

  public OrderItem quantity(Long quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Quantity ordered
   *
   * @return quantity
   */
  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public OrderItem atType(String atType) {
    this.atType = atType;
    return this;
  }

  /**
   * Indicates the type of resource. Here it can be a type of productOrderItem.
   *
   * @return atType
   */
  public String getAtType() {
    return atType;
  }

  public void setAtType(String atType) {
    this.atType = atType;
  }

  public OrderItem atSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
    return this;
  }

  /**
   * An URL to the schema describing this REST resource.
   *
   * @return atSchemaLocation
   */
  public String getAtSchemaLocation() {
    return atSchemaLocation;
  }

  public void setAtSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
  }

  public OrderItem appointment(AppointmentRef appointment) {
    this.appointment = appointment;
    return this;
  }

  /**
   * Get appointment
   *
   * @return appointment
   */
  public AppointmentRef getAppointment() {
    return appointment;
  }

  public void setAppointment(AppointmentRef appointment) {
    this.appointment = appointment;
  }

  public OrderItem billingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  /**
   * Get billingAccount
   *
   * @return billingAccount
   */
  public BillingAccountRef getBillingAccount() {
    return billingAccount;
  }

  public void setBillingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
  }

  public OrderItem itemPrice(List<OrderPrice> itemPrice) {
    this.itemPrice = itemPrice;
    return this;
  }

  public OrderItem addItemPriceItem(OrderPrice itemPriceItem) {
    if (this.itemPrice == null) {
      this.itemPrice = new ArrayList<>();
    }
    this.itemPrice.add(itemPriceItem);
    return this;
  }

  /**
   * Get itemPrice
   *
   * @return itemPrice
   */
  public List<OrderPrice> getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(List<OrderPrice> itemPrice) {
    this.itemPrice = itemPrice;
  }

  public OrderItem itemTotalPrice(List<OrderPrice> itemTotalPrice) {
    this.itemTotalPrice = itemTotalPrice;
    return this;
  }

  public OrderItem addItemTotalPriceItem(OrderPrice itemTotalPriceItem) {
    if (this.itemTotalPrice == null) {
      this.itemTotalPrice = new ArrayList<>();
    }
    this.itemTotalPrice.add(itemTotalPriceItem);
    return this;
  }

  /**
   * Get itemTotalPrice
   *
   * @return itemTotalPrice
   */
  public List<OrderPrice> getItemTotalPrice() {
    return itemTotalPrice;
  }

  public void setItemTotalPrice(List<OrderPrice> itemTotalPrice) {
    this.itemTotalPrice = itemTotalPrice;
  }

  public OrderItem productOffering(ProductOfferingRef productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  /**
   * Get productOffering
   *
   * @return productOffering
   */
  public ProductOfferingRef getProductOffering() {
    return productOffering;
  }

  public void setProductOffering(ProductOfferingRef productOffering) {
    this.productOffering = productOffering;
  }

  public OrderItem product(Product product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   *
   * @return product
   */
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public OrderItem orderItemRelationship(List<OrderItemRelationShip> orderItemRelationship) {
    this.orderItemRelationship = orderItemRelationship;
    return this;
  }

  public OrderItem addOrderItemRelationshipItem(OrderItemRelationShip orderItemRelationshipItem) {
    if (this.orderItemRelationship == null) {
      this.orderItemRelationship = new ArrayList<>();
    }
    this.orderItemRelationship.add(orderItemRelationshipItem);
    return this;
  }

  /**
   * Get orderItemRelationship
   *
   * @return orderItemRelationship
   */
  public List<OrderItemRelationShip> getOrderItemRelationship() {
    return orderItemRelationship;
  }

  public void setOrderItemRelationship(List<OrderItemRelationShip> orderItemRelationship) {
    this.orderItemRelationship = orderItemRelationship;
  }

  public OrderItem qualification(List<QualificationRef> qualification) {
    this.qualification = qualification;
    return this;
  }

  public OrderItem addQualificationItem(QualificationRef qualificationItem) {
    if (this.qualification == null) {
      this.qualification = new ArrayList<>();
    }
    this.qualification.add(qualificationItem);
    return this;
  }

  /**
   * Get qualification
   *
   * @return qualification
   */
  public List<QualificationRef> getQualification() {
    return qualification;
  }

  public void setQualification(List<QualificationRef> qualification) {
    this.qualification = qualification;
  }

  public OrderItem payment(List<PaymentRef> payment) {
    this.payment = payment;
    return this;
  }

  public OrderItem addPaymentItem(PaymentRef paymentItem) {
    if (this.payment == null) {
      this.payment = new ArrayList<>();
    }
    this.payment.add(paymentItem);
    return this;
  }

  /**
   * Get payment
   *
   * @return payment
   */
  public List<PaymentRef> getPayment() {
    return payment;
  }

  public void setPayment(List<PaymentRef> payment) {
    this.payment = payment;
  }

  public OrderItem itemTerm(List<OrderTerm> itemTerm) {
    this.itemTerm = itemTerm;
    return this;
  }

  public OrderItem addItemTermItem(OrderTerm itemTermItem) {
    if (this.itemTerm == null) {
      this.itemTerm = new ArrayList<>();
    }
    this.itemTerm.add(itemTermItem);
    return this;
  }

  /**
   * Get itemTerm
   *
   * @return itemTerm
   */
  public List<OrderTerm> getItemTerm() {
    return itemTerm;
  }

  public void setItemTerm(List<OrderTerm> itemTerm) {
    this.itemTerm = itemTerm;
  }

  public OrderItem orderItem(List<OrderItem> orderItem) {
    this.orderItem = orderItem;
    return this;
  }

  public OrderItem addOrderItemItem(OrderItem orderItemItem) {
    if (this.orderItem == null) {
      this.orderItem = new ArrayList<>();
    }
    this.orderItem.add(orderItemItem);
    return this;
  }

  /**
   * Get orderItem
   *
   * @return orderItem
   */
  public List<OrderItem> getOrderItem() {
    return orderItem;
  }

  public void setOrderItem(List<OrderItem> orderItem) {
    this.orderItem = orderItem;
  }

  /** Return true if this OrderItem object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.id, orderItem.id)
        && Objects.equals(this.action, orderItem.action)
        && Objects.equals(this.state, orderItem.state)
        && Objects.equals(this.quantity, orderItem.quantity)
        && Objects.equals(this.atType, orderItem.atType)
        && Objects.equals(this.atSchemaLocation, orderItem.atSchemaLocation)
        && Objects.equals(this.appointment, orderItem.appointment)
        && Objects.equals(this.billingAccount, orderItem.billingAccount)
        && Objects.equals(this.itemPrice, orderItem.itemPrice)
        && Objects.equals(this.itemTotalPrice, orderItem.itemTotalPrice)
        && Objects.equals(this.productOffering, orderItem.productOffering)
        && Objects.equals(this.product, orderItem.product)
        && Objects.equals(this.orderItemRelationship, orderItem.orderItemRelationship)
        && Objects.equals(this.qualification, orderItem.qualification)
        && Objects.equals(this.payment, orderItem.payment)
        && Objects.equals(this.itemTerm, orderItem.itemTerm)
        && Objects.equals(this.orderItem, orderItem.orderItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        action,
        state,
        quantity,
        atType,
        atSchemaLocation,
        appointment,
        billingAccount,
        itemPrice,
        itemTotalPrice,
        productOffering,
        product,
        orderItemRelationship,
        qualification,
        payment,
        itemTerm,
        orderItem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
    sb.append("    atSchemaLocation: ").append(toIndentedString(atSchemaLocation)).append("\n");
    sb.append("    appointment: ").append(toIndentedString(appointment)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    itemPrice: ").append(toIndentedString(itemPrice)).append("\n");
    sb.append("    itemTotalPrice: ").append(toIndentedString(itemTotalPrice)).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    orderItemRelationship: ")
        .append(toIndentedString(orderItemRelationship))
        .append("\n");
    sb.append("    qualification: ").append(toIndentedString(qualification)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    itemTerm: ").append(toIndentedString(itemTerm)).append("\n");
    sb.append("    orderItem: ").append(toIndentedString(orderItem)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
