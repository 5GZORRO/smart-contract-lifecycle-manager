package eu._5gzorro.manager.api.controller.dto.responses;

import eu._5gzorro.manager.api.controller.dto.ServiceLevelAgreementDto;
import org.springframework.data.domain.Page;

import java.util.Objects;

public class PagedSlaResponse {
    private Page<ServiceLevelAgreementDto> pagedSLAs;

    public PagedSlaResponse(Page<ServiceLevelAgreementDto> pagedSLAs) {
        this.pagedSLAs = pagedSLAs;
    }

    public Page<ServiceLevelAgreementDto> getPagedSLAs() {
        return pagedSLAs;
    }

    public void setPagedSLAs(Page<ServiceLevelAgreementDto> pagedSLAs) {
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
