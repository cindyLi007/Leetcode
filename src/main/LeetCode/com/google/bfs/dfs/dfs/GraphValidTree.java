package com.google.bfs.dfs.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ychang on 9/14/2017.
 */
public class GraphValidTree {
  /**
   * a valid tree is a tree which from any node can go to all other nodes, and there is no cycle
   * so we can from any node to dfs, during dfs check whether there is a cycle, after dfs, check whether we visited all nodes
   */
  public boolean validTree(int n, int[][] edges) {
    Set<Integer>[] graph = buildGraph(n, edges);
    boolean[] visited = new boolean[n];
    // we randomly choose node 0, to dfs all nodes
    if (!dfs(graph, 0, visited, -1))
      return false;
    for (int i = 0; i<n; i++)
      if (!visited[i])
        return false;
    return true;
  }

  private boolean dfs(Set<Integer>[] graph, int node, boolean[] visited, int parent) {
    if (visited[node])
      return true;
    visited[node] = true;
    for (Integer n : graph[node]) {
      /** if a neighbor has been visited, but not this node's direct parent, there must be a cycle, for example
       * [1, 2], [2, 3], [1, 3], when we go to 3, 1 is it's neighbor, but 3's parent is 2, so there is a cycle
       */
      if (visited[n] && parent!=n || !visited[n] && !dfs(graph, n, visited, node))
        return false;
    }
    return true;
  }

  private Set<Integer>[] buildGraph(int n, int[][] edges) {
    Set<Integer>[] map = new HashSet[n];
    for (int i = 0; i<n; i++)
      map[i] = new HashSet();
    for (int[] edge : edges) {
      int x = edge[0], y = edge[1];
      map[x].add(y);
      map[y].add(x);
    }
    return map;
  }
}
