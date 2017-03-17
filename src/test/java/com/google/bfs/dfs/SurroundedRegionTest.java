package com.google.bfs.dfs;

import org.junit.Test;

/**
 * Created by ychang on 1/14/2017.
 */
public class SurroundedRegionTest {
  SurroundedRegion sr = new SurroundedRegion();

  @Test
  public void solve() throws Exception {
    // Given
    char[][] board = new char[][]{"OOO".toCharArray(), "OOO".toCharArray(), "OOO".toCharArray()};

    // When
    sr.solve(board);

  }

}