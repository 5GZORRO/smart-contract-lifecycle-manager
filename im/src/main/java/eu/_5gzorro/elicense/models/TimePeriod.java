package eu._5gzorro.elicense.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimePeriod {

    @JsonProperty("endDateTime")
    private String endDateTime = null;

    @JsonProperty("startDateTime")
    private String startDateTime = null;

    public TimePeriod endDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }


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

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }


    @Override
    public boolean equals(java.lang.Object o) {
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

    @Override
    public int hashCode() {
        return Objects.hash(endDateTime, startDateTime);
    }

    @Override
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
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
