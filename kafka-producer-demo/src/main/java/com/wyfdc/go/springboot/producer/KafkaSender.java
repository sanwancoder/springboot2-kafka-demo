package com.wyfdc.go.springboot.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wyfdc.go.springboot.dto.Message;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {

  @Autowired
  private KafkaTemplate kafkaTemplate;

  private Gson gson = new GsonBuilder().create();

  public void send(String msg) {
    Message message = new Message();
    message.setId(UUID.randomUUID().toString());
    message.setMsg(msg);
    message.setSendTime(new Date());
    kafkaTemplate.send("abc123", gson.toJson(message));
  }
}
