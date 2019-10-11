package com.google.binary.search.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ychang on 2/1/2017. Leetcode 315
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where
 * counts[i] is the number of smaller elements to the right of nums[i].
 * Example: Given nums = [5, 2, 6, 1] Return the array [2, 1, 1, 0].
 */
// 动态sort, 根据目前sort的结果确定当前的element和其他elements的相对关系. Time: O(NlogN), Space: O(N)
public class CountOfSmallerNumber {
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> res = new ArrayList<>();

    List<Integer> sortedList = new ArrayList<>();
    int N = nums.length;
    for (int i = N - 1; i >= 0; i--) {
      int idx = binarySearch(sortedList, nums[i]);
      res.add(idx);
    }
    Collections.reverse(res);
    return res;
  }

  private int binarySearch(List<Integer> list, int target) {
    int low = 0, high = list.size();
    while (low != high) {
      int m = low + (high - low) / 2;
      if (list.get(m) < target) {
        low = m + 1;
      } else {
        high = m;
      }
    }
    list.add(low, target);
    return low;
  }

}
