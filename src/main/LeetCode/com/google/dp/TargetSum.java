package com.google.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

  /**
   * from dfs begins, because that is easy to think, but there are some duplicated calculation.
   * 1. we can create a dp[N][Value], -Sum<=Value<=Sum, because idx of array can not be negative, we can make it shift Sum. So dp=new int[N][2*Sum+1] where dp[N-1][Sum] is the final value
   * 2. as dfs, eachtime add one more item for + and -, consider all values which can be reached by previous items
   * 3. after loop through the array, dp[sum+S] is the result
   */
  public int findTargetSumWays_dfs(int[] nums, int S) {
    return dfs(nums, 0, S);
  }

  private int dfs(int[] nums, int idx, int target) {
    if (idx==nums.length) {
      return target==0 ? 1 : 0;
    }
    return dfs(nums, idx+1, target+nums[idx]) + dfs(nums, idx+1, target-nums[idx]);
  }

  public int findTargetSumWays_dp(int[] nums, int S) {
    int N=nums.length;
    int sum=0;
    for (int i : nums) {
      sum+=i;
    }
    int[] dp = new int[2 * sum + 1];
    dp[nums[0]+sum]=1;
    dp[-nums[0]+sum]=1;

    for (int i=1; i<N; i++) {
      int v=nums[i];
      int[] next = new int[2*sum+1];
      for (int d=0; d<=2*sum; d++) {
        if (dp[d]!=0) {
          next[d+v] += dp[d];
          next[d-v] += dp[d];
        }
      }
      dp=next;
    }

    return dp[sum+S];
  }
}
