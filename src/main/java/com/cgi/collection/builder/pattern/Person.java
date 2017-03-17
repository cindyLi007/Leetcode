package com.cgi.collection.builder.pattern;

// Immutable class
public class Person {
  private final String givenName;
  private final String surName;
  private final String email;
  private final String phone;
  private final String address;
  private final String city;
  private final int age;
  private final Gender gender;
  private final String state;
  private final String code;

  public static class Builder {
    // required parameters, final, only set value in constructor
    private final String givenName;
    private final String surName;

    // Optional parameters - initialized to default values;
    private String email;
    private String phone;
    private String address;
    private String city;
    private int age = 0;
    private Gender gender = Gender.UNKNOWN;
    private String state;
    private String code;

    public Builder(String givenName, String surName) {
      this.givenName = givenName;
      this.surName = surName;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder city(String city) {
      this.city = city;
      return this;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public Builder gender(Gender gender) {
      this.gender = gender;
      return this;
    }

    public Builder state(String state) {
      this.state = state;
      return this;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }

  private Person(Builder builder) {
    givenName = builder.givenName;
    surName = builder.surName;
    email = builder.email;
    phone = builder.phone;
    address = builder.address;
    city = builder.city;
    state = builder.state;
    code = builder.code;
    age = builder.age;
    gender = builder.gender;
  }

  @Override
  public String toString() {
    return "Person '" + givenName + " "+ surName + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", code='" + code + '\'' +
        ", age=" + age +
        ", gender=" + gender +
        '}';
  }

  public Gender getGender() {
    return gender;
  }
}

