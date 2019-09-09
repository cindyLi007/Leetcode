package com.google.dp;

public class StoneGames {
  public static boolean stoneGame(int[] p) {
    int n = p.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) dp[i][i] = p[i];
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
