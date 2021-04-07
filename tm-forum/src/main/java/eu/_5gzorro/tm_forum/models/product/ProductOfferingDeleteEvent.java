package eu._5gzorro.tm_forum.models.product;

import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/**
 * The notification data structure
 */







public class ProductOfferingDeleteEvent   {
 
  private String correlationId = null;

 
  private String description = null;

 
  private String domain = null;

 
  private ProductOfferingDeleteEventPayload event = null;

 
  private String eventId = null;

 
  private OffsetDateTime eventTime = null;

 
  private String eventType = null;

 
  private String href = null;

 
  private String id = null;

 
  private String priority = null;

 
  private OffsetDateTime timeOcurred = null;

 
  private String title = null;

  public ProductOfferingDeleteEvent correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * The correlation id for this event.
   *
  **/
 


  public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public ProductOfferingDeleteEvent description(String description) {
    this.description = description;
    return this;
  }

  /**
   * An explnatory of the event.
   *
  **/
 


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductOfferingDeleteEvent domain(String domain) {
    this.domain = domain;
    return this;
  }

  /**
   * The domain of the event.
   *
  **/
 


  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public ProductOfferingDeleteEvent event(ProductOfferingDeleteEventPayload event) {
    this.event = event;
    return this;
  }

  /**
   * The event payload linked to the involved resource object
   *
  **/
 

 

  public ProductOfferingDeleteEventPayload getEvent() {
    return event;
  }

  public void setEvent(ProductOfferingDeleteEventPayload event) {
    this.event = event;
  }

  public ProductOfferingDeleteEvent eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * The identifier of the notification.
   *
  **/
 


  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public ProductOfferingDeleteEvent eventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Time of the event occurrence.
   *
  **/
 

 

  public OffsetDateTime getEventTime() {
    return eventTime;
  }

  public void setEventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
  }

  public ProductOfferingDeleteEvent eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * The type of the notification.
   *
  **/
 


  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public ProductOfferingDeleteEvent href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the ProcessFlow
   *
  **/
 


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductOfferingDeleteEvent id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the Process flow
   *
  **/
 


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductOfferingDeleteEvent priority(String priority) {
    this.priority = priority;
    return this;
  }

  /**
   * A priority.
   *
  **/
 


  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public ProductOfferingDeleteEvent timeOcurred(OffsetDateTime timeOcurred) {
    this.timeOcurred = timeOcurred;
    return this;
  }

  /**
   * The time the event occured.
   *
  **/
 

 

  public OffsetDateTime getTimeOcurred() {
    return timeOcurred;
  }

  public void setTimeOcurred(OffsetDateTime timeOcurred) {
    this.timeOcurred = timeOcurred;
  }

  public ProductOfferingDeleteEvent title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the event.
   *
  **/
 


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingDeleteEvent productOfferingDeleteEvent = (ProductOfferingDeleteEvent) o;
    return Objects.equals(this.correlationId, productOfferingDeleteEvent.correlationId) &&
        Objects.equals(this.description, productOfferingDeleteEvent.description) &&
        Objects.equals(this.domain, productOfferingDeleteEvent.domain) &&
        Objects.equals(this.event, productOfferingDeleteEvent.event) &&
        Objects.equals(this.eventId, productOfferingDeleteEvent.eventId) &&
        Objects.equals(this.eventTime, productOfferingDeleteEvent.eventTime) &&
        Objects.equals(this.eventType, productOfferingDeleteEvent.eventType) &&
        Objects.equals(this.href, productOfferingDeleteEvent.href) &&
        Objects.equals(this.id, productOfferingDeleteEvent.id) &&
        Objects.equals(this.priority, productOfferingDeleteEvent.priority) &&
        Objects.equals(this.timeOcurred, productOfferingDeleteEvent.timeOcurred) &&
        Objects.equals(this.title, productOfferingDeleteEvent.title);
  }

 
  public int hashCode() {
    return Objects.hash(correlationId, description, domain, event, eventId, eventTime, eventType, href, id, priority, timeOcurred, title);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingDeleteEvent {\n");
    
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    timeOcurred: ").append(toIndentedString(timeOcurred)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

