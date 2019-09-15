package com.google.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// Leetcode 847. Shortest Path Visiting All Nodes
public class ShortestPathVisitingAllNodes {
  // BFS Time: O(N * 2^N), because for each node, there are 2^N state
  public static int shortestPathLength(int[][] graph) {
    // use mask to denote the state which all nodes have been visited (1<<N)-1 is 11..11
    int N = graph.length, mask = (1<<N) - 1;
    // use visited to denote for a node-state combo, whether we already visited it before. state is like "0010010" where 0 means the
    // node is not visited, 1 means the node is visited. the reason we need the combo is because we maybe revisited some nodes
    // with different state, such as in the example, each time we back to node 0, but with different state
    int[][] visited = new int[mask+1][N];
    Deque<int[]> deque = new ArrayDeque();

    for (int i=0; i<N; i++) {
      deque.offer(new int[]{i, 1<<i});
      visited[1<<i][i]=1;
    }

    int res = 0;
    while (!deque.isEmpty()) {
      int sz = deque.size();
      for (int i=sz; i>0; i--) {
        int[] cur = deque.poll();
        if (cur[1]==mask) {
          return res;
        }
        for (int n : graph[cur[0]]) {
          int state = cur[1] | (1<<n);
          if (visited[state][n]!=0) {
            continue;
          }
          visited[state][n]=res;
          deque.offer(new int[]{n, state});
        }
      }
      res++;
    }
    return -1;
  }

  public static void main(String... args) {
    // int[][] graph = new int[][]{{1, 2, 3}, {0}, {0}, {0}};
    int[][] graph = new int[][]{{1},{0,2,6},{1,3},{2},{5},{4,6},{1,5,7},{6}};
    int shortestPathLength = shortestPathLength(graph);
    System.out.println(shortestPathLength);
  }
}
