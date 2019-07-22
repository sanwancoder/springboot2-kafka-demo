package com.wyfdc.go.springboot.dto;

import java.util.Date;
import lombok.Data;

@Data
public class Message {

  private String id;

  private String msg;

  private Date sendTime;
}
