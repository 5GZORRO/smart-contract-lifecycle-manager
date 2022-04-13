package eu._5gzorro.tm_forum.models.sla;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AutoscalingPolicy {

    private String id;
    private String metric;
    private String unit;
    private String referenceValue;
    private String operator;
    private String consequence;
    private Boolean allowThirdPartyDeployment;
    private List<String> excludedThirdParties;

    public String getId() { return id; }

    public AutoscalingPolicy id(String id) {
        this.id = id;
        return this;
    }

    public void setId(String id) { this.id = id; }

    public String getMetric() { return metric; }

    public AutoscalingPolicy metric(String metric) {
        this.metric = metric;
        return this;
    }

    public void setMetric(String metric) { this.metric = metric; }

    public String getUnit() { return unit; }

    public AutoscalingPolicy unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) { this.unit = unit; }

    public String getReferenceValue() { return referenceValue; }

    public AutoscalingPolicy referenceValue(String referenceValue) {
        this.referenceValue = referenceValue;
        return this;
    }

    public void setReferenceValue(String referenceValue) { this.referenceValue = referenceValue; }

    public String getOperator() { return operator; }

    public AutoscalingPolicy operator(String operator) {
        this.operator = operator;
        return this;
    }

    public void setOperator(String operator) { this.operator = operator; }

    public String getConsequence() { return consequence; }

    public AutoscalingPolicy consequence(String consequence) {
        this.consequence = consequence;
        return this;
    }

    public void setConsequence(String consequence) { this.consequence = consequence; }

    public Boolean getAllowThirdPartyDeployment() { return allowThirdPartyDeployment; }

    public AutoscalingPolicy allowThirdPartyDeployment(Boolean allowThirdPartyDeployment) {
        this.allowThirdPartyDeployment = allowThirdPartyDeployment;
        return this;
    }

    public void setAllowThirdPartyDeployment(Boolean allowThirdPartyDeployment) {
        this.allowThirdPartyDeployment = allowThirdPartyDeployment;
    }

    public List<String> getExcludedThirdParties() { return excludedThirdParties; }

    public AutoscalingPolicy excludedThirdParties(List<String> excludedThirdParties) {
        this.excludedThirdParties = excludedThirdParties;
        return this;
    }

    public void setExcludedThirdParties(List<String> excludedThirdParties) {
        this.excludedThirdParties = excludedThirdParties;
    }

    public AutoscalingPolicy addExcludedThirdParty(String excludedThirdParty) {
        if(excludedThirdParties == null)
            excludedThirdParties = new ArrayList<>();

        excludedThirdParties.add(excludedThirdParty);

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null || getClass() != o.getClass())
            return false;

        AutoscalingPolicy autoscalingPolicy = (AutoscalingPolicy) o;
        return Objects.equals(this.id, autoscalingPolicy.id) &&
                Objects.equals(this.metric, autoscalingPolicy.metric) &&
                Objects.equals(this.unit, autoscalingPolicy.unit) &&
                Objects.equals(this.referenceValue, autoscalingPolicy.referenceValue) &&
                Objects.equals(this.operator, autoscalingPolicy.operator) &&
                Objects.equals(this.consequence, autoscalingPolicy.consequence) &&
                Objects.equals(this.allowThirdPartyDeployment, autoscalingPolicy.allowThirdPartyDeployment) &&
                Objects.equals(this.excludedThirdParties, autoscalingPolicy.excludedThirdParties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, metric, unit, referenceValue, operator, consequence, allowThirdPartyDeployment, excludedThirdParties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class AutoscalingPolicy {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    metric: ").append(toIndentedString(metric)).append("\n");
        sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
        sb.append("    referenceValue: ").append(toIndentedString(referenceValue)).append("\n");
        sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
        sb.append("    consequence: ").append(toIndentedString(consequence)).append("\n");
        sb.append("    allowThirdPartyDeployment: ").append(toIndentedString(allowThirdPartyDeployment)).append("\n");
        sb.append("    excludedThirdParties: ").append(toIndentedString(excludedThirdParties)).append("\n");
        sb.append("}");

        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null)
            return "null";

        return o.toString().replace("\n", "\n    ");
    }
}
