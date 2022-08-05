package eu._5gzorro.manager.dlt.corda.autoconfigure;

import eu._5gzorro.manager.dlt.corda.service.license.CordaLicenseTermDriver;
import eu._5gzorro.manager.dlt.corda.service.product_offering.CordaProductOfferingDriver;
import eu._5gzorro.manager.dlt.corda.service.product_order.CordaProductOrderDriver;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.sla.CordaServiceLevelAgreementDriver;
import eu._5gzorro.manager.dlt.corda.service.spectoken.CordaDerivativeSpectokenDriver;
import eu._5gzorro.manager.dlt.corda.service.spectoken.CordaPrimitiveSpectokenDriver;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.PrimitiveSpectokenDriver;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import eu._5gzorro.manager.service.ProductOrderDriver;
import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import eu._5gzorro.service.DIDToCordaDLTIdentityService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@ConditionalOnProperty(prefix = "dlt", name = "driver", havingValue = "corda")
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
    return new CordaProductOfferingDriver(rpc, cordaProps.getGovernanceNodeNames(), new CordaDerivativeSpectokenDriver(
            didToDLTIdentityService(),
            rpc,
            cordaProps.getGovernanceNodeNames()));
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public PrimitiveSpectokenDriver primitiveSpectokenDriver(NodeRPC rpc) {
    return new CordaPrimitiveSpectokenDriver(
            didToDLTIdentityService(),
            rpc,
            cordaProps.getGovernanceNodeNames()
    );
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public ProductOrderDriver productOrderDriver(NodeRPC rpc) {
    return new CordaProductOrderDriver(
            didToDLTIdentityService(),
            rpc,
            cordaProps.getGovernanceNodeNames()
    );
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public DerivativeSpectokenDriver derivativeSpectokenDriver(NodeRPC rpc) {
    return new CordaDerivativeSpectokenDriver(
            didToDLTIdentityService(),
            rpc,
            cordaProps.getGovernanceNodeNames());
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public CordaServiceLevelAgreementDriver cordaServiceLevelAgreementDriver(NodeRPC rpc) {
    return new CordaServiceLevelAgreementDriver(rpc);
  }

  @Primary
  @Bean
  @ConditionalOnMissingBean
  public CordaLicenseTermDriver cordaLicenseTermDriver(NodeRPC rpc) {
    return new CordaLicenseTermDriver(rpc);
  }

  private DIDToDLTIdentityService didToDLTIdentityService() {
    return new DIDToCordaDLTIdentityService(cordaProps.getIdentityBaseUrl());
  }
}
