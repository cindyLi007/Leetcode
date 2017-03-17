package com.google.hash.table;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ychang on 2/8/2017.
 */
public class ContainsDuplicateII {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet(); // keep k numbers in set
    for (int i = 0; i<nums.length; i++) {
      if (i>k)
        set.remove(nums[i - k - 1]);
      if (!set.add(nums[i])) // set.add(number) return false means the value is in the set
        return true;
    }
    return false;
  }
}
