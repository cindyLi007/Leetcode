package com.google.union.find;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ychang on 6/15/2017.
 */
public class FriendCircle {
  public int findCircleNum(int[][] M) {
    int N = M.length;
    int[] id = new int[N], sz = new int[N];
    for (int i = 0; i<N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
    for (int i = 0; i<N; i++) {
      for (int j = i + 1; j<N; j++) {
        if (M[i][j]==1) {
          int p = find(i, id), q = find(j, id);
          if (q!=p) {
            if (sz[p]>sz[q]) {
              id[q] = p;
              sz[p] += sz[q];
            } else {
              id[p] = q;
              sz[q] += sz[p];
            }
          }
        }
      }
    }
    Set<Integer> set = new HashSet();
    for (int i = 0; i<N; i++) {
      set.add(find(i, id));
    }
    return set.size();
  }

  private int find(int i, int[] id) {
    while (id[i]!=i) {
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }
}
