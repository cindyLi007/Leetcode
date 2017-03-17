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
    int[] heights = new int[]{4,2,0,3,2,5};

    // When
    int maxArea = lrh.largestRectangleArea_stack(heights);

    // Than
    assertThat(maxArea, is(3));
  }

}