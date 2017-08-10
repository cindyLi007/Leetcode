package com.google.dp;

/**
 * Created by ychang on 8/6/2017.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 */
public class DungeonGame {
  public int calculateMinimumHP(int[][] dungeon) {
    int M = dungeon.length, N = M==0 ? 0 : dungeon[0].length;
    if (M==0 || N==0)
      return 0;
    int[][] dp = new int[M][N];
    /** dp mean the min points needed before enter [i][j]
     * if dungeon[i][j] > 0, 1-x<1, so we choose 1, which means we must keep 1 even we can get more points in the cell
     * if dungeon[i][j] < 0, 1-x>1, so we choose 1-x, which means we must have points greater than 1, so when we enter to
     * this cell and deduct x, we still can keep (1-x)+x=1 point (x < 0)
     */
    dp[M - 1][N - 1] = Math.max(1, 1 - dungeon[M - 1][N - 1]);
    // loop array from right-bottom to left-top, first set edge value
    for (int i = M - 2; i>=0; i--) {
      /** same as set dp[M-1][N-1], the only diff is need make sure when step out this cell, have dp[i+1][N-1] points
       * left which is needed from next cell
       */
      dp[i][N - 1] = Math.max(1, dp[i + 1][N - 1] - dungeon[i][N - 1]);
    }
    for (int i = N - 2; i>=0; i--) {
      dp[M - 1][i] = Math.max(1, dp[M - 1][i + 1] - dungeon[M - 1][i]);
    }
    for (int i = M - 2; i>=0; i--) {
      for (int j = N - 2; j>=0; j--) {
        /**
         * for inner cell, choose min-points-route-cell from right and down
         */
        int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
        dp[i][j] = Math.max(1, min - dungeon[i][j]);
      }
    }
    return dp[0][0];
  }

}
