package eu._5gzorro.manager.api.repository;

import eu._5gzorro.manager.api.model.entity.OrderOfferMapping;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderOfferMappingRepository extends JpaRepository<OrderOfferMapping, UUID> {

    @NotNull
    Optional<OrderOfferMapping> findById(@NotNull UUID id);

    @Query("SELECT oom FROM OrderOfferMapping oom WHERE oom.orderDid = ?1")
    Optional<OrderOfferMapping> findByOrderDid(String orderDid);

    @Query("SELECT oom FROM OrderOfferMapping oom WHERE oom.offerDid = ?1")
    List<OrderOfferMapping> findByOfferDid(String offerDid);

    @NotNull
    List<OrderOfferMapping> findAll();
}
