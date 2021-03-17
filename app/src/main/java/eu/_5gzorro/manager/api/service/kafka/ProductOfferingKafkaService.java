package eu._5gzorro.manager.api.service.kafka;

import eu._5gzorro.manager.domain.events.ProductOfferingUpdateEvent;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import io.reactivex.rxjava3.disposables.Disposable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@ConditionalOnProperty("spring.kafka.enabled")
@Service
public class ProductOfferingKafkaService extends AbstractProducer<ProductOfferingUpdateEvent> {
  @Value("${spring.kafka.update-topics.product-offering}")
  private static String productOfferTopic;

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
    kafkaPublishDisposable = driver.productOfferObservable()
        .subscribe(productOfferingUpdateEvent ->
                super.send(
                        productOfferTopic,
                        productOfferingUpdateEvent.getDeduplicationId(),
                        productOfferingUpdateEvent
                )
        );
  }

  @PreDestroy
  public void shutdown() {
    kafkaPublishDisposable.dispose();
  }
}
