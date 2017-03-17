package com.cgi.stream;

/**
 * Created by ychang on 7/15/2016.
 */
public enum State {
  CA("California"), // call constructor to initialize the public static final CA reference
  VA("Virginia");

  private String description;

  State(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
