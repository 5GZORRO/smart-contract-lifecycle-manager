package eu._5gzorro.manager.api.config;

import static org.mockito.Mockito.mock;

import eu._5gzorro.manager.api.controller.ServiceLevelAgreementController;
import eu._5gzorro.manager.api.controller.ServiceLevelAgreementControllerImpl;
import eu._5gzorro.manager.api.repository.ServiceLevelAgreementRepository;
import eu._5gzorro.manager.api.service.ProductOfferingService;
import eu._5gzorro.manager.api.service.ServiceLevelAgreementService;
import eu._5gzorro.manager.api.service.ServiceLevelAgreementServiceImpl;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("openapi-generate")
@Configuration
@EnableAutoConfiguration(exclude= {
        ArtemisAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class OpenApiGenerateConfig {

  @Bean
  public ProductOfferingDriver driver() {
    return mock(ProductOfferingDriver.class);
  }
  @Primary
  @Bean
  public ProductOfferingService productOfferingService() {
    return mock(ProductOfferingService.class);
  }

  @Primary
  @Bean
  public ServiceLevelAgreementService serviceLevelAgreementService() {
    return mock(ServiceLevelAgreementServiceImpl.class);
  }

  @Bean
  public ServiceLevelAgreementRepository serviceLevelAgreementRepository() {
    return mock(ServiceLevelAgreementRepository.class);
  }
}
