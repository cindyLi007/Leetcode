package com.google.dp;

public class SuperEggDrop {

  public static int superEggDrop(int K, int N) {
    // dp[i][j] means the max floors can cover with i move and j eggs
    int[] dp = new int[K+1];
    int m = 0;
    // the reason we put m from 0 is because m will m++ after for loop each time, so when dp[K]>=N, we still add 1 to m, that will make m become is not correct
    // so m==0 actually means 1-time move
    for (; dp[K]<N; m++) {
      for (int i=K; i>=1; i--) {
        dp[i] += dp[i-1] + 1;
      }
    }
    return m;
  }

  public static void main(String... args) {
    superEggDrop(2, 6);
  }
}
