package eu._5gzorro.manager.api.repository;

import eu._5gzorro.manager.api.model.entity.AgreementWrapper;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface AgreementRepository extends PagingAndSortingRepository<AgreementWrapper, UUID> {
    Optional<AgreementWrapper> findByDid(String did);
    boolean existsByDid(String did);
    void deleteByDid(String did);
}
