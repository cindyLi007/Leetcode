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
    from worker 0, try every available bike, and from that point, try for worker 1, tried every available bike and so on,
    so this is a dfs questions, each time for a new worker, dp[n] = Math.min(distance(n, i) + dp[n-1][i is availble]) i is the
    index of bike which is available for n. we need try all possible i for each new bike
     */
    // this solution dfs without memorization
    int res = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, 0, new boolean[bikes.length], 0);
        return res;
    }

    private void dfs(int[][] workers, int[][] bikes, int wIdx, boolean[] visited, int path) {
        if (wIdx == workers.length) res = Math.min(path, res);
        if (path >= res) return;
        // if we already have for wIdx status is current visited, directly return it
        for (int i=0; i<bikes.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int wx = workers[wIdx][0], wy = workers[wIdx][1];
            int dist = Math.abs(wx-bikes[i][0]) + Math.abs(wy-bikes[i][1]);
            dfs(workers, bikes, wIdx+1, visited, path+dist);
            visited[i]=false;
        }
    }

    // Time: O(B^W), Space: O(B^W)
    public int assignBikes_withMemorization(int[][] workers, int[][] bikes) {
        int N = bikes.length;
        BitSet visited = new BitSet(N+1);
        Map<String, Integer> map = new HashMap<>();
        return helper(workers, 0, bikes, visited, map);
    }

    private int helper(int[][] workers, int workerIdx, int[][] bikes, BitSet visited, Map<String, Integer> map) {
        if (workers.length == workerIdx) // we assigned bikes to all workers
            return 0;
        // for the situation from 0 to workerIdx-1th items in worker, visited in state S, the min distance sum is stored in
        // map with key (workerIdx + S)
        String key = workerIdx + "," + visited;
        if (map.containsKey(key)) return map.get(key);

        int min = Integer.MAX_VALUE;
        for (int j=0; j<bikes.length; j++) {
            if (visited.get(j)) continue;
            visited.set(j);
            min = Math.min(min, helper(workers, workerIdx+1, bikes, visited, map) + dist(workers[workerIdx], bikes[j]));
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

