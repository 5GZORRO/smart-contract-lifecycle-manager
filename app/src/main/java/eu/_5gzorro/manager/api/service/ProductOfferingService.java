package eu._5gzorro.manager.api.service;

import eu._5gzorro.manager.service.ProductOfferingDriver;
import io.reactivex.rxjava3.disposables.Disposable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductOfferingService {
  private static final Logger log = LoggerFactory.getLogger(ProductOfferingService.class);

  private final ProductOfferingDriver driver;

  private Disposable textLoggingDisposable;

  public ProductOfferingService(ProductOfferingDriver driver) {
    this.driver = driver;
  }

  @PostConstruct
  public void setup() {
    textLoggingDisposable = driver.productOfferObservable()
        .subscribe(productOffering -> log.info("ProductOffering DLT update: {}", productOffering));
  }

  @PreDestroy
  public void shutdown() {
    textLoggingDisposable.dispose();
  }
}
