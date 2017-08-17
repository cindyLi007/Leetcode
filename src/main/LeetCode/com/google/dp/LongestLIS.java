package com.google.dp;

import java.util.Arrays;

/**
 * Created by ychang on 8/15/2017.
 * dp is an array in which dp[i] is the LIS length ended at num[i]. First all dp[i] is 1. For a num[i], search from dp[0] to
 * dp[i-1], if (num[i]>num[j]), which means if we use LIS in dp[j], the length in num[i] is dp[j]+1
 */
public class LongestLIS {
  public int lengthOfLIS(int[] nums) {
    int N = nums.length;
    if (N<=1)
      return N;
    int[] dp = new int[N];
    Arrays.fill(dp, 1);
    int res = 1;
    for (int i = 1; i<N; i++) {
      for (int j = 0; j<i; j++) {
        if (nums[j]<nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }

  public int lengthOfLIS_BinarySearch(int[] nums) {
    int N=nums.length;
    if (N<=1) return N;
    // dp is an array which dp[i] save the current min value which can reach LIS length is i, dp[i] is dynamically updated
    int[] dp = new int[N];
    int res=0;
    for (int x : nums) {
      // because dp is an sorted array, we can use binary search to find the index which we can insert x;
      int low=0, high=res;
      while (low!=high) {
        // binary search to find the highest index in which dp[i-1] < x <= dp[i], update tails[i]
        int m=low+(high-low)/2;
        if (x>dp[m]) {
          low=m+1;
        } else {
          high=m;
        }
      }
      dp[low]=x;
      if (low==res) { // we insert x to the tail of dp, which means x is greater than all prev values saved in dp, now increase dp size
        res++;
      }
    }
    return res;
  }
}
