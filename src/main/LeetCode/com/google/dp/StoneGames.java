package com.google.dp;

// Leetcode 877 similar with EPI 16.9 pick up coins
public class StoneGames {
  public static boolean stoneGame(int[] p) {
    int n = p.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) dp[i][i] = p[i];
    // we increment length, each time to calculate current range, based on smaller range, so no need to worry about d and i loop direction
    for (int d = 1; d < n; d++)
      for (int i = 0; i < n - d; i++) {
        dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
      }
    return dp[0][n - 1] > 0;
  }

  public static void main(String... args) {
    stoneGame(new int[]{5, 3, 4, 5});
  }

}
