package eu._5gzorro.manager.api.repository;

import eu._5gzorro.manager.api.model.entity.ServiceLevelAgreementWrapper;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface ServiceLevelAgreementRepository extends PagingAndSortingRepository<ServiceLevelAgreementWrapper, UUID> {
    Optional<ServiceLevelAgreementWrapper> findByDid(String did);
    boolean existsByDid(String did);
    void deleteByDid(String did);
}
