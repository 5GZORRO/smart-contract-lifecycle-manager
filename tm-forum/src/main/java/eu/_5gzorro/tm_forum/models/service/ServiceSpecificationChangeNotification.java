package eu._5gzorro.tm_forum.models.service;

import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/**
 * The notification data structure
 */







public class ServiceSpecificationChangeNotification   {
 
  private ServiceSpecificationChangeEvent event = null;

 
  private String eventId = null;

 
  private OffsetDateTime eventTime = null;

 
  private String eventType = null;

 
  private String fieldPath = null;

 
  private String resourcePath = null;

  public ServiceSpecificationChangeNotification event(ServiceSpecificationChangeEvent event) {
    this.event = event;
    return this;
  }

  /**
   * The event linked to the involved resource object
   *
  **/
 

 

  public ServiceSpecificationChangeEvent getEvent() {
    return event;
  }

  public void setEvent(ServiceSpecificationChangeEvent event) {
    this.event = event;
  }

  public ServiceSpecificationChangeNotification eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * The identifier of the notification
   *
  **/
 


  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public ServiceSpecificationChangeNotification eventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Time of the event occurrence
   *
  **/
 

 

  public OffsetDateTime getEventTime() {
    return eventTime;
  }

  public void setEventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
  }

  public ServiceSpecificationChangeNotification eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * The type of the notification
   *
  **/
 


  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public ServiceSpecificationChangeNotification fieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
    return this;
  }

  /**
   * The path identifying the object field concerned by this notification
   *
  **/
 


  public String getFieldPath() {
    return fieldPath;
  }

  public void setFieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
  }

  public ServiceSpecificationChangeNotification resourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
    return this;
  }

  /**
   * The path identifying the resource object concerned by this notification
   *
  **/
 


  public String getResourcePath() {
    return resourcePath;
  }

  public void setResourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSpecificationChangeNotification serviceSpecificationChangeNotification = (ServiceSpecificationChangeNotification) o;
    return Objects.equals(this.event, serviceSpecificationChangeNotification.event) &&
        Objects.equals(this.eventId, serviceSpecificationChangeNotification.eventId) &&
        Objects.equals(this.eventTime, serviceSpecificationChangeNotification.eventTime) &&
        Objects.equals(this.eventType, serviceSpecificationChangeNotification.eventType) &&
        Objects.equals(this.fieldPath, serviceSpecificationChangeNotification.fieldPath) &&
        Objects.equals(this.resourcePath, serviceSpecificationChangeNotification.resourcePath);
  }

 
  public int hashCode() {
    return Objects.hash(event, eventId, eventTime, eventType, fieldPath, resourcePath);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecificationChangeNotification {\n");
    
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    fieldPath: ").append(toIndentedString(fieldPath)).append("\n");
    sb.append("    resourcePath: ").append(toIndentedString(resourcePath)).append("\n");
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

