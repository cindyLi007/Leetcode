package com.cgi.nested;

import java.time.LocalDateTime;

import com.cgi.collection.builder.pattern.Gender;
import com.google.gson.JsonObject;

import lombok.Data;

@Data
public class JsonTransactionObject {
  private JsonObject oldManager;
  private JsonObject newManager;
  private Gender gender;
  private String adminName;
  private LocalDateTime timestamp;
}
