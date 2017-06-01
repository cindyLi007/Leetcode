package com.google.bit.manipulation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/31/2017.
 */
public class HammingDistanceTest {
  @Test
  public void hammingDistance() throws Exception {
    // Given
    HammingDistance hammingDistance = new HammingDistance();

    // When
    int distance = hammingDistance.hammingDistance(1, 4);

    // Then
    assertThat(distance, is(2));
  }

}