package com.google.dp;

/**
 * Created by ychang on 5/30/2017.
 */
public class TargetSum {
  /**
   * Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target
   * Let P be the positive subset and N be the negative subset
   * we need found sum[P]-sum[N] = target, =>
   * sum[P]+sum[Q]+sum[P]-sum[Q] = target+sum[P]+sum[N] =>
   *                    2*sum[P] = target+sum
   * so sum[P]=(target+sum)/2
   * original problem has been converted to a subset sum problem as follows: Find a subset P of nums such that
   * sum(P) = (target + sum(nums)) / 2
   */
  public int findTargetSumWays(int[] nums, int S) {
    int sum=0;
    for (int num : nums) sum+=num;
    if ((sum+S)%2==1 || sum<S) return 0;
    sum=(sum+S)/2;
    int[] dp = new int[sum+1];
    dp[0]=1;
    for (int num : nums) {
      /**
       * for each num, loop all sum from high to low to update sum's combination number, each loop for a num is to check
       * if we use it in sum, whether we can update the sum's combination number. We must from high to low,
       */
      for (int j=sum; j>=num; j--) {
        dp[j]+=dp[j-num];
      }
    }
    return dp[sum];
  }
}
