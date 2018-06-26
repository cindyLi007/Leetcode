package com.google.array;

/**
 * Created by ychang on 5/27/2018.
 * Leetcode 45
 * https://www.youtube.com/watch?v=r3pZd9ghqxk
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * O(N)
 */
public class JumpGameII {
  public int jump(int[] nums) {
    int i = 0, curMax = 0, nextMax = 0, step = 0;

    // if i>curMax, mean we loop to an index we could not reach, should stop and return 0;
    while (i <= curMax) {
      // put this before loop, in case nums.length<2
      if (nextMax >= nums.length - 1) return step;
      // from last curMax to this round curMax, loop and update nextMax
      while (i <= curMax) {
        nextMax = Math.max(nextMax, i + nums[i]);
        i++;
      }

      step++;
      curMax = nextMax;
    }
    return 0;
  }
}
