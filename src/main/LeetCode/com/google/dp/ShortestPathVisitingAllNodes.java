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
    // node is not visited, 1 means the node is visited. the reason we need the combo is because we maybe revisited some nodes, such as
    // the example
    Set<String> visited = new HashSet<>();
    Deque<int[]> queue = new ArrayDeque();

    for (int i=0; i<N; i++) {
      queue.offer(new int[]{i, 1<<i});
    }

    int res = 0;
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i=sz; i>0; i--) {
        int[] cur = queue.poll();
        if (cur[1] == mask)
          return res;
        int[] neighbors = graph[cur[0]];
        for (int n : neighbors) {
          // add new neighbor in state
          int state = cur[1] | (1<<n);
          String combo = n + "-" + state;
          if (!visited.contains(combo)) {
            visited.add(combo);
            queue.offer(new int[]{n, state});
          }
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
