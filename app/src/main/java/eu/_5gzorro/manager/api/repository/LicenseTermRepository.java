package eu._5gzorro.manager.api.repository;

import eu._5gzorro.manager.api.model.entity.LicenseTermWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LicenseTermRepository extends JpaRepository<LicenseTermWrapper, UUID> {
    Optional<LicenseTermWrapper> findByDid(String did);
    boolean existsByDid(String did);
    void deleteByDid(String did);
}
