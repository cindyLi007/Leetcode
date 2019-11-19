package com.google.union.find;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ychang on 6/16/2017.
 */
public class NumberIslandTest {
  @Test
  public void numIslands() throws Exception {
    // Given
    NumberOfIslands numberIsland = new NumberOfIslands();
    char[][] grid = new char[][]{
        "11110".toCharArray(),
        "11010".toCharArray(),
        "11000".toCharArray(),
        "00000".toCharArray()
    };

    // When
    int islands = numberIsland.numIslands(grid);

    // Then
    assertThat(islands, is(1));
  }

}