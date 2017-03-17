package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ychang on 1/12/2017.
 */
public class LongestConsecutiveSequenceTest {
  LongestConsecutiveSequence lcs;

  @Before
  public void setUp() throws Exception {
    lcs = new LongestConsecutiveSequence();
  }

  @Test
  public void longestConsecutive() throws Exception {
    // Given
    int[] array = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

    // When
    int res = lcs.longestConsecutive(array);

    // Then
    assertThat(res, is(9));
  }

}