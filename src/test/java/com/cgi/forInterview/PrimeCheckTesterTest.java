package com.cgi.forInterview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by ychang on 10/16/2016.
 */
public class PrimeCheckTesterTest {
  PrimeCheckTester primeCheckTester;

  @Before
  public void setUp() throws Exception {
    primeCheckTester = new PrimeCheckTester();
  }

  @Test
  public void isPrime() throws Exception {
    // Given

    // When
    boolean result = primeCheckTester.isPrime(9);

    // Then
    Assert.assertFalse(result);
  }

}