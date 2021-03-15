package eu._5gzorro.manager.api.service.kafka;

import eu._5gzorro.manager.domain.events.ProductOfferingUpdateEvent;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import io.reactivex.rxjava3.disposables.Disposable;
import it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@ConditionalOnProperty("spring.kafka.enabled")
@Service
public class ProductOfferingKafkaService extends AbstractProducer<ProductOfferingUpdateEvent> {
  private static final String TOPIC = "dlt-product-offerings";

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
        .subscribe(productOfferingUpdateEvent -> super.send(TOPIC, productOfferingUpdateEvent));
  }

  @PreDestroy
  public void shutdown() {
    kafkaPublishDisposable.dispose();
  }
}
