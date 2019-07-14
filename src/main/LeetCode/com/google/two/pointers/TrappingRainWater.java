package com.google.two.pointers;

/**
 * Created by ychang on 1/3/2017. this can beat 43%
 * Keep leftmost and rightmost, each time use the shorter one to compare with current height.
 * Always move the shorter side pointer, that is because we count_bruteForce water from that side.
 */
public class TrappingRainWater {
  public int trap(int[] height) {
    int l = 0, r = height.length - 1, res = 0, leftmost = 0, rightmost = 0;
    while (l<r) {
      leftmost = Math.max(leftmost, height[l]);
      rightmost = Math.max(rightmost, height[r]);
      if (leftmost<rightmost) {
        res += leftmost - height[l++];
      } else {
        res += rightmost - height[r--];
      }
    }
    return res;
  }

  public int trap_abstract(int[] height) {
    int l = 0, r = height.length - 1, res = 0, level = 0;
    while (l<r) {
      // lower is the shorter plank for current 2 pointers
      int lower = height[l]<height[r] ? height[l++] : height[r--];
      // level is the shorter one between leftmost and rightmost, level can guarantee the shortest height to hold water
      /*level = Math.max(level, lower);
      res+=level-lower;*/
      if (level>lower) res+=level-lower;
      else level=lower;
    }
    return res;
  }
}
