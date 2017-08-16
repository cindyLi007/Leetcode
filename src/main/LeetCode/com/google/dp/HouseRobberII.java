package com.google.dp;

/**
 * Created by ychang on 8/14/2017.
 * Since nums[0] and nums[N-1] could NOT be robbed at the same time, we calculate [0, N-2] and [1, N-1] and pick the max
 * between them
 */
public class HouseRobberII {
  public int rob(int[] nums) {
    int N=nums.length;
    if (N<=3) {
      switch (N) {
        case 0 : return 0;
        case 1 : return nums[0];
        case 2 : return Math.max(nums[0], nums[1]);
        case 3 : return Math.max(Math.max(nums[0], nums[1]), nums[2]);
      }
    }
    return Math.max(rob(nums, 0, N-2), rob(nums, 1, N-1));
  }

  private int rob(int[] nums, int s, int e) {
    int p0=nums[s], p1=Math.max(p0, nums[s+1]);
    for (int i=s+2; i<=e; i++) {
      int temp = p1;
      p1 = Math.max(p0+nums[i], p1);
      p0=temp;
    }
    return p1;
  }
}
