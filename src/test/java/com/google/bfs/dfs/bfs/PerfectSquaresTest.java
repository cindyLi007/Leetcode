package com.google.bfs.dfs.bfs;

import org.junit.Test;

/**
 * Created by ychang on 4/3/2017.
 */
public class PerfectSquaresTest {
  @Test
  public void numSquares() throws Exception {
    PerfectSquares perfectSquares = new PerfectSquares();
    perfectSquares.numSquares_DP(12);
  }

}