package com.google.array;

/**
 * Created by ychang on 8/2/2017.
 */
public class SetMatrixZero {
  public void setZeroes(int[][] matrix) {
    // if [i][j]==0, then set [0][j]==0 and [i][0]==0, only need diff row 0 and col 0, because both of them use [0][0]
    int col=1, M=matrix.length, N=(M==0 ? 0 : matrix[0].length);
    for (int i=0; i<M; i++) {
      if (matrix[i][0]==0) col=0;
      for (int j=1; j<N; j++) {
        if (matrix[i][j]==0) {
          matrix[i][0]=0;
          matrix[0][j]=0;
        }
      }
    }
    /** because matrix[i][0] and matrix[0][j] is the state of entire row/column, we could NOT go from top to down, that
     *  will erase the valid value, we need keep matrix[i][0] and matrix[0][j] till loop through the rest of matrix
      */
    for (int i=M-1; i>=0; i--) {
      for (int j=N-1; j>0; j--) {
        if (matrix[i][0]==0 || matrix[0][j]==0) {
          matrix[i][j]=0;
        }
      }
      if (col==0) matrix[i][0]=0;
    }
  }
}
