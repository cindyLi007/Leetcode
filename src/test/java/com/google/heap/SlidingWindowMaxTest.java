package com.google.heap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/14/2017.
 */
public class SlidingWindowMaxTest {
  @Test
  public void maxSlidingWindow() throws Exception {
    // Given
    SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
    int[] nums = new int[]{7, 2, 4 };

    // When
    int[] res = slidingWindowMax.maxSlidingWindow(nums, 2);

    // Then
    assertThat(res, is(new int[]{7, 4}));
  }

}