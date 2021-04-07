package eu._5gzorro.manager.api.controller.dto;

import eu._5gzorro.manager.api.model.DateRange;

import java.util.Objects;

public class RelatedPartyRefDto {
    private String href;
    private String role;
    private String name;
    private DateRange validFor;

    public RelatedPartyRefDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatedPartyRefDto that = (RelatedPartyRefDto) o;
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
