package eu._5gzorro.tm_forum.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * Sets the communication endpoint address the service instance must use to deliver notification information
 */
@ApiModel(description = "Sets the communication endpoint address the service instance must use to deliver notification information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-09T15:56:41.618Z")




public class EventSubscription   {
  @JsonProperty("callback")
  private String callback = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("query")
  private String query = null;

  public EventSubscription callback(String callback) {
    this.callback = callback;
    return this;
  }

  /**
   * The callback being registered.
   * @return callback
  **/
  @ApiModelProperty(required = true, value = "The callback being registered.")
  @NotNull


  public String getCallback() {
    return callback;
  }

  public void setCallback(String callback) {
    this.callback = callback;
  }

  public EventSubscription id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of the listener
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Id of the listener")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EventSubscription query(String query) {
    this.query = query;
    return this;
  }

  /**
   * additional data to be passed
   * @return query
  **/
  @ApiModelProperty(value = "additional data to be passed")


  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventSubscription eventSubscription = (EventSubscription) o;
    return Objects.equals(this.callback, eventSubscription.callback) &&
        Objects.equals(this.id, eventSubscription.id) &&
        Objects.equals(this.query, eventSubscription.query);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callback, id, query);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventSubscription {\n");
    
    sb.append("    callback: ").append(toIndentedString(callback)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
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

