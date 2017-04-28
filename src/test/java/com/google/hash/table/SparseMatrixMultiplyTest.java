package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 4/25/2017.
 */
public class SparseMatrixMultiplyTest {
  @Test
  public void multiply() throws Exception {
    // Given
    SparseMatrixMultiply sparseMatrixMultiply = new SparseMatrixMultiply();
    int[][] a = new int[][]{{0, 1}, {0, 0}, {0, 1}};
    int[][] b = new int[][]{{1, 0}, {1, 0}};

    // When
    int[][] result = sparseMatrixMultiply.multiply(a, b);

    // Then
    assertThat(result, is(new int[][]{{1, 0}, {0, 0}, {1, 0}}));
  }

}