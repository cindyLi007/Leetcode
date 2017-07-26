package com.google.graph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 6/2/2017.
 */
public class CourseScheduleIITest {
  @Test
  public void findOrder() throws Exception {
    // Given
    int[][] courses = new int[][]{{2, 0}, {2,1}};
    CourseScheduleII courseScheduleII = new CourseScheduleII();

    // When
    int[] order = courseScheduleII.findOrder(3, courses);

    // Then
    assertThat(order, is(new int[]{}));
  }

}