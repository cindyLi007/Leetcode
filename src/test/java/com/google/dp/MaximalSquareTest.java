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
    char[][] matrix = new char[][]{"0001".toCharArray(), "1101".toCharArray(), "1111".toCharArray(), "0111".toCharArray(), "0111".toCharArray()};
    MaximalSquare maximalSquare = new MaximalSquare();

    // When
    int square = maximalSquare.maximalSquare_bruceForce(matrix);

    // Then
    assertThat(square, is(9));
  }

}