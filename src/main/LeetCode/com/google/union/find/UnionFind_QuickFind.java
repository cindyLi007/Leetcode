package com.google.union.find;

/**
 * Created by ychang on 12/9/2016.
 */
public class UnionFind_QuickFind {
  private int[] id;

  /*
   O(N)
   */
  public UnionFind_QuickFind(int N) {
    id = new int[N];
    for (int i=0; i<N; i++)
      id[i]=i;
  }

  /*
    find the component id of node p
    O(1)
   */
  public int find(int p) {
    return id[p];
  }

  /*
    change all entries with id[p] to id[q]
    O(N)
   */
  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];
    for (int i=0; i<id.length; i++) {
      if (id[i]==pid) id[i]=qid;
    }
  }

  public boolean isConnected(int p, int q) {
    return id[p]==id[q];
  }
}
