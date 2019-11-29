package com.google.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by grchan on 7/27/2018
 * https://leetcode.com/problems/permutations-ii/discuss/214791/Easy-Java-solution-do-not-use-sort-and-extra-space
 */
public class PermutationsII {
  // Time: O(n!)
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] marked = new boolean[nums.length];
    Arrays.sort(nums); // O(nlgN)
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
          // this while must be put inside the !marked[i], which means only when we choose i for pos, we check
          // whether next number(s) are same as this one, to avoid same pick for pos
          // if we put it outside !marked[i], for example, if i-th is chosen by prev pick, but (i+1)th is not, we will never
          // choose (i+1)th for any pos, so we will never fill in the list
          while (i<nums.length-1 && nums[i]==nums[i+1]) i++;
        }
      }
    }
  }

  // Time: O(N*N!)
  public List<List<Integer>> permuteUnique_recursive(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    permute(nums, 0, res);
    for (List<Integer> list : res) {
      list.stream().forEach(System.out::print);
      System.out.println();
    }
    return res;
  }

  private void permute(int[] nums, int startIdx, List<List<Integer>> res) {
    if (startIdx == nums.length) {
      res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    } else {
      for (int i=startIdx; i<nums.length; i++) {
        /**
         * only when there is no duplicate elem in the following, we pick it in position startIdx. If there is repeat elem in the following,
         * we must skip it, only do the swap [startIdx, i] for the last duplicated elem to avoid duplicated reusult
         * for example [2, 2, 1, 1] startIdx is 1, if we swap index [1, 2], we can get [2, 1, 2, 1] and [2, 1, 1, 2],
         * but we will still do swap idex [1, 3] got the [2, 1, 1, 2] and [2, 1, 2, 1] again
         */
        //if (isNotRepeat(nums, i)) { // O(N*N)
        if (i==startIdx || nums[i]!=nums[startIdx]) {
          swap(nums, i, startIdx);
          permute(nums, startIdx+1, res);
          swap(nums, i, startIdx);
        }
      }
    }
  }

  private boolean isNotRepeat(int[] nums, int idx) {
    for (int i=idx+1; i<nums.length; i++) {
      if (nums[i]==nums[idx]) {
        return false;
      }
    }
    return true;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
