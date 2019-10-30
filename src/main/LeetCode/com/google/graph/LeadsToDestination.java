package com.google.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeadsToDestination {

  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

    // first build a Graph
    List<Integer>[] G = (List<Integer>[]) new List[n];
    for (int i = 0; i < n; i++) G[i] = new ArrayList();
    for (int[] edge : edges) {
      int s = edge[0], t = edge[1];
      G[s].add(t);
    }

    // use dfs to check condition
    Set<Integer> visited = new HashSet();
    if (G[source].size() == 0) return false;
    for (Integer next : G[source]) {
      if (!dfs(next, destination, G, visited, new HashSet()))
        return false;
    }
    return true;
  }

  private boolean dfs(int src, int dest, List<Integer>[] G,
                      Set<Integer> visited, Set<Integer> curSet) {
    // base case
    if (curSet.contains(src)) return false;
    if (visited.contains(src)) return true;
    if (src == dest) return G[dest].size() == 0;
    if (G[src].size() == 0) return false;

    curSet.add(src);
    for (Integer next : G[src]) {
      if (next == src || !dfs(next, dest, G, visited, curSet))
        return false;
    }
    curSet.remove(src);
    visited.add(src);
    return true;
  }

  public static void main(String... args) {
    LeadsToDestination leadsToDestination = new LeadsToDestination();
    int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {1, 2}};
    System.out.println(leadsToDestination.leadsToDestination(4, edges, 0, 3));
  }
}
