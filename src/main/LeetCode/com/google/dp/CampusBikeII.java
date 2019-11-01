package com.google.dp;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 1066. Campus Bikes II, this question is not like the 1057. campus bikes, that one is always choose the shortest
 * path among all pairs {worker, bike}, so we must sort all pairs and pick the shortest one.
 * this question is to optimize the sum of all pairs distance, for optimization, we should consider DP
 */
public class CampusBikeII {
    /*
    if we only have one worker, just pick the shortest distance from all bikes to this one.
    each time add a new worker, dp[n] = Math.min(distance(n, m) + dp[n-1][m-1])
     */
    // Time: O(B^W), Space: O(B^W)
    public int assignBikes(int[][] workers, int[][] bikes) {
        int N = bikes.length;
        BitSet visited = new BitSet(N+1);
        Map<String, Integer> map = new HashMap<>();
        return helper(workers, 0, bikes, visited, map);
    }

    private int helper(int[][] workers, int i, int[][] bikes, BitSet visited, Map<String, Integer> map) {
        if (workers.length == i)
            return 0;
        // for the situation from 0 to i-1th items in worker, visited in state S, the min distance sum is stored in
        // map with key (i + S)
        String key = i + "," + visited;
        if (map.containsKey(key)) return map.get(key);

        int min = Integer.MAX_VALUE;
        for (int j=0; j<bikes.length; j++) {
            if (visited.get(j)) continue;
            visited.set(j);
            min = Math.min(min, helper(workers, i+1, bikes, visited, map) + dist(workers[i], bikes[j]));
            visited.set(j, false);
        }
        map.put(key, min);
        return min;
    }

    private int dist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    public static void main(String... args) {
        CampusBikeII campusBikeII = new CampusBikeII();
        int[][] w = new int[][]{{0, 0}, {2, 1}};
        int[][] b = new int[][]{{1, 2}, {3, 3}};
        int res = campusBikeII.assignBikes(w, b);
        System.out.println(res);
    }
}

