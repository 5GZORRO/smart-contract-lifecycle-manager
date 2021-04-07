package eu._5gzorro.legalproserepository.controller.v1.response;

import eu._5gzorro.legalproserepository.dto.LegalProseTemplateDto;
import org.springframework.data.domain.Page;

import java.util.Objects;

public class PagedTemplateResponse {
    private Page<LegalProseTemplateDto> pagedTemplates;

    public PagedTemplateResponse(Page<LegalProseTemplateDto> pagedTemplates) {
        this.pagedTemplates = pagedTemplates;
    }

    public Page<LegalProseTemplateDto> getPagedTemplates() {
        return pagedTemplates;
    }

    public void setPagedTemplates(Page<LegalProseTemplateDto> pagedTemplates) {
        this.pagedTemplates = pagedTemplates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagedTemplateResponse that = (PagedTemplateResponse) o;
        return pagedTemplates.equals(that.pagedTemplates);
    }

    @Override
    public String toString() {
        return "PagedTemplateResponse{" +
                "pagedTemplates=" + pagedTemplates +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagedTemplates);
    }
}
