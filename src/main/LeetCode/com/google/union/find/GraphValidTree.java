package com.google.union.find;

/**
 * Created by ychang on 9/17/2017. this can beat 63%
 * a valid tree is a tree which from any node can go to all other nodes, and there is no cycle
 * we can use union find to do it, during connect all nodes, we check if a new edge's 2 nodes has already connected, if yes, that
 * means there is another node connected both of them before we check them, so there is a loop.
 */
public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    // a valid tree to connect n nodes must have and only have n-1 edges, >n-1 means have cycle, <n-1 have some isolated nodes
    if (edges.length!=n - 1)
      return false;
    int[] id = new int[n], sz = new int[n];
    for (int i = 0; i<n; i++) {
      id[i] = i;
      sz[i] = 0;
    }
    int count = n;
    for (int[] edge : edges) {
      int x = edge[0], y = edge[1];
      int p = find(x, id), q = find(y, id);
      if (p==q)
        return false;
      int small = sz[p]<sz[q] ? p : q;
      int big = sz[p]<sz[q] ? q : p;
      id[small] = big;
      sz[big] += sz[small];
      count--;
    }
    return count==1;
  }

  private int find(int p, int[] id) {
    while (p!=id[p]) {
      id[p] = id[id[p]];
      p = id[p];
    }
    return p;
  }
}