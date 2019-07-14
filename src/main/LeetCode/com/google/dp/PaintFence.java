package com.google.dp;

/**
 * Created by ychang on 3/28/2017.
 * There is a fence with n posts, each post can be painted with one of the k colors. You have to paint all the posts such
 * that no more than two adjacent fence posts have the same color. Return the total number of ways you can paint the fence.
 */
public class PaintFence {
  public int numWays(int n, int k) {
    if (n==0 || k==0) return 0;
    int same=0, diff=k;
    for (int i=1; i<n; i++) {
      int temp = diff;
      /**
       * diff means in current location, paint diff color with prev one, same means paint same color with prev one.
       * since we only permit at most 2 adjacent fences paint same color, for example in pos i-1, we paint #4 color, in
       * pos i, we want to paint #4 color, we can only choose from diff from pos i-1 (which means pos i-2 and i-1 are different)
       */
      diff = (diff+same)*(k-1);
      same = temp;
    }
    return same+diff;
  }

}
