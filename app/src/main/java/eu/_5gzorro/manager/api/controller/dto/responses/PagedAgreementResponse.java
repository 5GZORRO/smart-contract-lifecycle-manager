package eu._5gzorro.manager.api.controller.dto.responses;

import eu._5gzorro.tm_forum.models.agreement.Agreement;
import org.springframework.data.domain.Page;

import java.util.Objects;

public class PagedAgreementResponse {
    private Page<Agreement> pagedAgreements;

    public PagedAgreementResponse(Page<Agreement> pagedAgreements) {
        this.pagedAgreements = pagedAgreements;
    }

    public Page<Agreement> getPagedAgreements() {
        return pagedAgreements;
    }

    public void setPagedAgreements(Page<Agreement> pagedAgreements) {
        this.pagedAgreements = pagedAgreements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagedAgreementResponse that = (PagedAgreementResponse) o;
        return pagedAgreements.equals(that.pagedAgreements);
    }

    @Override
    public String toString() {
        return "PagedTemplateResponse{" +
                "pagedAgreements=" + pagedAgreements +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagedAgreements);
    }
}
