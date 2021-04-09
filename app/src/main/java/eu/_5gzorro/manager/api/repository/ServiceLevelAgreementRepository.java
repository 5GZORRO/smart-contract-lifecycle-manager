package eu._5gzorro.manager.api.repository;

import eu._5gzorro.manager.api.model.entity.ServiceLevelAgreement;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServiceLevelAgreementRepository extends PagingAndSortingRepository<ServiceLevelAgreement, String> {
}
