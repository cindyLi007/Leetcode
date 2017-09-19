package com.google.bfs.dfs.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ychang on 12/8/2016.
 */
public class NumberOfIslands {
  public int numIslands_dfs(char[][] grid) {
    if (grid==null || grid.length==0 || grid[0].length==0) {
      return 0;
    }
    int m = grid.length, n = grid[0].length, count = 0;
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if (grid[i][j]=='1') {
          // use dfs rather than bfs, it is mush faster
          dfs(grid, i, j, m, n);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int i, int j, int m, int n) {
    // set grid[i][j] to 0, so need NOT use visited[][] array.
    grid[i][j] = '0';
    /*
      must do for all 4 directions, not only right and down.
      for example ["111","010","111"], result is 1, if only check right and down, will miss grid[2][0], make result as 2
     */
    int[][] dirs=new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int[] dir : dirs) {
      int x=i+dir[0], y=j+dir[1];
      if (x>=0 && x<m && y>=0 && y<n && grid[x][y]=='1') dfs(grid, m, n, x, y);
    }
  }

  public int numIslands_bfs(char[][] grid) {
    int M=grid.length, N=M==0 ? 0 : grid[0].length;
      int count=0;
    Queue<int[]> queue = new LinkedList();
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        if (grid[i][j]=='1') {
          queue.offer(new int[]{i, j});
          grid[i][j]='0';
          while (!queue.isEmpty()) {
            int[] point = queue.poll();
            bfs(grid, M, N, point[0], point[1], queue);
          }
          count++;
        }
      }
    }
    return count;
  }

  private void bfs(char[][] grid, int M, int N, int i, int j, Queue<int[]> queue) {
    int[][] dirs=new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int[] dir : dirs) {
      int x=i+dir[0], y=j+dir[1];
      if (x>=0 && x<M && y>=0 && y<N && grid[x][y]=='1') {
        queue.offer(new int[]{x, y});
        /**
         * must set grid[i][j]='0' when add it to queue, so its neighbor will NOT visit it again.
         * Otherwise will introduce dead loop
         */
        grid[x][y]='0';
      }
    }
  }

  public static void main(String[] args) {
    NumberOfIslands instance = new NumberOfIslands();
    //    char[][] grid = new char[][]{"111".toCharArray(), "010".toCharArray(), "111".toCharArray()};
    //    char[][] grid = new char[][]{"11110".toCharArray(), "11010".toCharArray(), "11000".toCharArray(),"00000".toCharArray()};
    char[][] grid = new char[][]{"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()};
    int result = instance.numIslands_dfs(grid);
    System.out.println(result);
  }
}
