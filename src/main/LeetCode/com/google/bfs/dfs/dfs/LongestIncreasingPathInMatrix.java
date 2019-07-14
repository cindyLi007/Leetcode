package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/23/2017.
 */
public class LongestIncreasingPathInMatrix {
  /**
   * The key is to cache the distance because it's highly possible to revisit a cell
   */
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix==null || matrix.length==0 || matrix[0].length==0)
      return 0;
    int m = matrix.length, n = matrix[0].length;
    /**
     * cache store maxPath starting from this cell.
     */
    int[][] cache = new int[m][n];
    int res = 1;
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        res = Math.max(res, dfs(i, j, matrix, cache));
      }
    }
    return res;
  }

  private int dfs(int x, int y, int[][] matrix, int[][] cache) {
    // base case
    if (cache[x][y]!=0)
      return cache[x][y];
    int v = matrix[x][y];
    int res = 1;
    if (x>0 && matrix[x - 1][y]>v) {
      /**
       * please note, must be dfs() + 1, because dfs function returns the max path from greater adjacent cell, not count_bruteForce cell(x, y)
       */
      res = Math.max(res, dfs(x - 1, y, matrix, cache) + 1);
    }
    if (y>0 && matrix[x][y - 1]>v) {
      res = Math.max(res, dfs(x, y - 1, matrix, cache) + 1);
    }
    if (x<matrix.length - 1 && matrix[x + 1][y]>v) {
      res = Math.max(res, dfs(x + 1, y, matrix, cache) + 1);
    }
    if (y<matrix[0].length - 1 && matrix[x][y + 1]>v) {
      res = Math.max(res, dfs(x, y + 1, matrix, cache) + 1);
    }
    /**
     * before return, store maxPath to cache for next use.
     */
    cache[x][y] = res;
    return cache[x][y];
  }

  /**
   * The key is to cache the distance because it's highly possible to revisit a cell
   */
  public int longestIncreasingPath_mySolution(int[][] matrix) {
    if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
    int m=matrix.length, n=matrix[0].length;
    int res=1;
    /**
     * cache stores maxPath starting from this cell, no matter adjacent cell greater or less
     */
    cache = new int[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (isValid(i, j, m, n, matrix)) {
          res = Math.max(res, dfs(i, j, m, n, matrix, Integer.MIN_VALUE, 0));
        }
      }
    }
    return res;
  }

  int[][] cache;

  private int dfs(int i, int j, int m, int n, int[][] matrix, int prev, int depth) {
    // base case, terminate path
    if (i<0 || j<0 || i>=m || j>=n || matrix[i][j]<=prev) return depth;
    /** if we have calculate maxPath from cell(i, j) and now we are sure cell(i, j} > prev, we can directly add
     * maxPath of cell(i, j) to depth, depth is the path length till i, j
     */
    if (cache[i][j]!=0) return cache[i][j]+depth;
    int v = matrix[i][j];
    int m1 = Math.max(dfs(i-1, j, m, n, matrix, v, depth+1), dfs(i, j-1, m, n, matrix, v, depth+1));
    int m2 = Math.max(dfs(i, j+1, m, n, matrix, v, depth+1), dfs(i+1, j, m, n, matrix, v, depth+1));
    int max = Math.max(m2, m1);
    // must deduct depth from max to store MaxPath from cell(i, j), because now the max is the path include some path before cell(i,j)
    cache[i][j] = max - depth;
    return max;
  }

  private boolean isValid(int i, int j, int m, int n, int[][] a) {
    int v = a[i][j];
    if (i>0 && a[i-1][j]<v || j>0 && a[i][j-1]<v || i<m-1 && a[i+1][j]<v || j<n-1 && a[i][j+1]<v) return false;
    return true;
  }
}
