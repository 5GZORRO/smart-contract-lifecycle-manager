package eu._5gzorro.manager.api.repository;

import eu._5gzorro.manager.api.model.entity.BundledOfferMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BundledOfferMappingRepository extends JpaRepository<BundledOfferMapping, UUID> {

    Optional<BundledOfferMapping> findById(UUID id);

    @Query("SELECT bom FROM BundledOfferMapping bom WHERE bom.bundleOfferDID = ?1")
    Optional<BundledOfferMapping> findByBundleOfferDID(String bundleOfferDID);

    List<BundledOfferMapping> findAll();
}
