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
@EnableConfigurationProperties({CordaConfigurationProperties.class})
public class DriverConfiguration {

  private final CordaConfigurationProperties cordaProps;

  public DriverConfiguration(CordaConfigurationProperties cordaProps) {
    this.cordaProps = cordaProps;
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public NodeRPC nodeRPC() {
    return new NodeRPC(
        cordaProps.getRpc().getHost(),
        cordaProps.getRpc().getRpcPort(),
        cordaProps.getRpc().getUsername(),
        cordaProps.getRpc().getPassword()
    );
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public ProductOfferingDriver productOfferingDriver(NodeRPC rpc) {
    return new CordaProductOfferingDriver(rpc, cordaProps.getGovernanceNodeNames());
  }
}
