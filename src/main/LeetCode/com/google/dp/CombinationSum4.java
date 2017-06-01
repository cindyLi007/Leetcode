package com.google.dp;

import java.util.Arrays;

/**
 * Created by ychang on 5/22/2017.
 */
public class CombinationSum4 {
  /**
   * we need cache combination sum for already-calculate numbers, that is as Fibonacci number
   */
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target+1];
    Arrays.fill(dp, -1);
    dp[0]=1;
    return combination(nums, target, dp);
  }

  private int combination(int[] nums, int target, int[] dp) {
    if (target<0) return 0;
    if (dp[target]!=-1) {
      return dp[target]; // means we have calculate this number's comb sum before
    }
    int res=0;
    for (int i=0; i<nums.length; i++) {
      res+=combination(nums, target-nums[i], dp);
    }
    dp[target]=res;
    return res;
  }

  public int combinationSum4_bottomUp(int[] nums, int target) {
    int[] dp=new int[target+1];
    dp[0]=1;
    for (int i=1; i<=target; i++) {
      for (int j=0; j<nums.length; j++) {
        if (i>=nums[j]) dp[i]+=dp[i-nums[j]];
      }
    }
    return dp[target];
  }
}
