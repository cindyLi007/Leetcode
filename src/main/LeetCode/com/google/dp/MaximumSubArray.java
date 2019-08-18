package com.google.dp;

/**
 * Created by ychang on 3/7/2017.
 */
public class MaximumSubArray {
  public int[] maxSubArray(int[] nums) {
    if (nums==null || nums.length==0)
      return null;
    int len = nums.length, res = nums[0];
    int[] dp = new int[len];
    int[] start = new int[len];
    start[0] = 0;
    dp[0] = nums[0];
    int s=0, e=0;
    for (int i = 1; i<len; i++) {
      if (dp[i - 1]<0) {
        dp[i] = nums[i];
        start[i] = i;
      }
      else {
        dp[i] = dp[i - 1] + nums[i];
        start[i] = start[i-1];
      }
      if (dp[i]>res) {
        s = start[i]; e = i;
        res = Math.max(dp[i], res);
      }
    }
    return new int[]{s, e, res};
  }

  public int findMaximumSubarray(int[] nums) {
    int minSum=0, runningSum=0, maxSum=0;
    for (int i = 0; i < nums.length; i++) {
      runningSum += nums[i];
      if (runningSum < minSum) {
        minSum = runningSum;
      }
      if (runningSum - minSum> maxSum) {
        maxSum = runningSum - minSum;
      }
    }
    return maxSum;
  }

  /**
   * Time: O(n), Space: O(1)
   * from the above, we found we need not a dp array, just save a curSum, because each time we only care dp[i-1]
   */
  public int[] maxSubArray_improve(int[] nums) {
    if (nums==null || nums.length==0)
      return null;
    int len = nums.length;
    int[] res = new int[3];
    res[2] = nums[0];
    res[0] = 0;
    res[1] = 0;
    int start = 0, cur = nums[0];

    for (int i = 1; i<len; i++) {
      if (cur<0) {
        start = i;
        cur = nums[i];
      }
      else
        cur += nums[i];
      if (cur > res[2]) {
        res[0] = start;
        res[1] = i;
        res[2] = cur;
      }
    }
    return res;
  }

  // Time: O(N*lgN), Space: O(lgN)
  public int maxSubArray_DivideConquer(int[] nums) {
    if (nums.length==0)
      return 0;
    return helper(nums, 0, nums.length - 1);
  }

  private int helper(int[] nums, int left, int right) {
    if (left>=right)
      return nums[left];
    int mid = left + (right - left)/2;
    // calculate max from left to mid-1
    int leftMax = helper(nums, left, mid - 1);
    // calculate max from mid+1 to right
    int rightMax = helper(nums, mid + 1, right);

    // from mid point, scan to left
    int middleMax = nums[mid], t = middleMax;
    for (int i = mid - 1; i>=left; i--) {
      t += nums[i];
      middleMax = Math.max(middleMax, t);
    }
    // from mid point, scan to right
    t = middleMax;
    for (int i = mid + 1; i<=right; i++) {
      t += nums[i];
      middleMax = Math.max(middleMax, t);
    }

    // middleMax is the max value from left to right must contains mid_point
    return Math.max(middleMax, Math.max(leftMax, rightMax));
  }
}
