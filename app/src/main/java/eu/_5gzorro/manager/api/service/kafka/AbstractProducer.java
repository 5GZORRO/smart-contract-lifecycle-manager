package eu._5gzorro.manager.api.service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

public class AbstractProducer<T> {
  private final KafkaTemplate<String, T> kafkaTemplate;

  public AbstractProducer(KafkaTemplate<String, T> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(String topic, T message) {
    kafkaTemplate.send(topic, message);
  }

  public void send(String topic, String deDupKey, T message) {
    kafkaTemplate.send(topic, deDupKey, message);
  }
}
