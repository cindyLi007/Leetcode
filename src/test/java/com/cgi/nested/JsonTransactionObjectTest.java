package com.cgi.nested;

import java.time.LocalDateTime;

import org.junit.Test;

import com.cgi.collection.builder.pattern.Gender;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by ychang on 12/5/2017.
 */
public class JsonTransactionObjectTest {

  @Test
  public void testJson() throws Exception {
    // Given
    Employee oldManager = new Employee(0, "Grace", "Chang", 12500.50f);
    Employee newManager = new Employee(0, "Ahmed", "Mahfouz", 15500.50f);
    Gson gson = new Gson();
    JsonTransactionObject jsonTransactionObject = new JsonTransactionObject();

    // When
    jsonTransactionObject.setOldManager(gson.fromJson(gson.toJson(oldManager), JsonObject.class));
    jsonTransactionObject.setNewManager(gson.fromJson(gson.toJson(newManager), JsonObject.class));
    jsonTransactionObject.setGender(Gender.MALE);
    jsonTransactionObject.setAdminName("administrator");
    jsonTransactionObject.setTimestamp(LocalDateTime.now());

    // Then
    String jsonString = gson.toJson(jsonTransactionObject);
    final JsonTransactionObject convertedJsonTransactionObject = gson.fromJson(jsonString, JsonTransactionObject.class);

    System.out.println(jsonString);
    System.out.println("**********************************************************");

    JsonElement jsonElement = gson.toJsonTree(jsonTransactionObject);
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    JsonElement oldManagerJson = jsonObject.get("oldManager");
    System.out.println(oldManagerJson);
  }

}