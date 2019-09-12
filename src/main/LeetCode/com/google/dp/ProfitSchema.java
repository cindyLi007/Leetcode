package com.google.dp;

public class ProfitSchema {

  // Time: O(N*G*P), Space: O(N*G*P)
  public static int profitableSchemes(int G, int P, int[] group, int[] profit) {
    int N = group.length;
    int mod = 1000_000_007;
    // dp[k][i][j] is # of schema of use first k tasks, profit is i and use j people
    int[][][] dp = new int[N + 1][P + 1][G + 1];
    // transition formula is dp[k][i+p][j+g] += dp[k][i][j] is p and g is from profit[k] and group[k] if (i+p<P)
    // dp[k][P][j+g] += dp[k][i][j] (i+p>=P), j+g <= G
    // dp[k][i][j] += dp[k-1][i][j]
    dp[0][0][0] = 1;
    for (int k=1; k<=N; k++) {
      int p = profit[k-1], g = group[k-1];
      for (int i=0; i<=P; i++) {
        for (int j=0; j<=G-g; j++) {
          dp[k][Math.min(P, i+p)][j+g] = (dp[k][Math.min(P, i+p)][j+g] + dp[k-1][i][j]) % mod;
        }
      }
      for (int i=0; i<=P; i++) for (int j=0; j<=G; j++) {
        dp[k][i][j] = (dp[k][i][j] + dp[k-1][i][j]) % mod;
      }
    }

    int res = 0;
    for (int j=0; j<=G; j++) res = (res + dp[N][P][j]) % mod;
    return res;
  }

  public static int profitableSchemes_2D(int G, int P, int[] group, int[] profit) {
    int N = group.length;
    int mod = 1000_000_007;
    // dp[i][j] is # of schema of use first k tasks, profit is i and use j people
    int[][] dp = new int[P + 1][G + 1];
    // transition formula is dp[k][i+p][j+g] += dp[k][i][j] is p and g is from profit[k] and group[k] if (i+p<P)
    // dp[k][P][j+g] += dp[k][i][j] (i+p>=P), j+g <= G
    // dp[k][i][j] += dp[k-1][i][j]
    dp[0][0] = 1;
    for (int k=1; k<=N; k++) {
      int p = profit[k-1], g = group[k-1];
      // we must loop i and j from high to low, that is because we always update dp array entry greater than current array entry,
      // if loop from left to right, we will use just-updated value, not from k-1
      for (int i=P; i>=0; i--) {
        for (int j=G-g; j>=0; j--) {
          dp[Math.min(P, i+p)][j+g] = (dp[Math.min(P, i+p)][j+g] + dp[i][j]) % mod;
        }
      }
    }

    int res = 0;
    for (int x: dp[P]) res = (res + x) % mod;
    return res;
  }

  public static void main(String... args) {
    System.out.println(profitableSchemes_2D(5, 3, new int[]{2, 2}, new int[]{2, 3}));
    System.out.println(profitableSchemes_2D(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
  }
}
