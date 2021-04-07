package eu._5gzorro.manager.api.controller.dto;

import java.util.Objects;

public class RuleDto {
    private String id;
    private String metric;
    private String unit;
    private String referenceValue;
    private String operator;
    private String tolerance;
    private String consequence;

    public RuleDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReferenceValue() {
        return referenceValue;
    }

    public void setReferenceValue(String referenceValue) {
        this.referenceValue = referenceValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTolerance() {
        return tolerance;
    }

    public void setTolerance(String tolerance) {
        this.tolerance = tolerance;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleDto ruleDto = (RuleDto) o;
        return id.equals(ruleDto.id) && metric.equals(ruleDto.metric) && unit.equals(ruleDto.unit) && referenceValue.equals(ruleDto.referenceValue) && operator.equals(ruleDto.operator) && Objects.equals(tolerance, ruleDto.tolerance) && Objects.equals(consequence, ruleDto.consequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, metric, unit, referenceValue, operator, tolerance, consequence);
    }

    @Override
    public String toString() {
        return "RuleDto{" +
                "id='" + id + '\'' +
                ", metric='" + metric + '\'' +
                ", unit='" + unit + '\'' +
                ", referenceValue='" + referenceValue + '\'' +
                ", operator='" + operator + '\'' +
                ", tolerance='" + tolerance + '\'' +
                ", consequence='" + consequence + '\'' +
                '}';
    }
}
