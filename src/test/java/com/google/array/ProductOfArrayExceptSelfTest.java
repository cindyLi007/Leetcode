package com.google.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/14/2017.
 */
public class ProductOfArrayExceptSelfTest {
  @Test
  public void productExceptSelf() throws Exception {
    // Given
    ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();

    // when
    int[] res = productOfArrayExceptSelf.productExceptSelf(new int[]{1, 1});

    // Then
    assertThat(res, is(new int[]{1, 1}));
  }

}