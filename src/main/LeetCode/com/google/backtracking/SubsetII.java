package com.google.backtracking;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychang on 5/11/2017.
 */
public class SubsetII {
  /**
   * use ArrayList is faster than LinkedList
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList();
    res.add(new ArrayList());

    for (int i=0; i<nums.length; i++) {
      List<List<Integer>> temp = new ArrayList();
      for (List<Integer> list : res) {
        List<Integer> cur = new ArrayList(list);
        cur.add(nums[i]);
        temp.add(cur);
      }
      res.addAll(temp);
      /**
       * for duplicated element, we only add it to new created lists, not existing lists. For example, [], [1]
       * when we add 2, we got [], [1], [2], [1, 2], so if next element is also 2, we could not add it to [], [1], we can
       * only add it to [2], [1, 2],
       */
      while (i<nums.length-1 && nums[i+1]==nums[i]) {
        i++;
        List<List<Integer>> dup = new ArrayList();
        for (List<Integer> list : temp) {
          List<Integer> cur = new ArrayList(list);
          cur.add(nums[i]);
          dup.add(cur);
        }
        temp=dup;
        res.addAll(temp);
      }
    }
    return res;
  }

  public List<List<Integer>> subsetsWithDup_dup(int[] nums) {
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
