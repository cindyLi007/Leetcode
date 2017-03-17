package com.google.union.find;

/**
 * Created by ychang on 3/13/2017.
 */
public class NumberIslands {
  public int numIslands(char[][] grid) {
    if (grid.length==0 || grid[0].length==0)
      return 0;
    int m = grid.length, n = grid[0].length;
    UnionFind uf = new UnionFind(m, n, grid);
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if (grid[i][j]=='1') {
          if (i<m - 1 && grid[i+1][j]=='1')
            uf.union(i*n + j, (i + 1)*n + j);
          if (j<n - 1 && grid[i][j+1]=='1')
            uf.union(i*n + j, i*n + (j + 1));
        }
      }
    }
    return uf.count;
  }

  class UnionFind {
    int[] id;
    int count;
    final int m, n;

    void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP!=rootQ) {
        id[rootQ] = rootP;
        count--;
      }
    }

    int find(int node) {
      while (node!=id[node]) {
        id[node] = id[id[node]];
        node = id[node];
      }
      return node;
    }

    UnionFind(int x, int y, char[][] grid) {
      m = x;
      n = y;
      id = new int[m*n];
      for (int i = 0; i<m; i++) {
        for (int j = 0; j<n; j++) {
          if (grid[i][j]=='1') {
            count++;
            id[i*n + j] = i*n + j;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    NumberIslands instance = new NumberIslands();
    //    char[][] grid = new char[][]{"111".toCharArray(), "010".toCharArray(), "111".toCharArray()};
        char[][] grid = new char[][]{"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()};
    int result = instance.numIslands(grid);
    System.out.println(result);
  }
}
