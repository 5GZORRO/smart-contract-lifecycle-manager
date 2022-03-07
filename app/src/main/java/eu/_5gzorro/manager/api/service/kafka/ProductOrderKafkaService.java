package eu._5gzorro.manager.api.service.kafka;

import eu._5gzorro.manager.domain.events.ProductOrderUpdateEvent;
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

@ConditionalOnProperty("spring.kafka.enabled")
@Service
public class ProductOrderKafkaService extends AbstractProducer<ProductOrderUpdateEvent> {
  private static final Logger log = LoggerFactory.getLogger(ProductOrderKafkaService.class);

  @Value("${spring.kafka.update-topics.product-order}")
  private String productOrderTopic;

  private final ProductOrderDriver driver;

  private Disposable kafkaPublishDisposable;

  public ProductOrderKafkaService(
      KafkaTemplate<String, ProductOrderUpdateEvent> kafkaTemplate, ProductOrderDriver driver) {
    super(kafkaTemplate);
    this.driver = driver;
  }

  @PostConstruct
  public void setup() {
    log.info("Starting kafka updates for product offerings");
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
                });
  }

  @PreDestroy
  public void shutdown() {
    kafkaPublishDisposable.dispose();
  }
}
