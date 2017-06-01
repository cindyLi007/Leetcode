package com.google.binary.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/31/2017.
 */
public class SplitArrayLargestSumTest {
  @Test
  public void splitArray() throws Exception {
    // Given
    SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();

    // When
    int splitArray = splitArrayLargestSum.splitArray(new int[]{7, 2, 5, 10, 8}, 2);

    // Then
    assertThat(splitArray, is(18));
  }

}