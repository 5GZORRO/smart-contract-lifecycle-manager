package eu._5gzorro.manager.api.controller.dto;

import java.util.Objects;

public class TemplateRefDto {
    private String href;
    private String name;
    private String description;

    public TemplateRefDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateRefDto that = (TemplateRefDto) o;
        return href.equals(that.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href);
    }

    @Override
    public String toString() {
        return "TemplateRef{" +
                "href='" + href + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
