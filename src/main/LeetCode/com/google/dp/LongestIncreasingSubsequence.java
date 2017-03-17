package com.google.dp;

/**
 * Created by ychang on 3/10/2017.
 */
public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    if (nums==null || nums.length==0) return 0;
    int res=1, i=0;
    while (i<nums.length-res) {
      int[] dp = new int[nums.length];
      dp[i]=1;
      int v=nums[i], min=i;
      for (int j=i+1; j<nums.length; j++) {
        if (nums[j]>nums[min]) {
          dp[j]=dp[min]+1;
          min=j;
        } else {
          if (nums[j]<=v)
            dp[j]=0;
          else {
            dp[j]=dp[i]+1;
            min=j;
          }
        }
        res=Math.max(res, dp[j]);
      }
      i++;
    }
    return res;
  }
}
