package com.google.dp;

/**
 * Created by ychang on 5/30/2017.
 */
public class TargetSum {
  /**
   * we need found sum[P]-sum[Q]=target, => sum[P]+sum[Q]+sum[P]-sum[Q]=target+sum => 2*sum[P]=target+sum
   * so sum[P]=(target+sum)/2
   */
  public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum<S || (sum + S)%2!=0)
      return 0;
    return subsum(nums, (sum + S)/2);
  }

  private int subsum(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int num : nums) {
      /**
       * We must from high to low,
       */
      for (int i = target; i>=num; i--) {
        dp[i] += dp[i - num];
      }
    }
    return dp[target];
  }
}
