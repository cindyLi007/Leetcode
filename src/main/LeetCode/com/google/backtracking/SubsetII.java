package com.google.backtracking;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychang on 5/11/2017.
 */
public class SubsetII {
  public List<List<Integer>> subset(int[] nums) {
    int N = (int) Math.pow(2.0, nums.length);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      List<Integer> list = new ArrayList<>();
      int count = 0, j=i;
      while (j != 0) {
        if ((j & 1) == 1) {
          list.add(nums[count]);
        }
        count++;
        j >>>= 1;
      }
      res.add(list);
    }
    return res;
  }

  // Time: O(n!), Space: O(N)
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums); // O(nlgn)
    subset(nums, 0, res, new ArrayList<Integer>());
    return res;
  }

  private void subset(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
    res.add(new ArrayList(list));

    for (int i=start; i<nums.length; i++) {
      list.add(nums[i]);
      subset(nums, i+1, res, list);
      list.remove(list.size()-1);
      /*
       * we only want to add duplicated element to just-created list, not to previous ones
       * for example nums is [1, 2, 2], now we have [], [1], we add 2 to create new [2],
       * [1, 2], for the next 2, we just want to add it to [2] and [1, 2], not [] and [1]
       */
      while (i<nums.length-1 && nums[i]==nums[i+1]) i++;
    }
  }

  public List<List<Integer>> subsetsWithDup_noRecursive(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList();
    res.add(new ArrayList());

    for (int i=0; i<nums.length; i++) {
      int dup=1;
      while (i<nums.length-1 && nums[i+1]==nums[i]) {
        dup++;
        i++;
      }
      int size=res.size();
      /**
       * same thinking as above method, continuously apply duplicated element to new created list
       */
      for (int z=0; z<size; z++) {
        List<Integer> cur = new ArrayList(res.get(z));
        for (int j=0; j<dup; j++) {
          cur.add(nums[i]);
          res.add(new ArrayList(cur));
        }
      }
    }
    return res;
  }
}
