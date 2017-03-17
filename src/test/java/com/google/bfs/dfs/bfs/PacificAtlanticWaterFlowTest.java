package com.google.bfs.dfs.bfs;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 3/2/2017.
 */
public class PacificAtlanticWaterFlowTest {

  @Test
  public void pacificAtlantic() throws Exception {
    // Given
    PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
    int[][] array = new int[][]{{1, 2, 3,}, {8, 9, 4}, {7, 6, 5}};

    // When
    List<int[]> ints = pacificAtlanticWaterFlow.pacificAtlantic_dfs(array);

  }
}