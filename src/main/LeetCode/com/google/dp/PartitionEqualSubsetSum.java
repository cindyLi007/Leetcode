package com.google.dp;

/**
 * Created by ychang on 5/30/2017.
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 */
public class PartitionEqualSubsetSum {
  /**
   * this can beat 87%
   */
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    /**
     * If an array can be split as sum[P]==sum[Q], the sum[P+Q] must be even. We can first check it. After that, create
     * a dp[] till sum/2, to check result, only check whether dp[sum/2] is true.
     */
    if (sum%2!=0)
      return false;
    sum/=2;
    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;
    for (int num : nums) {
      /**
       * for each num, must loop dp from high to low, because we check whether dp[i]!=0, if we loop dp from low to high,
       * it will count just-added dp[i]. For example array [1, 5, 11, 5], for first num 1, dp[0]=1, others are all 0, if
       * we go from low to high, we will make all dp[i] to 1.
       */
      for (int j = sum; j>=num; j--) { // to prevent index out of bound, i from dp.length-1-num
        dp[j] |= dp[j-num];
      }
    }
    return dp[sum/2];
  }

  /**
   * this can beat 50%, from this it is easy to derive the one dimension solution as above
   */
  public boolean canPartition_twoDimension(int[] nums) {
    int sum=0;
    for (int num : nums) sum+=num;
    if (sum%2==1) return false;
    sum/=2;
    boolean[][] dp = new boolean[nums.length+1][sum+1]; // dp[i][j] means from [0, i] whether we can sum up j
    dp[0][0]=true;
    for (int i=0; i<nums.length; i++) {
      for (int j=1; j<=sum; j++) {
        dp[i+1][j] = dp[i][j];
        if (j>=nums[i]) dp[i+1][j] |= dp[i][j-nums[i]];
      }
    }
    return dp[nums.length][sum];
  }
}
