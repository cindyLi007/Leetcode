package com.google.union.find;

/**
 * Created by ychang on 12/9/2016.
 */
public class UnionFind_QuickUnion {
  int[] id;

  public UnionFind_QuickUnion(int N) {
    id = new int[N];
    for (int i=0; i<N; i++) {
      id[i]=i;
    }
  }

  /*
  O(N)
   */
  public void union(int p, int q) {
    int idp = find(p);
    int idq = find(q);
    id[idp] = idq;
  }

  /*
  find node's root node (root node means id[p]=p)
  O(N)
   */
  public int find(int p) {
    while (id[p]!=p) p=id[p];
    return p;
  }

  public boolean isConnected(int p, int q) {
    return find(p)==find(q);
  }
}
