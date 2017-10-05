package com.google.dp;

import java.util.Arrays;

/**
 * Created by ychang on 3/10/2017.
 */
public class MaximalSquare {
  /**
   * Top, Left, and Top Left decides the size of the square. If all of them are same, then the size of square increases by 1.
   * If they're not same, they can increase by 1 to the minimal square.
   * this can beat 67%
   */
  public int maximalSquare(char[][] matrix) {
    int M = matrix.length, N = M==0 ? 0 : matrix[0].length;
    if (M==0 || N==0) return 0;
    /**
     * dp is aux to record a cell's max_length, we loop from matrix[0][0], but save it in dp[1][1], because we use
     * dp[0][j] and dp[i][0] which are all 0s for left side and top side calculation.
     */
    int[][] dp = new int[M + 1][N + 1];
    int res = 0;
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        if (matrix[i][j]=='1') {
          /**
           * we need not check all top and left and top_left , just check one top, left and top_left step.
           */
          dp[i+1][j+1]=Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j]))+1;
          res=Math.max(res, dp[i+1][j+1]);
        }
      }
    }
    return res*res;
  }

  /**
   * this can beat 76%
   */
  public int maximalSquare_bruceForce(char[][] matrix) {
    if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
    int m=matrix.length, n=matrix[0].length, res=0;
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (matrix[i][j]=='1') {
          int s=1;
          boolean flag=true;
          for (; s+i<m && s+j<n && flag; ) {
            for (int k=j; k<=j+s; k++) {
              if (matrix[i+s][k]=='0') {
                flag=false;
                break;
              }
            }
            for (int k=i; k<=i+s; k++) {
              if (matrix[k][j+s]=='0') {
                flag=false;
                break;
              }
            }
            if (flag) s++;
          }
          res=Math.max(res, s);
        }
      }
    }
    return res*res;
  }

  /**
   * this can beat 88%
   */
  public int maximalSquare_fromMaxRectangle(char[][] matrix) {
    if (matrix.length==0)
      return 0;
    int n = matrix[0].length, len = 0;
    int[] h = new int[n], left = new int[n], right = new int[n];
    Arrays.fill(right, n);
    for (char[] row : matrix) {
      int curLeft = 0, curRight = n;
      for (int j = 0; j<n; j++) {
        if (row[j]=='0') {
          h[j] = 0;
          curLeft = j + 1;
          left[j] = 0;
        } else {
          h[j]++;
          left[j] = Math.max(left[j], curLeft);
        }
      }
      for (int j = n - 1; j>=0; j--) {
        if (row[j]=='0') {
          curRight = j;
          right[j] = n;
        } else {
          right[j] = Math.min(right[j], curRight);
          len = Math.max(len, Math.min(h[j], right[j] - left[j]));
        }
      }
    }
    return len*len;
  }
}
