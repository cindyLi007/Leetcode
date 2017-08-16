package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 8/15/2017.
 */
public class LongestLISTest {
  @Test
  public void lengthOfLIS_BinarySearch() throws Exception {
    // Given
    LongestLIS longestIncreasingSubsequence = new LongestLIS();
    int[] array = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

    // When
    int lengthOfLIS = longestIncreasingSubsequence.lengthOfLIS_BinarySearch(array);

    // Then
    assertThat(lengthOfLIS, is(4));
  }

}