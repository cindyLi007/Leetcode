package com.google.dp;

/**
 * Created by ychang on 5/22/2017.
 */
public class CombinationSum4 {

  // dp[target] = sum(dp[target-nums[i]]) i in [0, N-1] && nums[i]<=target
  // follow-up: if there is negative numbers, it can be infinite numbers, such as Graph negavie cycle
  // Time: O(T*N), Space: O(T)
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target+1];
    dp[0]=1;
    for (int t=1; t<=target; t++) {
      for (int n : nums) {
        if (n<=t) dp[t] += dp[t-n];
      }
    }
    return dp[target];
  }

}
