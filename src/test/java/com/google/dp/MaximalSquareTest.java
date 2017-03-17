package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/10/2017.
 */
public class MaximalSquareTest {
  @Test
  public void maximalSquare() throws Exception {
    //Given
    char[][] matrix = new char[][]{"10100".toCharArray(), "10111".toCharArray(), "11111".toCharArray(), "10010".toCharArray()};
    MaximalSquare maximalSquare = new MaximalSquare();

    // When
    int square = maximalSquare.maximalSquare(matrix);

    // Then
    assertThat(square, is(4));
  }

}