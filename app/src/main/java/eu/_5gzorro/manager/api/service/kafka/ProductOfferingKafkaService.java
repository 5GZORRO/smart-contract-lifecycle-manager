package eu._5gzorro.manager.api.service.kafka;

import eu._5gzorro.manager.domain.events.ProductOfferingUpdateEvent;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import io.reactivex.rxjava3.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@ConditionalOnProperty("spring.kafka.enabled")
@Service
public class ProductOfferingKafkaService extends AbstractProducer<ProductOfferingUpdateEvent> {
  private static final Logger log = LoggerFactory.getLogger(ProductOfferingKafkaService.class);
  @Value("${spring.kafka.update-topics.product-offering}")
  private String productOfferTopic;

  private final ProductOfferingDriver driver;

  private Disposable kafkaPublishDisposable;

  public ProductOfferingKafkaService(
      KafkaTemplate<String, ProductOfferingUpdateEvent> kafkaTemplate,
      ProductOfferingDriver driver) {
    super(kafkaTemplate);
    this.driver = driver;
  }

  @PostConstruct
  public void setup() {
    log.info("Starting kafka updates for product offerings");
    kafkaPublishDisposable = driver.productOfferObservable()
        .subscribe(productOfferingUpdateEvent -> {
                log.info("ProductOffering Kafka update: {}", productOfferingUpdateEvent);
                super.send(
                        productOfferTopic,
                        productOfferingUpdateEvent.getDeduplicationId(),
                        productOfferingUpdateEvent
                );
        });
  }

  @PreDestroy
  public void shutdown() {
    kafkaPublishDisposable.dispose();
  }
}
