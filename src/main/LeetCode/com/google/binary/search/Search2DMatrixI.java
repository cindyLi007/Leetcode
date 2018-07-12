package com.google.binary.search;

public class Search2DMatrixI {
  // Time: O(LogM*N)
  public boolean searchMatrix(int[][] matrix, int target) {
    int m=matrix.length, n = m==0? 0 : matrix[0].length;
    int low=0, high=m*n-1;

    while (low<=high) {
      int mid = low + (high-low)/2;
      // Notice, use column length to find the [x, y].
      int cur = matrix[mid/n][mid%n];
      if (cur==target) return true;
      if (cur>target) high=mid-1;
      else low=mid+1;
    }
    return false;
  }

}
