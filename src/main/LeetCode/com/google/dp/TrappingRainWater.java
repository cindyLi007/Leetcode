package com.google.dp;

/**
 * Created by ychang on 1/3/2017. This can beat 64%
 * Use DP, keep Left max height and Right max height, use the min value of left-max and right-max(shortest plank) to
 * compare with current height, if longer, add diff to result.
 * The key is for each unit, we only care the left highest plank and right highest plank, because between them we can
 * hold as much as possible water
 */
public class TrappingRainWater {
  public int trap(int[] height) {
    if (height==null || height.length<3)
      return 0;
    int res = 0, len = height.length;
    int[] dp = new int[len];
    int max = height[0];
    for (int i = 1; i<len; i++) {
      dp[i] = max;
      max = Math.max(max, height[i]);
    }
    max = height[len - 1];
    for (int i = len - 2; i>=0; i--) {
      int h = Math.min(max, dp[i]);
      if (h>height[i])
        res += h - height[i];
      max = Math.max(max, height[i]);
    }
    return res;
  }
}
