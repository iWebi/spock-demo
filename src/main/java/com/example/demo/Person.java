package com.example.demo;

import lombok.Data;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("persons")
public class Person {
  @Id
  private String id;
  private String name;
  private int age;
  private String email;

  public boolean hasValidEmail() {
    return EmailValidator.getInstance().isValid(email);
  }
}
