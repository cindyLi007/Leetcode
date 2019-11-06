package com.google.dp;

/**
 * Created by ychang on 6/1/2017.
 */
public class SplitArrayLargestSum {
  // This is my version, there is another version https://leetcode.com/problems/split-array-largest-sum/discuss/89816/DP-Java,
  // but hard to understand, 其实这道题用Binary Search做才是正解
  int[][][] dp;
  public int splitArray(int[] nums, int m) {
    // first need build a sum array for quickly compute sum range
    int N = nums.length;
    if (N == 1) return nums[0];
    int[] sum = new int[N + 1]; // sum[i] denotes [0, i-1] sum of [i, j] = sum[j+1] - sum[i]
    for (int i = 0; i < N; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }

    if (m == 1) return sum[N];

    // use dp as cache to memorize the res
    dp = new int[N + 1][N + 1][m + 1];

    // second use recursive to compuate
    return helper(sum, 0, N, m);
  }

  // right is exclusive
  // Time: O(N*N*m)
  private int helper(int[] sum, int left, int right, int m) {
    if (m == 1) return sumRange(sum, left, right);
    if (dp[left][right][m] != 0) return dp[left][right][m];
    int res = Integer.MAX_VALUE;
    // 对于一个点 把它当成一个single区间 把它后面的numbers分成m-1个subarray 求最小max sum
    for (int i = left + 1; i <= right - m + 1; i++) {
      res = Math.min(Math.max(sumRange(sum, left, i), helper(sum, i, right, m - 1)), res);
    }
    dp[left][right][m] = res;
    return res;
  }

  private int sumRange(int[] sum, int left, int right) {
    return sum[right] - sum[left];
  }

}
