package com.google.binary.search.tree;

import java.util.TreeSet;

/**
 * Created by ychang on 2/1/2017.
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
public class ContainDuplicate {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    /**
     * if k<1 or nums.length<2, that is not distinct indices, if t<0, that is impossible because we use ABS for difference
     */
    if (k<1 || t<0 || nums.length<2) {
      return false;
    }
    /**
     * TreeSet is binary search tree, so Time Complexity is O(lgK) K is tree size
     */
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i<nums.length; i++) {
      /**
       * Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
       */
      Long floor = set.floor((long) nums[i]);
      /**
       * Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
       */
      Long ceiling = set.ceiling((long) nums[i]);
      if ((floor!=null && nums[i] - floor<=t) || (ceiling!=null && ceiling - nums[i]<=t)) {
        return true;
      }
      set.add((long) nums[i]);
      /**
       * j-i<=k, so when (j-i==k) ==> i==j-k, we need remove i from nums
       */
      if (i>=k) {
        set.remove((long) nums[i - k]);
      }
    }
    return false;
  }

}
