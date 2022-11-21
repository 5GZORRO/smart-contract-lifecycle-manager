package eu._5gzorro.manager.api.service.kafka;

import eu._5gzorro.manager.api.model.entity.OrderOfferMapping;
import eu._5gzorro.manager.api.repository.OrderOfferMappingRepository;
import eu._5gzorro.manager.domain.events.ProductOrderUpdateEvent;
import eu._5gzorro.manager.exception.SpectokenException;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.ProductOrderDriver;
import io.reactivex.rxjava3.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@ConditionalOnProperty("spring.kafka.enabled")
@Service
public class ProductOrderKafkaService extends AbstractProducer<ProductOrderUpdateEvent> {
    private static final Logger log = LoggerFactory.getLogger(ProductOrderKafkaService.class);

    @Value("${spring.kafka.update-topics.product-order}")
    private String productOrderTopic;

    private final ProductOrderDriver driver;
    private final DerivativeSpectokenDriver derivativeSpectokenDriver;

    private Disposable kafkaPublishDisposable;

    private final OrderOfferMappingRepository orderOfferMappingRepository;

    public ProductOrderKafkaService(
        KafkaTemplate<String, ProductOrderUpdateEvent> kafkaTemplate, ProductOrderDriver driver, DerivativeSpectokenDriver derivativeSpectokenDriver, OrderOfferMappingRepository orderOfferMappingRepository) {
        super(kafkaTemplate);
        this.driver = driver;
        this.derivativeSpectokenDriver = derivativeSpectokenDriver;
        this.orderOfferMappingRepository = orderOfferMappingRepository;
    }

    @PostConstruct
    public void setup() {
        log.info("Starting kafka updates for product order");
        kafkaPublishDisposable =
            driver
                .productOrderObservable()
                .subscribe(
                    productOrderUpdateEvent -> {
                        log.info("ProductOrder Kafka update: {}", productOrderUpdateEvent);
                        super.send(
                            productOrderTopic,
                            productOrderUpdateEvent.getDeduplicationId(),
                            productOrderUpdateEvent);

                        if (productOrderUpdateEvent.isDeleted() && productOrderUpdateEvent.isSpectrum()) {
                            Optional<OrderOfferMapping> optionalOrderOfferMapping = orderOfferMappingRepository.findByOrderDid(productOrderUpdateEvent.getDid());
                            optionalOrderOfferMapping.ifPresent(orderOfferMapping -> {
                                try {
                                    derivativeSpectokenDriver.redeemDerivativeSpectoken(orderOfferMapping.getOfferDid(), productOrderUpdateEvent.getSellerName(), true);
                                } catch (ExecutionException | InterruptedException | SpectokenException e) {
                                    log.info("RedeemDerivativeSpectoken ERROR: OfferDid " + orderOfferMapping.getOfferDid() + " SellerName "
                                        + productOrderUpdateEvent.getSellerName() + " Message " + e.getMessage());
                                }
                            });
                        }
                    });
    }

    @PreDestroy
    public void shutdown() {
        kafkaPublishDisposable.dispose();
    }
}
