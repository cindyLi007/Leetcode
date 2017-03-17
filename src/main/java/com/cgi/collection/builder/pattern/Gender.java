package com.cgi.collection.builder.pattern;

/**
 * Created by ychang on 7/28/2016.
 */
public enum Gender{
  FEMALE("Woman"), UNKNOWN("N/A"), MALE("Man");

  public String description;

  Gender(String description) {
    this.description = description;
  }

  public int multiply(int number) {
    this.ordinal();
    return "Grace Chang".charAt(number) * number * 365;
  }
}
