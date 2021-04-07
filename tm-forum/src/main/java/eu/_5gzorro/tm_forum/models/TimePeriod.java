package eu._5gzorro.tm_forum.models;

import java.util.Objects;

/**
 * A period of time, either as a deadline (endDateTime only) a startDateTime only, or both
 */





public class TimePeriod {


  private String endDateTime = null;


  private String startDateTime = null;

  public TimePeriod endDateTime(String endDateTime) {
    this.endDateTime = endDateTime;
    return this;
  }

  /**
   * End of the time period, using IETC-RFC-3339 format
   *
  **/



  public String getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(String endDateTime) {
    this.endDateTime = endDateTime;
  }

  public TimePeriod startDateTime(String startDateTime) {
    this.startDateTime = startDateTime;
    return this;
  }

  /**
   * Start of the time period, using IETC-RFC-3339 format. If you define a start, you must also define an end
   *
  **/



  public String getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(String startDateTime) {
    this.startDateTime = startDateTime;
  }



  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimePeriod timePeriod = (TimePeriod) o;
    return Objects.equals(this.endDateTime, timePeriod.endDateTime) &&
        Objects.equals(this.startDateTime, timePeriod.startDateTime);
  }


  public int hashCode() {
    return Objects.hash(endDateTime, startDateTime);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimePeriod {\n");
    
    sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
    sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
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

