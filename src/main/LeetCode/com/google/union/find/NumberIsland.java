package com.google.union.find;

public class NumberIsland {
  public int numIslands(char[][] grid) {
    int M = grid.length, N = M==0 ? 0 : grid[0].length;
    int[] union = new int[M*N], sz = new int[M*N];
    int count = buildUnion(grid, union, sz, M, N);
    for (int i = 0; i<M; i++) {
      for (int j = 0; j<N; j++) {
        if (grid[i][j]=='1') {
          if (i<M - 1 && grid[i + 1][j]=='1' && bind(union, sz, i*N + j, (i + 1)*N + j))
            count--;
          if (j<N - 1 && grid[i][j + 1]=='1' && bind(union, sz, i*N + j, i*N + j + 1))
            count--;
        }
      }
    }
    print(union, M, N);
    return count;
  }

  private boolean bind(int[] union, int[] sz, int x, int y) {
    int p = find(x, union), q = find(y, union);
    if (p!=q) {
      if (sz[p]>sz[q]) {
        union[q] = p;
        sz[p] += sz[q];
      } else {
        union[p] = q;
        sz[q] += sz[p];
      }
    }
    return p!=q ? true : false;
  }

  private int find(int x, int[] union) {
    while (union[x]!=x) {
      union[x] = union[union[x]];
      x = union[x];
    }
    return x;
  }

  private int buildUnion(char[][] grid, int[] union, int[] sz, int M, int N) {
    int count = 0;
    for (int i = 0; i<M; i++) {
      for (int j = 0; j<N; j++) {
        if (grid[i][j]=='1') {
          count++;
          union[i*N + j] = i*N + j;
          sz[i*N + j] = 1;
        }
      }
    }
    return count;
  }

  private void print(int[] id, int M, int N) {
    for (int i = 0; i<M; i++) {
      for (int j = 0; j<N; j++) {
        System.out.format("%3d", id[i*N + j]);
      }
      System.out.println();
    }
  }
}
