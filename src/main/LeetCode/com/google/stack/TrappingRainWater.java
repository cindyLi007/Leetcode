package com.google.stack;

import java.util.Stack;

/**
 * Created by ychang on 1/10/2017.
 * The main idea of using Stack is to keep stack non-ascending, left always higher or at least same with current,
 * so when find a higher right, pop the lowest one (stack top) and calculate rain water.
 * This solution is different with two-pointer or dp, both of them are calculate for index i, vertical rain; while
 * stack is to calculate horizontal for (i to stack top)
 */
public class TrappingRainWater {
  public int trap(int[] height) {
    if (height==null || height.length<3)
      return 0;
    int res = 0, len = height.length, i = 0;
    Stack<Integer> s = new Stack();
    while (i<len) {
      /** here must include height[i]==height[s.peek()], because we need push current index in stack, could not use
       * the previous index, although there height are same, there i (x positions are different)
       */
      if (s.isEmpty() || height[i]<=height[s.peek()])
        s.push(i++);
      else if (height[i]>height[s.peek()]) {
        int h = s.pop();
        if (!s.isEmpty()) {
          res += (i - s.peek() - 1)*(Math.min(height[s.peek()], height[i]) - height[h]);
        }
      }
    }
    return res;
  }
}
