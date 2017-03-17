package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/9/2017.
 */
public class MaxProductSubarrayTest {
  @Test
  public void maxProduct() throws Exception {
    // Given
    int[] array = new int[]{2, 3, -2, 4};
    MaxProductSubarray maxProductSubarray = new MaxProductSubarray();

    // When
    int maxProduct = maxProductSubarray.maxProduct(array);

    // Then
    assertThat(maxProduct, is(6));
  }

}