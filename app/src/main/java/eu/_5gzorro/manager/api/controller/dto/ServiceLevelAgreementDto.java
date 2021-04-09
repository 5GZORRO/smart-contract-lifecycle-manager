package eu._5gzorro.manager.api.controller.dto;

import eu._5gzorro.manager.api.model.DateRange;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ServiceLevelAgreementDto {
    private String id;
    private String href;
    private String name;
    private String description;
    private String version;
    private TimePeriod validFor;
    private TemplateRefDto templateRef;
    private String state;
    private boolean approved;
    private LocalDateTime approvalDate;
    private List<RuleDto> rules;
    private List<RelatedPartyRefDto> relatedPartyRefs;

    public ServiceLevelAgreementDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public TemplateRefDto getTemplateRef() {
        return templateRef;
    }

    public void setTemplateRef(TemplateRefDto templateRef) {
        this.templateRef = templateRef;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }

    public List<RuleDto> getRules() {
        return rules;
    }

    public void setRules(List<RuleDto> rules) {
        this.rules = rules;
    }

    public List<RelatedPartyRefDto> getRelatedPartyRefs() {
        return relatedPartyRefs;
    }

    public void setRelatedPartyRefs(List<RelatedPartyRefDto> relatedPartyRefs) {
        this.relatedPartyRefs = relatedPartyRefs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceLevelAgreementDto that = (ServiceLevelAgreementDto) o;
        return approved == that.approved && id.equals(that.id) && href.equals(that.href) && name.equals(that.name) && Objects.equals(description, that.description) && Objects.equals(version, that.version) && Objects.equals(validFor, that.validFor) && Objects.equals(templateRef, that.templateRef) && state.equals(that.state) && Objects.equals(approvalDate, that.approvalDate) && Objects.equals(rules, that.rules) && Objects.equals(relatedPartyRefs, that.relatedPartyRefs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, href, name, description, version, validFor, templateRef, state, approved, approvalDate, rules, relatedPartyRefs);
    }

    @Override
    public String toString() {
        return "ServiceLevelAgreementDto{" +
                "id='" + id + '\'' +
                ", href='" + href + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                ", validFor=" + validFor +
                ", templateRef=" + templateRef +
                ", state='" + state + '\'' +
                ", approved=" + approved +
                ", approvalDate=" + approvalDate +
                ", rules=" + rules +
                ", relatedPartyRefs=" + relatedPartyRefs +
                '}';
    }
}
