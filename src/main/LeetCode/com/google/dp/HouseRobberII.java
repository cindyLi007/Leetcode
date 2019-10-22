package com.google.dp;

/**
 * Created by ychang on 8/14/2017.
 * Since nums[0] and nums[N-1] could NOT be robbed at the same time, we calculate [0, N-2] and [1, N-1] and pick the max
 * between them
 */
public class HouseRobberII {
  // Time: O(N), Space: O(N)
  public int rob(int[] nums) {
    int N = nums.length;
    if (N==0) return 0;
    if (N==1) return nums[0];
    return Math.max(rob(nums, 0, N-2), rob(nums, 1, N-1));
  }

  private int rob(int[] A, int s, int e) {
    int N = e-s+1;
    int[] dp = new int[N+1];
    dp[1] = A[s];
    for (int i=s+1; i<=e; i++) {
      dp[i+1-s] = Math.max(dp[i-s], dp[i-1-s] + A[i]);
    }
    return dp[N];
  }
}
