package com.google.hash.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 4/24/2017.
 */
public class MaxSubarraySize {
  public int maxSubArrayLen(int[] nums, int k) {
    int sum = 0, max = 0;
    Map<Integer, Integer> map = new HashMap();
    for (int i = 0; i<nums.length; i++) {
      sum += nums[i];
      if (sum==k)
        max = i + 1;
      // if (sum-prevSum==k) we can use it as a candidate of max, so we can check whether (sum-k) in hash map, if Yes, that
      // means the prevSum appears
      else if (map.containsKey(sum - k))
        max = Math.max(max, i - map.get(sum - k));
      if (!map.containsKey(sum))
        map.put(sum, i);
    }
    return max;
  }
}
