package com.google.dp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ychang on 6/1/2017.
 */
public class SplitArrayLargestSumTest {
  @Test
  public void splitArray() throws Exception {
    // Given
    SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();

    // When
//    int splitArray = splitArrayLargestSum.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
    int splitArray = splitArrayLargestSum.splitArray(new int[]{1, 4, 4}, 3);

    // Then
    assertThat(splitArray, is(18));
  }

}