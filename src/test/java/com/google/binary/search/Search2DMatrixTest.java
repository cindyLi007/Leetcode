package com.google.binary.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/25/2017.
 */
public class Search2DMatrixTest {
  Search2DMatrix search2DMatrix = new Search2DMatrix();

  @Test
  public void searchMatrix() throws Exception {
    // Given
    int[][] array = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//    int[][] array = new int[][]{{3,3,8,13,13,18},{4,5,11,13,18,20},{9,9,14,15,23,23},{13,18,22,22,25,27},{18,22,23,28,30,33},{21,25,28,30,35,35},{24,25,33,36,37,40}};

    // When
    boolean res = search2DMatrix.searchMatrix(array, 20);

    assertThat(res, is(Boolean.TRUE));
  }

}