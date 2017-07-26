package com.google.union.find;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 6/21/2017.
 */
public class NumberOfIslands_II_tempTest {
  @Test
  public void numIslands2() throws Exception {
    // Given
    NumberOfIslands_II numberOfIslands_ii_temp = new NumberOfIslands_II();
    int[][] positions = new int[][]{{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};

    // When
    List<Integer> integers = numberOfIslands_ii_temp.numIslands2(3, 3, positions);

    // Then
    integers.stream().forEach(System.out::println);
  }

}