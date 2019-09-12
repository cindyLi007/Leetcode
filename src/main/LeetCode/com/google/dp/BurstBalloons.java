package com.google.dp;

/**
 * Leetcode 312 Burst Ballons
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are
 * asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 */
public class BurstBalloons {

  // Time: O(N^3), Space: O(N*N)
  public int maxCoins(int[] nums) {
    int N = nums.length;
    int n[] = new int[N+2];
    n[0]=n[N+1]=1;
    for (int i=0; i<N; i++) {
      n[i+1] = nums[i];
    }

    // dp[i][j] means in [i, j] what is the max coins
    int[][] dp = new int[N+2][N+2];
    for (int L = 1; L <= N; L++) {
      for (int i=1; i<=N-L+1; i++) {
        int j=i+L-1;
        dp[i][j]=0;
        for (int m = i; m<=j; m++) {
          dp[i][j] = Math.max(dp[i][j], n[i-1]* n[m]* n[j+1] + dp[i][m-1] + dp[m+1][j]);
        }
      }
    }

    return dp[1][N];
    // this if for recursive
    // return f(n, 1, N, new int[N+2][N+2]);
  }

  private int f(int[] nums, int i, int j, int[][] dp) {
    if (i>j) return 0;
    if (dp[i][j]>0) return dp[i][j];
    for (int m=i; m<=j; m++) {
      dp[i][j]=Math.max(dp[i][j], f(nums, i, m-1, dp) + f(nums, m+1, j, dp) +
          nums[i-1]*nums[j+1]*nums[m]);
    }
    return dp[i][j];
  }
}
