package com.google.binary.search;

import java.sql.Time;

/**
 * Created by ychang on 1/26/2017.
 * It can be converted to find the max in array, binary search
 */
public class FindPeakElement {
  // Time: O(lgN)
  public int findPeakElement(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo<hi) {
      int mid = (lo + hi)/2;
      /**
       * use mid+1 instead of mid-1, because mid-1 maybe introduce ArrayIndexOutOfBoundsException
       */
      if (nums[mid]>nums[mid + 1])
        hi = mid;
      else
        lo = mid + 1;
    }
    return lo;
  }
}
