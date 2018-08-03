package com.google.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by grchan on 7/27/2018
 */
public class PermutationsII {
  // Time: O(n!)
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] marked = new boolean[nums.length];
    Arrays.sort(nums);
    permute(nums, marked, 0, res, new ArrayList<>());
    return res;
  }

  private void permute(int[] nums, boolean[] marked, int pos, List<List<Integer>> res, List<Integer> list) {
    if (pos==nums.length) {
      res.add(new ArrayList(list));
    } else {
      for (int i=0; i<nums.length; i++) {
        if (!marked[i]) {
          marked[i]=true;
          list.add(nums[i]);
          permute(nums, marked, pos+1, res, list);
          list.remove(pos);
          marked[i]=false;
          while (i<nums.length-1 && nums[i]==nums[i+1]) i++;
        }
      }
    }
  }
}
