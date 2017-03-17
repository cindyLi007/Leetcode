package com.cgi.stream;

/**
 * Created by ychang on 7/17/2016.
 */
public class TaxRate {
  public static double byState(State state) {
    if (State.CA.equals(state)) {
      return 0.08;
    }
    return 0.01;
  }
}
