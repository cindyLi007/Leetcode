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
       * for each num, MUST loop all sum from HIGH to LOW to update sum's combination number, each loop for a num is to check
       * when we use it in a sum, which sum's combination number we can update. We must from HIGH to LOW, because if we loop
       * from low to high, the higher one will immediately use the just-calculate lower one, that means we use this number twice.
       */
      for (int j=sum; j>=num; j--) {
        dp[j]+=dp[j-num];
      }
    }
    return dp[sum];
  }
}
