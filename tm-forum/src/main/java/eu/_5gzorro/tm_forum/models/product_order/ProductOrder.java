package eu._5gzorro.tm_forum.models.product_order;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import eu._5gzorro.tm_forum.models.sla.RelatedPartyRef;
import org.threeten.bp.OffsetDateTime;

public class ProductOrder {
  private String id;
  private String href;
  private String externalId;
  private PriorityType priority;
  private String description;
  private String category;
  private StateType state;
  private OffsetDateTime orderDate;
  private OffsetDateTime completionDate;
  private OffsetDateTime requestedStartDate;
  private OffsetDateTime requestedCompletionDate;
  private OffsetDateTime expectedCompletionDate;
  private String notificationContact;
  private String atBaseType;
  private String atType;
  private String atSchemaLocation;
  private Channel channel;
  private Note note;
  private List<RelatedPartyRef> relatedParty = null;
  private List<PaymentRef> payment = null;
  private BillingAccountRef billingAccount;
  private List<OrderPrice> orderTotalPrice = null;
  private List<OrderItem> orderItem = new ArrayList<>();

  public ProductOrder id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID created on repository side (OM system)
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductOrder href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink to access the order
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductOrder externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * ID given by the consumer and only understandable by him (to facilitate his searches
   * afterwards).
   *
   * @return externalId
   */
  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public ProductOrder priority(PriorityType priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   *
   * @return priority
   */
  public PriorityType getPriority() {
    return priority;
  }

  public void setPriority(PriorityType priority) {
    this.priority = priority;
  }

  public ProductOrder description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the product order
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductOrder category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Used to categorize the order from a business perspective that can be useful for the OM system
   * (e.g. &#39;enterprise&#39;, &#39;residential&#39;, ...).
   *
   * @return category
   */
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ProductOrder state(StateType state) {
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

  public ProductOrder orderDate(OffsetDateTime orderDate) {
    this.orderDate = orderDate;
    return this;
  }

  /**
   * Date when the order was created
   *
   * @return orderDate
   */
  public OffsetDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(OffsetDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public ProductOrder completionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
    return this;
  }

  /**
   * Date when the order was completed.
   *
   * @return completionDate
   */
  public OffsetDateTime getCompletionDate() {
    return completionDate;
  }

  public void setCompletionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
  }

  public ProductOrder requestedStartDate(OffsetDateTime requestedStartDate) {
    this.requestedStartDate = requestedStartDate;
    return this;
  }

  /**
   * Order start date wished by the requestor
   *
   * @return requestedStartDate
   */
  public OffsetDateTime getRequestedStartDate() {
    return requestedStartDate;
  }

  public void setRequestedStartDate(OffsetDateTime requestedStartDate) {
    this.requestedStartDate = requestedStartDate;
  }

  public ProductOrder requestedCompletionDate(OffsetDateTime requestedCompletionDate) {
    this.requestedCompletionDate = requestedCompletionDate;
    return this;
  }

  /**
   * Requested delivery date from the requestor perspective
   *
   * @return requestedCompletionDate
   */
  public OffsetDateTime getRequestedCompletionDate() {
    return requestedCompletionDate;
  }

  public void setRequestedCompletionDate(OffsetDateTime requestedCompletionDate) {
    this.requestedCompletionDate = requestedCompletionDate;
  }

  public ProductOrder expectedCompletionDate(OffsetDateTime expectedCompletionDate) {
    this.expectedCompletionDate = expectedCompletionDate;
    return this;
  }

  /**
   * Expected delivery date amended by the provider
   *
   * @return expectedCompletionDate
   */
  public OffsetDateTime getExpectedCompletionDate() {
    return expectedCompletionDate;
  }

  public void setExpectedCompletionDate(OffsetDateTime expectedCompletionDate) {
    this.expectedCompletionDate = expectedCompletionDate;
  }

  public ProductOrder notificationContact(String notificationContact) {
    this.notificationContact = notificationContact;
    return this;
  }

  /**
   * Contact attached to the order to send back information regarding this order
   *
   * @return notificationContact
   */
  public String getNotificationContact() {
    return notificationContact;
  }

  public void setNotificationContact(String notificationContact) {
    this.notificationContact = notificationContact;
  }

  public ProductOrder atBaseType(String atBaseType) {
    this.atBaseType = atBaseType;
    return this;
  }

  /**
   * Indicates the base type of the resource. Here can be &#39;ProductOrder&#39;.
   *
   * @return atBaseType
   */
  public String getAtBaseType() {
    return atBaseType;
  }

  public void setAtBaseType(String atBaseType) {
    this.atBaseType = atBaseType;
  }

  public ProductOrder atType(String atType) {
    this.atType = atType;
    return this;
  }

  /**
   * Indicates the type of resource. Here can be &#39;ProductOrder&#39;.
   *
   * @return atType
   */
  public String getAtType() {
    return atType;
  }

  public void setAtType(String atType) {
    this.atType = atType;
  }

  public ProductOrder atSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
    return this;
  }

  /**
   * A link to the schema describing this REST resource.
   *
   * @return atSchemaLocation
   */
  public String getAtSchemaLocation() {
    return atSchemaLocation;
  }

  public void setAtSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
  }

  public ProductOrder channel(Channel channel) {
    this.channel = channel;
    return this;
  }

  /**
   * Get channel
   *
   * @return channel
   */
  public Channel getChannel() {
    return channel;
  }

  public void setChannel(Channel channel) {
    this.channel = channel;
  }

  public ProductOrder note(Note note) {
    this.note = note;
    return this;
  }

  /**
   * Get note
   *
   * @return note
   */
  public Note getNote() {
    return note;
  }

  public void setNote(Note note) {
    this.note = note;
  }

  public ProductOrder relatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ProductOrder addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   *
   * @return relatedParty
   */
  public List<RelatedPartyRef> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ProductOrder payment(List<PaymentRef> payment) {
    this.payment = payment;
    return this;
  }

  public ProductOrder addPaymentItem(PaymentRef paymentItem) {
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

  public ProductOrder billingAccount(BillingAccountRef billingAccount) {
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

  public ProductOrder orderTotalPrice(List<OrderPrice> orderTotalPrice) {
    this.orderTotalPrice = orderTotalPrice;
    return this;
  }

  public ProductOrder addOrderTotalPriceItem(OrderPrice orderTotalPriceItem) {
    if (this.orderTotalPrice == null) {
      this.orderTotalPrice = new ArrayList<>();
    }
    this.orderTotalPrice.add(orderTotalPriceItem);
    return this;
  }

  /**
   * Get orderTotalPrice
   *
   * @return orderTotalPrice
   */
  public List<OrderPrice> getOrderTotalPrice() {
    return orderTotalPrice;
  }

  public void setOrderTotalPrice(List<OrderPrice> orderTotalPrice) {
    this.orderTotalPrice = orderTotalPrice;
  }

  public ProductOrder orderItem(List<OrderItem> orderItem) {
    this.orderItem = orderItem;
    return this;
  }

  public ProductOrder addOrderItemItem(OrderItem orderItemItem) {
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

  /** Return true if this ProductOrder object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOrder productOrder = (ProductOrder) o;
    return Objects.equals(this.id, productOrder.id)
        && Objects.equals(this.href, productOrder.href)
        && Objects.equals(this.externalId, productOrder.externalId)
        && Objects.equals(this.priority, productOrder.priority)
        && Objects.equals(this.description, productOrder.description)
        && Objects.equals(this.category, productOrder.category)
        && Objects.equals(this.state, productOrder.state)
        && Objects.equals(this.orderDate, productOrder.orderDate)
        && Objects.equals(this.completionDate, productOrder.completionDate)
        && Objects.equals(this.requestedStartDate, productOrder.requestedStartDate)
        && Objects.equals(this.requestedCompletionDate, productOrder.requestedCompletionDate)
        && Objects.equals(this.expectedCompletionDate, productOrder.expectedCompletionDate)
        && Objects.equals(this.notificationContact, productOrder.notificationContact)
        && Objects.equals(this.atBaseType, productOrder.atBaseType)
        && Objects.equals(this.atType, productOrder.atType)
        && Objects.equals(this.atSchemaLocation, productOrder.atSchemaLocation)
        && Objects.equals(this.channel, productOrder.channel)
        && Objects.equals(this.note, productOrder.note)
        && Objects.equals(this.relatedParty, productOrder.relatedParty)
        && Objects.equals(this.payment, productOrder.payment)
        && Objects.equals(this.billingAccount, productOrder.billingAccount)
        && Objects.equals(this.orderTotalPrice, productOrder.orderTotalPrice)
        && Objects.equals(this.orderItem, productOrder.orderItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        href,
        externalId,
        priority,
        description,
        category,
        state,
        orderDate,
        completionDate,
        requestedStartDate,
        requestedCompletionDate,
        expectedCompletionDate,
        notificationContact,
        atBaseType,
        atType,
        atSchemaLocation,
        channel,
        note,
        relatedParty,
        payment,
        billingAccount,
        orderTotalPrice,
        orderItem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOrder {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
    sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
    sb.append("    requestedStartDate: ").append(toIndentedString(requestedStartDate)).append("\n");
    sb.append("    requestedCompletionDate: ")
        .append(toIndentedString(requestedCompletionDate))
        .append("\n");
    sb.append("    expectedCompletionDate: ")
        .append(toIndentedString(expectedCompletionDate))
        .append("\n");
    sb.append("    notificationContact: ")
        .append(toIndentedString(notificationContact))
        .append("\n");
    sb.append("    atBaseType: ").append(toIndentedString(atBaseType)).append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
    sb.append("    atSchemaLocation: ").append(toIndentedString(atSchemaLocation)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    orderTotalPrice: ").append(toIndentedString(orderTotalPrice)).append("\n");
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
