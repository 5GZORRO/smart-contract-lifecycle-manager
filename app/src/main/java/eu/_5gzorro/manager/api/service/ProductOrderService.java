package eu._5gzorro.manager.api.service;

import eu._5gzorro.manager.service.ProductOrderDriver;
import io.reactivex.rxjava3.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class ProductOrderService {
  private static final Logger log = LoggerFactory.getLogger(ProductOrderService.class);

  private final ProductOrderDriver driver;

  private Disposable textLoggingDisposable;

  public ProductOrderService(ProductOrderDriver driver) {
    this.driver = driver;
  }

  @PostConstruct
  public void setup() {
    textLoggingDisposable =
        driver
            .productOrderObservable()
            .subscribe(productOrder -> log.info("ProductOrder DLT update: {}", productOrder));
  }

  @PreDestroy
  public void shutdown() {
    textLoggingDisposable.dispose();
  }
}
