package com.google.bfs.dfs.dfs;

import java.util.Queue;

/**
 * Created by ychang on 12/8/2016.
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    if (grid==null || grid.length==0 || grid[0].length==0) {
      return 0;
    }
    int m = grid.length, n = grid[0].length, count = 0;
//  Queue<int[]> queue = new LinkedListCycle();
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if (grid[i][j]=='1') {
          // use dfs rather than bfs, it is mush faster
          dfs(grid, i, j, m, n);
          /* bfs code
          queue.offer(new int[]{i, j});
          // must set grid[i][j]='0' when add it to queue, so its neighbor will NOT visit it again.
          grid[i][j]='0';
          while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x=node[0], y=node[1];
            // same as DFS, must check all 4 directions, not only right and down. for example ["111","010","111"]
            bfs(grid, queue, x-1, y, m, n);
            bfs(grid, queue, x+1, y, m, n);
            bfs(grid, queue, x, y-1, m, n);
            bfs(grid, queue, x, y+1, m, n);
          }
          */
          count++;
        }
      }
    }
    return count;
  }

  private void bfs(char[][] grid, Queue<int[]> queue, int i, int j, int m, int n) {
    if (i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0') {
      return;
    }
    /**
     * must set grid[i][j]='0' when add it to queue, so its neighbor will NOT visit it again.
     * Otherwise will introduce dead loop
     */
    grid[i][j]='0';
    queue.offer(new int[]{i, j});
  }

  private void dfs(char[][] grid, int i, int j, int m, int n) {
    if (i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')
      return;
    // set grid[i][j] to 0, so need NOT use visited[][] array.
    grid[i][j] = '0';
    /*
      must do for all 4 directions, not only right and down.
      for example ["111","010","111"], result is 1, if only check right and down, will miss grid[2][0], make result as 2
     */
    dfs(grid, i - 1, j, m, n);
    dfs(grid, i + 1, j, m, n);
    dfs(grid, i, j - 1, m, n);
    dfs(grid, i, j + 1, m, n);
  }

  public static void main(String[] args) {
    NumberOfIslands instance = new NumberOfIslands();
    //    char[][] grid = new char[][]{"111".toCharArray(), "010".toCharArray(), "111".toCharArray()};
    //    char[][] grid = new char[][]{"11110".toCharArray(), "11010".toCharArray(), "11000".toCharArray(),"00000".toCharArray()};
    char[][] grid = new char[][]{"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()};
    int result = instance.numIslands(grid);
    System.out.println(result);
  }
}
