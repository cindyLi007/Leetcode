package com.google.heap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ychang on 3/14/2017.
 */
public class SlidingWindowMax {
  /**
   * this one beat 98%
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k<=1 || nums.length==0)
      return nums;
    int[] res = new int[nums.length - k + 1];
    int max = 0, z = 0, i = 1;
    for (; i<k; i++) {
      if (nums[i]>=nums[max]) {
        max = i;
      }
    }
    res[z++] = nums[max];
    for (; i<nums.length; i++) {
      if (nums[i]>=nums[max])
        max = i;
      if (i - max>=k) {
        int j = max + 1;
        max = i;
        for (; j<i; j++) {
          if (nums[j]>nums[max])
            max = j;
        }
      }
      res[z++] = nums[max];
    }
    return res;
  }

  /**
   * this can beat 32%, but this is O(n)
   */
  public int[] maxSlidingWindow_Deque(int[] nums, int k) {
    if (nums.length<=1 || k<=1)
      return nums;
    int[] res = new int[nums.length - k + 1];
    int z = 0;
    Deque<Integer> queue = new ArrayDeque();
    for (int i = 0; i<nums.length; i++) {
      // first remove all out of range index in queue
      while (!queue.isEmpty() && queue.peek()<i - k + 1)
        queue.poll();
      // seconde remove all index which value < cur value and before cur because we will not use it
      while (!queue.isEmpty() && nums[queue.peekLast()]<=nums[i])
        queue.pollLast();
      // third add cur value,
      queue.offer(i);
      // i>=k-1 is the first window right edge
      if (i>=k - 1)
        res[z++] = nums[queue.peek()];
    }
    return res;
  }
}
