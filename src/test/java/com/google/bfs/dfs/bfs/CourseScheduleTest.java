package com.google.bfs.dfs.bfs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/1/2017.
 */
public class CourseScheduleTest {

  @Test
  public void canFinish() throws Exception {
    // Given
    int[][] array = new int[][]{{1, 0}, {2, 1}};
    CourseSchedule courseSchedule = new CourseSchedule();

    // When
    boolean canFinish = courseSchedule.canFinish_dfs(3, array);

    // Then
    assertThat(canFinish, is(Boolean.TRUE));
  }

}