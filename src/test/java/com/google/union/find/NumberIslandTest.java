package com.google.union.find;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 6/16/2017.
 */
public class NumberIslandTest {
  @Test
  public void numIslands() throws Exception {
    // Given
    NumberIsland numberIsland = new NumberIsland();
    char[][] grid = new char[][]{"1111111".toCharArray(), "0000001".toCharArray(), "1111101".toCharArray(), "1000101".toCharArray(), "1010101".toCharArray(), "1011101".toCharArray(), "1111111".toCharArray()};

    // When
    int islands = numberIsland.numIslands(grid);

    // Then
    assertThat(islands, is(1));
  }

}