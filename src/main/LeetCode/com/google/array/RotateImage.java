package com.google.array;

/**
 * Created by ychang on 3/15/2017.
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    int n=matrix.length;
    if (n<=1) return;
    /**
     * for example if n=5, we only need do layer 0 and 1.
    */
    for (int layer=0; layer<n/2; layer++) {
      int start=layer, end=n-1-layer;
      /**
       * notice i<end, because each edge's end is the next edge's start, to avoid duplicated manipulation, i<end
      */
      for (int i=start; i<end; i++) {
        int top=matrix[start][i], offset=i-start;
        matrix[start][i]=matrix[end-offset][start];
        matrix[end-offset][start]=matrix[end][end-offset];
        /**
        * should not use offset in matrix, such as matrix[offset] because offset is a relative position, not absolute position
        */
        matrix[end][end-offset]=matrix[i][end];
        matrix[i][end]=top;
      }
    }
  }

  /**
   * this can beat 74%, the key idea is first upside down them swap[i,j] with [j,i]
   */
  public void rotate_clockwise(int[][] matrix) {
    int n = matrix.length;
    if (n<=1) return;
    // clockwise, first upside down; anti-clockwise, first left-side right
    for (int layer=0; layer<n/2; layer++) {
      for (int i=0; i<n; i++) {
        swap(matrix, layer, i, n-1-layer, i);
      }
    }
    // swap [i, j] and [j, i]
    for (int i=0; i<n; i++) {
      for (int j=i+1; j<n; j++) {
        swap(matrix, i, j, j, i);
      }
    }
  }

  private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
    int temp = matrix[x1][y1];
    matrix[x1][y1] = matrix[x2][y2];
    matrix[x2][y2] = temp;
  }

  public void rotate_antiClockwise(int[][] matrix) {
    int n=matrix.length;
    if (n<=1) return;
    for (int layer=0; layer<n/2; layer++) {
      for (int i=0; i<n; i++) {
        swap(matrix, i, layer, i, n - 1 - layer);
      }
    }
    for (int i=0; i<n; i++) {
      for (int j=i+1; j<n; j++) {
        swap(matrix, i, j, j, i);
      }
    }
  }
}
