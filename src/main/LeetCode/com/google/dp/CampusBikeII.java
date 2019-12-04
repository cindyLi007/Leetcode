package com.google.dp;

/**
 * Leetcode 1066. Campus Bikes II, this question is not like the 1057. campus bikes, that one is always choose the shortest
 * path among all pairs {worker, bike}, so we must sort all pairs and pick the shortest one.
 * this question is to optimize the sum of all pairs distance, for optimization, we should consider DP
 */
public class CampusBikeII {
  /*
  from worker 0, try every available bike, and from that point, try for worker 1, tried every available bike and so on,
  so this is a dfs questions, each time for a new worker, dp[n] = Math.min(distance(n, i) + dp[n-1][i is availble]) i is the
  index of bike which is available for n. we need try all possible i for each new worker
   */
  int res = Integer.MAX_VALUE;

  // this solution dfs without memorization
  public int assignBikes_dfsWithoutMem(int[][] workers, int[][] bikes) {
    dfs(workers, 0, bikes, new boolean[bikes.length], 0);
    return res;
  }

  // Time: O(B^W), Space: O(W + B)
  private void dfs(int[][] workers, int wIdx, int[][] bikes, boolean[] visited, int path) {
    if (workers.length == wIdx) res = Math.min(res, path);
    if (path >= res) return;
    for (int i = 0; i < bikes.length; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      int dist = Math.abs(workers[wIdx][0] - bikes[i][0]) + Math.abs(workers[wIdx][1] - bikes[i][1]);
      dfs(workers, wIdx + 1, bikes, visited, path + dist);
      visited[i] = false;
    }
  }

  public int assignBikes(int[][] workers, int[][] bikes) {
    // here each bit in dp column (1<<bikes.length) denotes whether the corresponding bike is picked (1) or not picked (0)
    int[][] dp = new int[workers.length][1 << bikes.length];
    return helper(workers, 0, 0, bikes, dp);
  }

  private int helper(int[][] workers, int idx, int takenBits, int[][] bikes, int[][] dp) {
    if (idx == workers.length) return 0;
    // dp[idx][takenBits] denotes for idx-th worker, when previous bikes taken status is takenBis, which means we have ~takenBits
    // available bikes, what is the min dist sum, here we don't care (count) the dist from 0-th to (idx-1)th worker dist
    if (dp[idx][takenBits] != 0) return dp[idx][takenBits];
    dp[idx][takenBits] = Integer.MAX_VALUE;

    for (int i = 0; i < bikes.length; i++) {
      if ((takenBits & (1 << i)) != 0) continue;
      int dist = Math.abs(workers[idx][0] - bikes[i][0]) + Math.abs(workers[idx][1] - bikes[i][1]);
      dp[idx][takenBits] = Math.min(dp[idx][takenBits], helper(workers, idx + 1, (takenBits | (1 << i)), bikes, dp) + dist);
    }
    return dp[idx][takenBits];
  }

  public static void main(String... args) {
    CampusBikeII campusBikeII = new CampusBikeII();
    int[][] w = new int[][]{{0, 0}, {2, 1}};
    int[][] b = new int[][]{{1, 2}, {3, 3}};
    int res = campusBikeII.assignBikes(w, b);
    System.out.println(res);
  }

}

