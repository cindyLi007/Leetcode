package com.google.dp;

/**
 * Created by ychang on 3/10/2017.
 * Top, Left, and Top Left decides the size of the square. If all of them are same, then the size of square increases by 1.
 * If they're not same, they can increase by 1 to the minimal square.
 */
public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if (matrix.length==0) return 0;
    int m=matrix.length, n=matrix[0].length;
    /**
     * dp is aux to record a cell's max_length, we loop from matrix[0][0], but save it in dp[1][1], because we use
     * dp[0][j] and dp[i][0] which are all 0s for left side and top side calculation.
     */
    int[][] dp = new int[m+1][n+1];
    int res=0;
    for (int i=1; i<=m; i++) {
      for (int j=1; j<=n; j++) {
        if (matrix[i-1][j-1]=='1') {
          /**
           * we need not check all top and left and top_left , just check one top, left and top_left step.
           */
          dp[i][j]=Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
          res=Math.max(res, dp[i][j]);
        }
      }
    }
    return res*res;
  }
}
