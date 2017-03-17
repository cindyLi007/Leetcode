package com.google.dp;

/**
 * Created by ychang on 3/7/2017. dp[i] means till i, what is the max sum.
 */
public class HouseRobber {
  public int rob(int[] nums) {
    if (nums.length==0) return 0;
    if (nums.length==1) return nums[0];
    int[] dp=new int[nums.length];
    dp[0]=nums[0];
    /**
     * dp[1] should not be nums[1], because for [2, 1, 1, 2], if dp[1]=1, the res = 3 which is wrong
     */
    dp[1]=Math.max(nums[0], nums[1]);
    for (int i=2; i<nums.length; i++) {
      dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
    }
    return dp[nums.length-1];
  }
}
