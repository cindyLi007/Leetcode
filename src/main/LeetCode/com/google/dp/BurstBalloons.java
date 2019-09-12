package com.google.dp;

/**
 * Leetcode 312 Burst Ballons
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are
 * asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 */
public class BurstBalloons {

  public int maxCoins(int[] nums) {
    int N = nums.length;
    int array[] = new int[N+2];
    array[0]=1;
    array[N+1]=1;
    for (int i=0; i<N; i++) {
      array[i+1] = nums[i];
    }

    // dp[i][j] means in [i, j] what is the max coins
    int[][] dp = new int[N+2][N+2];
    for (int L = 1; L <= N; L++) {
      for (int i=1; i<=N-L+1; i++) {
        int j=i+L-1;
        dp[i][j]=0;
        for (int m = i; m<=j; m++) {
          dp[i][j] = Math.max(dp[i][j], array[i-1]*array[m]*array[j+1] + dp[i][m-1] + dp[m+1][j]);
        }
      }
    }

    return dp[1][N];
  }
}
