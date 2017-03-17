package com.google.dp;

import org.junit.Test;

/**
 * Created by ychang on 3/9/2017.
 */
public class RobotStepsTest {
  @Test
  public void getPath() throws Exception {
    // Given
    int[][] grid = new int[][]{{0, 1, 0, 1}, {0, 0, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}};
    RobotSteps robotSteps = new RobotSteps();

    // When
    boolean path = robotSteps.getPath(grid);

    // Then
  }

}