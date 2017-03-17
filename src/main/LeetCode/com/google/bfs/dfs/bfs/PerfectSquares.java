package com.google.bfs.dfs.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ychang on 3/1/2017.
 */
public class PerfectSquares {

  /**
   * This one beat 95%, the idea is dp[i]=Math.min(dp[i], dp[A]+1), where A=i-B(a perfect square), because i=A+B, there
   * is only one step from A to i, since B is a perfect square
   */
  public int numSquares_DP(int n) {
    /**
     * From Math theory, if a number can be divided by 4, we can remove factor 4.
     */
    while (n % 4 == 0) n /= 4;
    /**
     * From Math theory, if a number mod 8 is 7, it result is 4
     */
    if (n % 8 == 7) return 4;
    int[] dp = new int[n+1];
    dp[0]=0;
    for (int i=1; i<=n; i++) {
      // using a temp var can faster than visit dp[i] every time in the loop
      int min=i;
      for (int j=1; (j*j)<=i; j++) {
        min=Math.min(dp[i-j*j]+1, min);
      }
      dp[i]=min;
    }
    return dp[n];
  }

  /**
   * This one can only beat 14%, we must have Set visited to avoid TLE.
   * Each step we look through all adjacent nodes(all squares) and store sum to list for next step. We have Set visited
   * to avoid any duplicated values in list
   */
  public int numSquares_BFS(int n) {
    Queue<Integer> queue =  new LinkedList();
    queue.add(n);
    Set<Integer> visited = new HashSet();
    int depth=0;
    while (!queue.isEmpty()) {
      int size=queue.size();
      depth++;
      for (int i=0; i<size; i++) {
        int sum=queue.poll();
        for (int j=1; j*j<=sum; j++) {
          if (j*j==sum) return depth;
          int v = sum-j*j;
          if (visited.contains(v)) continue;
          visited.add(v);
          queue.add(v);
        }
      }
    }
    return -1;
  }
}
