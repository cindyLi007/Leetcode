package com.google.union.find;

import org.junit.Test;

/**
 * Created by ychang on 1/15/2017.
 */
public class SurroundedRegionTest {
  SurroundedRegion sr = new SurroundedRegion();

  @Test
  public void solve() throws Exception {
    // Given
    char[][] board = new char[][]{"OXXOX".toCharArray(),"XOOXO".toCharArray(),"XOXOX".toCharArray(),"OXOOO".toCharArray(),"XXOXO".toCharArray()};

    // When
    sr.solve(board);
  }

}