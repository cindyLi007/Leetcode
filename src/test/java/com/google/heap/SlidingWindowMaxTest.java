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
    int[] nums = new int[]{1,3,-1,-3,5,3,6,7};

    // When
    int[] res = slidingWindowMax.maxSlidingWindow_Deque(nums, 3);

    // Then
    assertThat(res, is(new int[]{3, 3, 5, 5, 6, 7}));
  }

}