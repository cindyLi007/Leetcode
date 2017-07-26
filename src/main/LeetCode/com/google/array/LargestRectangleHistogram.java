package com.google.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ychang on 2/15/2017.
 */
public class LargestRectangleHistogram {
  /**
   * For each column, find from 0 to it maxArea. For each column, we need NOT care from it to heights.length-1, because
   * next columns with consider it. this can beat 91%
   */
  public int largestRectangleArea(int[] heights) {
    int max = 0;
    // for each i, find Max Area among [i, i], [i-1, i], [i-2, i] ... [0, i]
    for (int i = 0; i<heights.length; i++) {
      /**
       * skip unnecessary calculation, if next bar is >= this bar, need not check this one
       */
      if (i + 1<heights.length && heights[i]<=heights[i + 1])
        continue;
      int min = heights[i];
      for (int j = i; j>=0; j--) {
        min = Math.min(min, heights[j]);
        max = Math.max(min*(i - j + 1), max);
      }
    }
    return max;
  }

  /**
   * this can beat 41%
   */
  public int largestRectangleArea_stack(int[] heights) {
    // stack store index instead of height
    Stack<Integer> stack = new Stack();
    int i=0, maxArea=0;
    int[] h = Arrays.copyOf(heights, heights.length+1);
    while (i<h.length) {
      // stack only keep a non-decreasing sequence
      if (stack.isEmpty() || h[i]>=h[stack.peek()]){
        stack.push(i++);
      } else {
        int j = stack.pop();
        /**
         * when stack is empty, width is i, which means from 0 to i-1, all column is >=h[j] (otherwise, stack can not be
         * empty); when stack is not empty, width is i-stack.peek() - 1, not j-stack.peek() or i-j, because we maybe have pop some higher
         * column between i and j. for example [5, 6, 2], first pop 6, then pop 5, when pop 5, the width is from 2 to 5
         * and from peek to j all columns should be >=h[j], so should be i-peek()-1 instead of i-j
         */
        maxArea = Math.max(maxArea, h[j]*(stack.isEmpty() ? i : i-stack.peek()-1));
      }
    }
    return maxArea;
  }

}
