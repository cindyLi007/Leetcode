package com.google.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Leetcode 1042
public class FlowerPaintingWithNoAdj {
  // Time: O(N + V)
  public int[] gardenNoAdj(int N, int[][] paths) {
    // build a graph List<Integer>[]
    List<Integer>[] G = (List<Integer>[])new List[N+1];
    for (int i=1; i<=N; i++) G[i] = new ArrayList();
    for (int[] path : paths) {
      int i=path[0], j=path[1];
      G[i].add(j);
      G[j].add(i);
    }

    // for each nodes, check all its neighbors label, avoid any used by it's neighbors and chooose the avaiable smallest label
    int[] res = new int[N];
    for (int i=1; i<=N; i++) {
      Set<Integer> set = new HashSet();
      for (Integer neighbor : G[i]) {
        if (res[neighbor-1]!=0) set.add(res[neighbor-1]);
      }
      for (int color=1; color<=4 && res[i-1]==0; color++) {
        if (!set.contains(color)) res[i-1]=color;
      }
    }
    return res;
  }
}
