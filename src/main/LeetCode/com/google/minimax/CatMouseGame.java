package com.google.minimax;

import java.util.Arrays;

// 913. Cat and Mouse
// https://www.cnblogs.com/grandyang/p/11515655.html
public class CatMouseGame {

  public int catMouseGame(int[][] graph) {
    int V = graph.length;
    // dp[t][x][y] denote in step t, when mouse in x node, cat in y node, what is the game result
    int[][][] dp = new int[2 * V][V][V];
    for (int[][] r : dp)
      for (int[] c : r)
        Arrays.fill(c, -1);
    return helper(dp, 0, 1, 2, graph);
  }

  private int helper(int[][][] dp, int step, int m, int c, int[][] graph) {
    // if mouse go to hole, mouse wins
    if (m == 0) return 1;
    // if cat and mouse are in same node, cat win
    if (c == m) return 2;
    // if both of them traverse all nodes, tie
    if (step == graph.length * 2) return 0;
    // use dp to memorize the state result
    if (dp[step][m][c] != -1) return dp[step][m][c];

    // res 1 means Mouse will win, 0 means draw, 2 means cat will win
    // if mouse turn
    if (step % 2 == 0) {
      int[] next = graph[m];
      boolean flag = false;
      for (int i : next) {
        int res = helper(dp, step + 1, i, c, graph);
        if (res == 1) { // if in the following steps, there in one can make mouse sure-win, it will definately choose that step and return;
          dp[step][m][c] = 1;
          return 1;
        } else if (res == 0) { // in in the following steps, there is one can make Tie, remember it
          flag = true;
        }
      }
      // if hit this point, that means there is no steps can make mouse sure-win, check whether there is any steps can make draw
      // if no, return cat win
      dp[step][m][c] = flag ? 0 : 2;
    } else { // if cat turn
      int[] next = graph[c];
      boolean flag = false;
      for (int i : next) {
        // cat could not pass hole
        if (i == 0) continue;
        int res = helper(dp, step + 1, m, i, graph);
        if (res == 2) {
          dp[step][m][c] = 2;
          return 2;
        } else if (res == 0) {
          flag = true;
        }
      }
      dp[step][m][c] = flag ? 0 : 1;
    }
    return dp[step][m][c];
  }
}
