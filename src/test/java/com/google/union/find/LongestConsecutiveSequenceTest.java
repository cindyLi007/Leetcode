package com.google.union.find;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 1/13/2017.
 */
public class LongestConsecutiveSequenceTest {
  LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

  @Test
  public void longestConsecutive() throws Exception {
    // Given
    int[] array = new int[]{1,2,0,1};

    // When
    int res = lcs.longestConsecutive(array);

    // Then
    assertThat(res, is(3));
  }

}