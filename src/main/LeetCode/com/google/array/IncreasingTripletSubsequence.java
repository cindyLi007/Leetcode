package com.google.array;

/**
 * Created by ychang on 5/24/2017.
 * Keep small and mid value during we pass through the array, when a num <= small, update small, when a num<=mid, update
 * mid, otherwise means we find a number > small and mid. Notice, for example [1, 2, -1, 3], when we loop to -1, we update
 * small, but not update mid, so when go to 3, since 3 > mid (2), it guarantees there must is a num < 2 prior 2, so we can
 * return true. The idea is always keep current smallest small and mid value.
 */
public class IncreasingTripletSubsequence {
  public boolean increasingTriplet(int[] nums) {
    int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num<=small)
        small = num;
      else if (num<=mid)
        mid = num;
      else
        return true;
    }
    return false;
  }
}
