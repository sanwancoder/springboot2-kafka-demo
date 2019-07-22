package com.wyfdc.go.springboot.action;

import com.wyfdc.go.springboot.producer.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:  
 */
@RestController
@RequestMapping("/producer")
public class HelloWorldAction {

  @Autowired
  private KafkaSender kafkaSender;

  @GetMapping("/msg/{msg}")
  public String SendMsg(@PathVariable("msg") String msg,
      @PathVariable("topic") String topic){
    kafkaSender.send(msg);
    return "OK";
  }

}
