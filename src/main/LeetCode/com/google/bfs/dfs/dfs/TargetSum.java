package com.google.bfs.dfs.dfs;

import java.util.HashMap;

/**
 * Created by ychang on 5/30/2017.
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol. Find out how many ways to assign symbols to
 * make sum of integers equal to target S.
 * This one is very similar with {@link com.google.dp.CombinationSum4}, the only hard part is how to create Key
 * this can beat 82%
 */
public class TargetSum {
  public int findTargetSumWays(int[] nums, int S) {
    /**
     * use a map to record the intermediate result while we are walking along the recursion tree.
     */
    return dfs(nums, S, 0, new HashMap());
  }

  private int dfs(int[] nums, int target, int start, HashMap<String, Integer> map) {
    if (start==nums.length) {
      return target==0 ? 1 : 0;
    }
    // start index position is important, we must contains it in the key, so different-start-index-same-sum will be in different entry in map
    String key = start + "->" + target;
    if (map.containsKey(key))
      return map.get(key);
    int res = dfs(nums, target + nums[start], start + 1, map) + dfs(nums, target - nums[start], start + 1, map);
    map.put(key, res);
    return res;
  }
}
