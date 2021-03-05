package eu._5gzorro.manager.dlt.corda.autoconfigure;

import eu._5gzorro.manager.dlt.corda.service.product_offering.CordaProductOfferingDriver;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableConfigurationProperties(DriverConfigurationProperties.class)
public class DriverConfiguration {

  private final DriverConfigurationProperties props;

  public DriverConfiguration(DriverConfigurationProperties props) {
    this.props = props;
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public NodeRPC nodeRPC() {
    return new NodeRPC(
        props.getHost(),
        props.getRpcPort(),
        props.getUsername(),
        props.getPassword()
    );
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public ProductOfferingDriver productOfferingDriver(NodeRPC rpc) {
    return new CordaProductOfferingDriver(rpc);
  }
}
