package eu._5gzorro.tm_forum.models.sla;

import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.Objects;

public class RelatedPartyRef {
    private String href;
    private String role;
    private String name;
    private TimePeriod validFor;

    public RelatedPartyRef() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatedPartyRef that = (RelatedPartyRef) o;
        return href.equals(that.href) && role.equals(that.role) && Objects.equals(name, that.name) && Objects.equals(validFor, that.validFor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, role, name, validFor);
    }

    @Override
    public String toString() {
        return "RelatedPartyRefDto{" +
                "href='" + href + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", validFor=" + validFor +
                '}';
    }
}
