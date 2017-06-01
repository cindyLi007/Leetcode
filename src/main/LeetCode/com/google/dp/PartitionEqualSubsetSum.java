package com.google.dp;

/**
 * Created by ychang on 5/30/2017.
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 */
public class PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    /**
     * If an array can be split as sum[P]==sum[Q], the sum[P+Q] must be even. We can first check it. After that, create
     * a dp[] till sum/2, to check result, only check whether dp[sum/2]>2.
     */
    if (sum%2!=0)
      return false;
    int[] dp = new int[sum/2 + 1];
    dp[0] = 1;
    for (int num : nums) {
      /**
       * for each num, must loop dp from high to low, because we check whether dp[i]!=0, if we loop dp from low to high,
       * it will count just-added dp[i]. For example array [1, 5, 11, 5], for first num 1, dp[0]=1, others are all 0, if
       * we go from low to high, we will make all dp[i] to 1.
       */
      for (int i = dp.length - 1 - num; i>=0; i--) { // to prevent index out of bound, i from dp.length-1-num
        if (dp[i]!=0)
          dp[i + num]++;
      }
      /*for (int i=sum/2; i>=num; i--) {
        dp[i]+=dp[i-num];
      }*/
    }
    return dp[sum/2]>1;
  }
}
