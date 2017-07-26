package com.google.union.find;

import java.util.Arrays;

/**
 * Created by ychang on 6/16/2017.
 */
public class NumberIsland {
  public int numIslands(char[][] grid) {
    int M=grid.length, N=M==0 ? 0 : grid[0].length;
    int[] id = new int[M*N];
    Arrays.fill(id, -1);
    int count = init(grid, id, M, N);
    print(id, M, N);
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        if (grid[i][j]=='1') {
          if (union(grid, M, N, i, j, i, j + 1, id))
            count--;
          if (union(grid, M, N, i, j, i + 1, j, id))
            count--;
        }
      }
      print(id, M, N);
      System.out.println("*************************");
    }
    return count;
  }

  private void print(int[] id, int M, int N) {
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        System.out.format("%3d", id[i*N+j]);
      }
      System.out.println();
    }
  }

  private int init(char[][] grid, int[] id, int M, int N) {
    int count=0;
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        if (grid[i][j]=='1') {
          id[i*N+j]=i*N+j;
          count++;
        }
      }
    }
    return count;
  }
  private boolean union(char[][] grid, int M, int N, int x1, int y1, int x2, int y2, int[] id) {
    if (x2>=M || y2>=N || grid[x2][y2]=='0') return false;
    int p=find(x1*N+y1, id), q=find(x2*N+y2, id);
    if (p!=q) id[q]=p;
    return p!=q ? true : false;
  }
  private int find(int i, int[] id) {
    while(i!=id[i]) {
      id[i]=id[id[i]];
      i=id[i];
    }
    return i;
  }
}
