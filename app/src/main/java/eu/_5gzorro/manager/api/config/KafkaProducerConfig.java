package eu._5gzorro.manager.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import eu._5gzorro.manager.domain.events.ProductOfferingUpdateEvent;
import eu._5gzorro.manager.domain.events.ProductOrderUpdateEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@ConditionalOnProperty("spring.kafka.enabled")
@Configuration
public class KafkaProducerConfig {
  private static final Logger log = LoggerFactory.getLogger(KafkaProducerConfig.class);

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

    return props;
  }

  public <T> JsonSerializer<T> jsonSerializer() {
    ObjectMapper objectMapper =
        new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    objectMapper.registerModule(new JavaTimeModule());
    return new JsonSerializer<>(objectMapper);
  }

  public <T> ProducerFactory<String, T> producerFactory() {
    DefaultKafkaProducerFactory<String, T> factory =
        new DefaultKafkaProducerFactory<>(producerConfigs());
    factory.setValueSerializer(jsonSerializer());
    return factory;
  }

  @Bean
  public KafkaTemplate<String, ProductOfferingUpdateEvent> offerKafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public KafkaTemplate<String, ProductOrderUpdateEvent> orderKafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}
