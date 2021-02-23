package eu._5gzorro.manager.dlt.corda.autoconfigure;

import eu._5gzorro.manager.service.ProductOfferingDriver;
import eu._5gzorro.manager.dlt.corda.service.product_offering.CordaProductOfferingDriver;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DriverConfiguration {

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public ProductOfferingDriver productOfferingDriver(NodeRPC rpc) {
    return new CordaProductOfferingDriver(rpc);
  }
}
