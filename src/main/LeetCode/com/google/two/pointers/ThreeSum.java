package com.google.two.pointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 1/11/2017.
 * the only thing need notice is to avoid any duplication
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList();
    if (nums==null || nums.length==0)
      return res;
    Arrays.sort(nums);
    for (int i = 0; i<nums.length - 2 && nums[i]<=0; i++) {
      if (i>0 && nums[i]==nums[i - 1])
        continue;
      int j = i + 1, k = nums.length - 1;
      while (j<k) {
        if (nums[j] + nums[k]==-nums[i]) {
          /**
           * this is a tricky thing to add a new-band Integer List
           */
          res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
          while (j<k && nums[j]==nums[j - 1])
            j++;
          while (j<k && nums[k]==nums[k + 1])
            k--;
        } else if (nums[j] + nums[k]>-nums[i]) {
          k--;
        } else
          j++;
      }
    }
    return res;
  }
}
