package com.google.binary.search;

/**
 * Created by ychang on 1/25/2017.
 */
public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int row=0, col=matrix[0].length-1;
    while (row<matrix.length && col>=0) {
      int value = matrix[row][col];
      if (value==target) {
        return true;
      }
      if (value>target) {
        col--;
      } else {
        row++;
      }
    }
    return false;
  }

}
