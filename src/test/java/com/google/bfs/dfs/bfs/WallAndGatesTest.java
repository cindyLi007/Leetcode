package com.google.bfs.dfs.bfs;

import org.junit.Test;

/**
 * Created by ychang on 9/17/2017.
 */
public class WallAndGatesTest {
  @Test
  public void wallsAndGates() throws Exception {
    // Given
    int[][] matrix = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
    WallAndGates wallAndGates = new WallAndGates();

    // When
    wallAndGates.wallsAndGates(matrix);


  }

}