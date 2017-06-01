package com.google.bfs.dfs.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 5/30/2017.
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol. Find out how many ways to assign symbols to
 * make sum of integers equal to target S.
 */
public class TargetSum {
  public int findTargetSumWays(int[] nums, int S) {
    /**
     * use a map to record the intermediate result while we are walking along the recursion tree.
     */
    return dfs(nums, S, 0, 0, new HashMap<String, Integer>());
  }

  private int dfs(int[] nums, int s, int index, int sum, Map<String, Integer> map) {
    if (index==nums.length)
      return s==sum ? 1 : 0;
    String key = index + "->" + sum;
    if (map.containsKey(key))
      return map.get(key);
    int res = dfs(nums, s, index + 1, sum + nums[index], map) + dfs(nums, s, index + 1, sum - nums[index], map);
    map.put(key, res);
    return res;
  }
}
