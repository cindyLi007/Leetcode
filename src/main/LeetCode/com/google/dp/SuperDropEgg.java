package com.google.dp;

/**
  Leetcode 889
 */
public class SuperDropEgg {
  // Given K eggs and total N floor, what is the min move for find floor F which from F (exclusive) and up, the egg will break
  // Time: O(K*N*lgN), Space: O(N*K)
  public static int superEggDrop(int K, int N) {
    int[][] dp = new int[K+1][N+1];
    for (int i=1; i<=N; i++) dp[1][i] = i;
    // dp[i][j] means have i eggs, for j floor, what is the min move
    for (int i=2; i<=K; i++) {
      // dp[i][j] = max(dp[i-1][n-1], dp[i][j-n]) + 1, 1<=n<=j
      for (int j=1; j<=N; j++) {
        dp[i][j] = dp[i-1][j];
        int left = 1, right = j;
        while (left < right) {
          int mid = left + (right-left)/2;
          int eggBreak = dp[i-1][mid-1], eggNotBreak = dp[i][j-mid];
          if (eggBreak == eggNotBreak) {
            right=mid; break;
          }
          if (eggBreak > eggNotBreak) right = mid-1;
          else left = mid+1;
        }
        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][right-1], dp[i][j-right]) + 1);
      }
    }
    return dp[K][N];
  }

  // Time: O(K*lgN), Space: O(K*N)
  public static int superEggDrop_fast(int K, int N) {
    int[][] dp = new int[N+1][K+1];
    int m=0;
    while (dp[m][K] < N) {
      m++;
      // calculate for m move, i eggs, what is the max floor we can cover
      for (int i=1; i<=K; i++) {
        dp[m][i] = dp[m-1][i-1] + dp[m-1][i] + 1;
      }
    }
    return m;
  }

  // Time: O(K*lgN), Space: O(K)
  public static int superEggDrop_saveSpace(int K, int N) {
    int[] dp = new int[K+1];
    int m=0;
    while (dp[K] < N) {
      m++;
      for (int i=K; i>0; i--) {
        dp[i] += dp[i-1] + 1;
      }
    }
    return m;
  }

  public static void main(String... args) {
    System.out.println(superEggDrop_fast(1, 2)); // should be 1
    System.out.println(superEggDrop_saveSpace(2, 6)); // should be 3
    System.out.println(superEggDrop(3, 14)); // should be 4
  }
}
