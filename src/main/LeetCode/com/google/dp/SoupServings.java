package com.google.dp;

public class SoupServings {
  // Time: O(N*N), Space: O(N*N)
  public double soupServings(int N) {
    if (N>=4800) return 1.0;
    N = (N+24)/25;
    double[][] dp = new double[N+1][N+1];
    return p(N, N, dp);
  }

  private double p(int a, int b, double[][] dp) {
    if (a<=0 && b<=0) return 0.5;
    if (a<=0) return 1.0;
    if (b<=0) return 0.0;
    if (dp[a][b]>0.0) return dp[a][b];
    dp[a][b] = 0.25 * (p(a-4, b, dp) + p(a-3, b-1, dp) + p(a-2, b-2, dp) + p(a-1, b-3, dp));
    return dp[a][b];
  }
}
