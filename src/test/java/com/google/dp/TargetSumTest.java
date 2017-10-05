package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 9/28/2017.
 */
public class TargetSumTest {
  @Test
  public void findTargetSumWays() throws Exception {
    // Given
    TargetSum targetSum = new TargetSum();

    // When
    int targetSumWays = targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);

    // Then
    assertThat(targetSumWays, is(5));
  }

}