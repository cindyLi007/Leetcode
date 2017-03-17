package com.google.binary.search;

/**
 * Created by ychang on 1/31/2017.
 * Binary search, if low part total count > mid value, means there are some duplicate value in low part, otherwise, that
 * means in high part
 */
public class FindDuplicateNumber {
  public int findDuplicate(int[] nums) {
    int lo=1, hi=nums.length;
    while (lo<hi) {
      int mid=lo + (hi-lo)/2;
      int count=0;
      for (int i : nums) {
        if (i<=mid) count++;
      }
      if (count>mid) hi=mid;
      else lo=mid+1;
    }
    return lo;
  }
}
