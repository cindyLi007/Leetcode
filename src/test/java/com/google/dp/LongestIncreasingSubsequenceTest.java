package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/10/2017.
 */
public class LongestIncreasingSubsequenceTest {
  @Test
  public void lengthOfLIS() throws Exception {
    // Given
    int[] array = new int[]{1,3,6,7,9,4,10,5,6};
    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

    // When
    int lengthOfLIS = lis.lengthOfLIS(array);

    // Then
    assertThat(lengthOfLIS, is(6));
  }

}