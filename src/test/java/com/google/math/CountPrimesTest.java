package com.google.math;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by grchan on 7/31/2018
 */
public class CountPrimesTest {

  @Test
  public void countPrimes_1() {
    // Given
    CountPrimes countPrimes = new CountPrimes();

    // When
    int number = countPrimes.countPrimes(10);

    // Then
    assertThat(number, is(4));
  }
}