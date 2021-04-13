package eu._5gzorro.manager.api.controller.dto.responses;

import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.springframework.data.domain.Page;

import java.util.Objects;

public class PagedSlaResponse {
    private Page<ServiceLevelAgreement> pagedSLAs;

    public PagedSlaResponse(Page<ServiceLevelAgreement> pagedSLAs) {
        this.pagedSLAs = pagedSLAs;
    }

    public Page<ServiceLevelAgreement> getPagedSLAs() {
        return pagedSLAs;
    }

    public void setPagedSLAs(Page<ServiceLevelAgreement> pagedSLAs) {
        this.pagedSLAs = pagedSLAs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagedSlaResponse that = (PagedSlaResponse) o;
        return pagedSLAs.equals(that.pagedSLAs);
    }

    @Override
    public String toString() {
        return "PagedTemplateResponse{" +
                "pagedSLAs=" + pagedSLAs +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagedSLAs);
    }
}
