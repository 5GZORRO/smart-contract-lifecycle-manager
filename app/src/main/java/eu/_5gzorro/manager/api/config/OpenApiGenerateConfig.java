package eu._5gzorro.manager.api.config;

import static org.mockito.Mockito.mock;

import eu._5gzorro.manager.api.service.ProductOfferingService;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("openapi-generate")
@Configuration
@EnableAutoConfiguration(exclude= ArtemisAutoConfiguration.class)
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
}
