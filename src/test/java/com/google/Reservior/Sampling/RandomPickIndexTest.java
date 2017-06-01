package com.google.Reservior.Sampling;

import org.junit.Test;

/**
 * Created by ychang on 5/30/2017.
 */
public class RandomPickIndexTest {
  @Test
  public void pick() throws Exception {
    // Given
    RandomPickIndex randomPickIndex = new RandomPickIndex(new int[]{1, 2, 3, 3, 3});

    // When
    System.out.println(randomPickIndex.pick(3));
    System.out.println(randomPickIndex.pick(3));
    System.out.println(randomPickIndex.pick(3));
    System.out.println(randomPickIndex.pick(3));
    System.out.println(randomPickIndex.pick(3));
    System.out.println(randomPickIndex.pick(3));
  }

}