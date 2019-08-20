package com.cgi.forInterview;

import java.util.List;

/**
 * Created by ychang on 10/16/2016.
 */
public class PrimeCheckTester {

  protected List<String> releaseTypeWithIds;

  public boolean isPrime(int number) {
    if (number <= 0) {
      throw new NumberFormatException("number must be natural number");
    }

    // 1 is not prime
    if (number == 1) return false;

    if (number <= 2) {
      return true;
    }

    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number%i == 0) {
        System.out.println(number + " is not a prime!");
        return false;
      }
    }

    System.out.println(number + " is a prime!");
    return true;
  }

}
