package com.google.heap;

import java.util.*;

/**
 * Created by ychang on 3/14/2017.
 */
public class SlidingWindowMax {
  // Time: O(N), Space: O(k) max
  public int[] maxSlidingWindow_Deque(int[] nums, int k) {
      int N = nums.length;
      if (k==1 || N<=1) return nums;
      int[] res = new int[N-k+1];
      Deque<Integer> stack = new ArrayDeque<>();
      int i=0;
      for (; i<k; i++) {
        while (!stack.isEmpty() && nums[stack.peekFirst()]<=nums[i])
          stack.removeFirst();
        stack.offerFirst(i);
      }
      for (; i<N; i++) {
        int idx = stack.peekLast();
        res[i-k] = nums[idx];
        if (i-idx==k) stack.pollLast();
        while (!stack.isEmpty() && nums[stack.peekFirst()]<=nums[i])
          stack.removeFirst();
        stack.offerFirst(i);
      }
      res[i-k] =nums[stack.peekLast()];
      return res;
    }

}
