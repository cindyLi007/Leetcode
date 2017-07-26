package com.google;

import java.util.Arrays;

/**
 * Created by ychang on 11/27/2016.
 */
public class RangeSumQuery2D_Mutable {
  int[][] matrix;
  int[][] tree; // tree is 2D BIT which means tree[4][4] is sum [{0, 0}, {3, 3}]
  int rows, cols;

  public RangeSumQuery2D_Mutable(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return;
    rows = matrix.length;
    cols = matrix[0].length;
    this.matrix = new int[rows][cols];
    tree = new int[rows + 1][cols + 1];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        update(i, j, matrix[i][j]);
      }
    }
  }

  /**
   * for each value, we need change current row all stride values, also we need change stride-rows' all stride values
   */
  public void update(int row, int col, int val) {
    int diff = val - matrix[row][col];
    matrix[row][col] = val;
    for (int i = row + 1; i <= rows; i += i & (-i)) { // row stride
      // for each stride row, change stride col value
      for (int j = col + 1; j <= cols; j += j & (-j)) {
        tree[i][j] += diff;
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return getSum(row2+1, col2+1) - getSum(row1, col2+1) - getSum(row2+1, col1) + getSum(row1, col1);
  }

  private int getSum(int row, int col) {
    int sum = 0;
    for (int i = row; i > 0; i -= i & (-i)) {
      for (int j = col; j > 0; j -= j & (-j)) {
        sum += tree[i][j];
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    int[][] twoD_array = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
    RangeSumQuery2D_Mutable query2D_mutable = new RangeSumQuery2D_Mutable(twoD_array);
    System.out.println(Arrays.deepToString(query2D_mutable.tree));
    System.out.println(query2D_mutable.sumRegion(2, 1, 4, 3));
    query2D_mutable.update(1, 0, 1);
    System.out.println(query2D_mutable.sumRegion(2, 1, 4, 3));
    query2D_mutable.update(3, 2, 2);
    System.out.println(query2D_mutable.sumRegion(2, 1, 4, 3));
  }
}
