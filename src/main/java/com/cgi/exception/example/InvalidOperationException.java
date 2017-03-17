package com.cgi.exception.example;

/**
 * Created by ychang on 7/24/2016.
 */
public class InvalidOperationException extends Exception {

  public InvalidOperationException() {
    super();
  }

  public InvalidOperationException(String message) {
    super(message);
  }

  public InvalidOperationException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidOperationException(Throwable cause) {
    super(cause);
  }

}
