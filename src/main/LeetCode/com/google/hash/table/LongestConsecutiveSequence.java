package com.google.hash.table;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ychang on 1/12/2017.
 * keep a map of <value, length>, length means for this value the longest length,
 * we only care boundary-value's length.
 */
public class LongestConsecutiveSequence {
  /**
   * this can beat 64%
   */
  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap();
    int res=0;
    for (int n:nums) {
      if (!map.containsKey(n)) {
        // since map does not contain n, previously must NOT connect n to left and right, so we need connect it to left and right
        int left = map.containsKey(n-1) ? map.get(n-1) : 0;
        int right = map.containsKey(n+1) ? map.get(n+1) : 0;
        int length = left+1+right; // if n is isolated, left and right are 0, length is 1.
        /**
         * must put n in map, to avoid duplicated adding to map, and duplicated calculation
         */
        map.put(n, length);
        res=Math.max(res, length);
        /** change boundary-value's length, no need to change all entries length,
         only care new-construct sequence's left and right boundary value's length
        */
        map.put(n-left, length);
        map.put(n+right, length);
      }
    }
    return res;
  }

  /**
   * this can beat 96%, but time complexity is O(NlgN)
   */
  public int longestConsecutive_firstSort(int[] nums) {
    if (nums.length==0)
      return 0;
    Arrays.sort(nums);
    int max = 1, temp = 1;
    for (int i = 1; i<nums.length; i++) {
      if (nums[i] - 1==nums[i - 1]) {
        temp++;
        max = Math.max(max, temp);
      } else if (nums[i]!=nums[i - 1]) {
        temp = 1;
      }
    }
    return max;
  }
}
