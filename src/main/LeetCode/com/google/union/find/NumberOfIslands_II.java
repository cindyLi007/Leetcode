package com.google.union.find;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 12/12/2016.
 */
public class NumberOfIslands_II {
  int[] uf, sz;
  int num;

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> list = new LinkedList();
    uf = new int[m*n];
    sz = new int[m*n];
    Arrays.fill(uf, -1);
    Arrays.fill(sz, 0);
    num = 0;
    for (int[] p : positions) {
      int x = p[0], y = p[1];
      if (uf[x*n + y]==-1) {
        sz[x*n + y] = 1;
        uf[x*n + y] = x*n + y;
        num++;
        union(x, y, x - 1, y, m, n);
        union(x, y, x + 1, y, m, n);
        union(x, y, x, y - 1, m, n);
        union(x, y, x, y + 1, m, n);
        list.add(num);
      }
    }
    return list;
  }

  void union(int i, int j, int x, int y, int m, int n) {
    if (x<0 || x>=m || y<0 || y>=n || uf[x*n + y]==-1)
      return;
    int p = find(i*n + j);
    int q = find(x*n + y);
    if (p!=q) {
      if (sz[p]<sz[q]) {
        uf[p] = q;
        sz[q] += sz[p];
      } else {
        uf[q] = p;
        sz[p] += sz[q];
      }
      num--;
    }
  }

  int find(int node) {
    while (uf[node]!=node) {
      uf[node] = uf[uf[node]];
      node = uf[node];
    }
    return node;
  }

  public static void main(String[] args) {
    NumberOfIslands_II numberOfIslands_ii = new NumberOfIslands_II();
    //    List<Integer> res = numberOfIslands_ii.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}});
    List<Integer> res = numberOfIslands_ii.numIslands2(3, 3, new int[][]{{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}});
    res.forEach(System.out::println);
  }
}
