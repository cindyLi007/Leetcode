package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 4/24/2017.
 */
public class MaxSubarraySizeTest {
  @Test
  public void maxSubArrayLen() throws Exception {
    // Given
    MaxSubarraySize maxSubarraySize = new MaxSubarraySize();
    int[] array = new int[]{-2, -1, 2, 1};

    // when
    int maxSubArrayLen = maxSubarraySize.maxSubArrayLen(array, 1);

    // Then
    assertThat(maxSubArrayLen, is(2));
  }

}