package eu._5gzorro.manager.api.config;

import eu._5gzorro.manager.api.repository.AgreementRepository;
import eu._5gzorro.manager.api.repository.ServiceLevelAgreementRepository;
import eu._5gzorro.manager.api.service.*;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.PrimitiveSpectokenDriver;
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

import static org.mockito.Mockito.mock;

@Profile("openapi-generate")
@Configuration
@EnableAutoConfiguration(exclude = {
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

    @Primary
    @Bean
    public AgreementService agreementService() {
        return mock(AgreementServiceImpl.class);
    }

    @Bean
    public AgreementRepository agreementRepository() {
        return mock(AgreementRepository.class);
    }

    @Primary
    @Bean
    public ProductOrderService productOrderService() {
      return mock(ProductOrderService.class);
    }

    @Bean
    public PrimitiveSpectokenDriver primitiveSpectokenDriver() {
        return mock(PrimitiveSpectokenDriver.class);
    }

    @Bean
    public DerivativeSpectokenDriver derivativeSpectokenDriver() {
        return mock(DerivativeSpectokenDriver.class);
    }
}
