package com.wyfdc.go.springboot.kafkademo.component;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaReceiver {

  @KafkaListener(topics = {"abc123"})
  public void listen(ConsumerRecord<?, ?> record) {
    Optional<?> kafkaMessage = Optional.ofNullable(record.value());
    if (kafkaMessage.isPresent()) {
      Object message = kafkaMessage.get();
      log.info("record =" + record);
      log.info("message =" + message);
    }
  }
}
