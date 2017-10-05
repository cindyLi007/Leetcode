package com.google.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

/**
 * Created by ychang on 2/15/2017.
 */
public class LargestRectangleHistogramTest {
  @Test
  public void largestRectangleArea() throws Exception {
    // Given
    LargestRectangleHistogram lrh = new LargestRectangleHistogram();
    int[] heights = new int[]{2, 1, 5, 6, 2, 3};

    // When
    int maxArea = lrh.largestRectangleArea(heights);

    // Than
    assertThat(maxArea, is(10));
  }

  @Test
  public void largestRectangleArea_stack() throws Exception {
    // Given
    LargestRectangleHistogram lrh = new LargestRectangleHistogram();
    int[] heights = new int[]{0, 1, 0, 1};

    // When
    int maxArea = lrh.largestRectangleArea_stack(heights);

    // Than
    assertThat(maxArea, is(1));
  }



}