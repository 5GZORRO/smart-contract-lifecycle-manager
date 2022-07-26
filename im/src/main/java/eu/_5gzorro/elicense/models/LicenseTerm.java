package eu._5gzorro.elicense.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class LicenseTerm {

    @JsonProperty("id")
    private String id;

    @JsonProperty("href")
    private String href;

    @JsonProperty("type")
    private LicenseType type;

    @JsonProperty("amountLimit")
    private Integer amountLimit;

    @JsonProperty("durationLimit")
    private TimePeriod durationLimit;

    @JsonProperty("current")
    private Integer current;

    @JsonProperty("lastUsage")
    private TimePeriod lastUsage;

    @JsonProperty("amountType")
    private String amountType;

    public void setId(String id) { this.id = id; }

    public LicenseTerm id(String id) {
        this.id = id;
        return this;
    }

    public String getId() { return id; }

    public void setHref(String href) { this.href = href; }

    public LicenseTerm href(String href) {
        this.href = href;
        return this;
    }

    public String getHref() { return href; }

    public void setType(LicenseType type) { this.type = type; }

    public LicenseTerm type(LicenseType type) {
        this.type = type;
        return this;
    }

    public LicenseType getType() { return type; }

    public void setAmountLimit(Integer amountLimit) { this.amountLimit = amountLimit; }

    public LicenseTerm amountLimit(Integer amountLimit) {
        this.amountLimit = amountLimit;
        return this;
    }

    public Integer getAmountLimit() { return amountLimit; }

    public void setDurationLimit(TimePeriod durationLimit) { this.durationLimit = durationLimit; }

    public LicenseTerm durationLimit(TimePeriod durationLimit) {
        this.durationLimit = durationLimit;
        return this;
    }

    public TimePeriod getDurationLimit() { return durationLimit; }

    public void setCurrent(Integer current) { this.current = current; }

    public LicenseTerm current(Integer current) {
        this.current = current;
        return this;
    }

    public Integer getCurrent() { return current; }

    public void setLastUsage(TimePeriod lastUsage) { this.lastUsage = lastUsage; }

    public LicenseTerm lastUsage(TimePeriod lastUsage) {
        this.lastUsage = lastUsage;
        return this;
    }

    public TimePeriod getLastUsage() { return lastUsage; }

    public void setAmountType(String amountType) { this.amountType = amountType; }

    public LicenseTerm amountType(String amountType) {
        this.amountType = amountType;
        return this;
    }

    public String getAmountType() { return amountType; }

    @Override
    public boolean equals(java.lang.Object o) {
        if(this == o)
            return true;

        if(o == null || getClass() != o.getClass())
            return false;

        LicenseTerm licenseTerm = (LicenseTerm) o;
        return Objects.equals(this.id, licenseTerm.id) &&
                Objects.equals(this.href, licenseTerm.href) &&
                Objects.equals(this.type, licenseTerm.type) &&
                Objects.equals(this.amountLimit, licenseTerm.amountLimit) &&
                Objects.equals(this.durationLimit, licenseTerm.durationLimit) &&
                Objects.equals(this.current, licenseTerm.current) &&
                Objects.equals(this.lastUsage, licenseTerm.lastUsage) &&
                Objects.equals(this.amountType, licenseTerm.amountType);
    }

    @Override
    public int hashCode() { return Objects.hash(id, href, type, amountLimit,
            durationLimit, current, lastUsage, amountType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class LicenseTerm {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    amountLimit: ").append(toIndentedString(amountLimit)).append("\n");
        sb.append("    durationLimit: ").append(toIndentedString(durationLimit)).append("\n");
        sb.append("    current: ").append(toIndentedString(current)).append("\n");
        sb.append("    lastUsage: ").append(toIndentedString(lastUsage)).append("\n");
        sb.append("    amountType: ").append(toIndentedString(amountType)).append("\n");
        sb.append("}");

        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if(o == null)
            return "null";

        return o.toString().replace("\n", "\n    ");
    }
}
