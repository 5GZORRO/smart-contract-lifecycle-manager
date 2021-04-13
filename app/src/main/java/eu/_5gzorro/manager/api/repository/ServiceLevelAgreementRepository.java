package eu._5gzorro.manager.api.repository;

import eu._5gzorro.manager.api.model.entity.ServiceLevelAgreementWrapper;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServiceLevelAgreementRepository extends PagingAndSortingRepository<ServiceLevelAgreementWrapper, String> {
}
