package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 6/3/2017.
 */
public class MaxRectangleTest {
  @Test
  public void maximalRectangle_dp() throws Exception {
    // Given
    MaxRectangle maxRectangle = new MaxRectangle();
    char[][] array = new char[][]{"10100".toCharArray(), "10111".toCharArray(), "11111".toCharArray(), "10010".toCharArray()};

    // When
    int maximalRectangle_dp = maxRectangle.maximalRectangle_dp(array);

    // Then
    assertThat(maximalRectangle_dp, is(6));
  }

}