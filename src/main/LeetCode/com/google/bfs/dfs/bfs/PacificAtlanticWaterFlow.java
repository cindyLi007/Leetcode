package com.google.bfs.dfs.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ychang on 3/2/2017. DFS is faster than BFS
 * Notice, we should NOT use a visited matrix, because each cell we should from 4 directions to check whether it can flow
 * to Pacific and Atlantic. If after one direction check, we set the cell visited and skip it when check from other direction,
 * we will loose other hint. For example,
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * for cell [2,1] which is 6, it can flow to Pacific from 6->5->4->3. but if we only check 7 or 9, we think it could not
 * flow to Pacific
 */
public class PacificAtlanticWaterFlow {
  // beat 88%
  public List<int[]> pacificAtlantic_dfs(int[][] matrix) {
    List<int[]> res = new LinkedList();
    if (matrix==null || matrix.length==0 || matrix[0].length==0) return res;
    int m=matrix.length, n=matrix[0].length;

    boolean[][] p = new boolean[m][n];
    boolean[][] a = new boolean[m][n];
    for (int i=0; i<m; i++) {
      dfs(p, matrix, i, 0, Integer.MIN_VALUE);
      dfs(a, matrix, i, n-1, Integer.MIN_VALUE);
    }
    for (int i=0; i<n; i++) {
      dfs(p, matrix, 0, i, Integer.MIN_VALUE);
      dfs(a, matrix, m-1, i, Integer.MIN_VALUE);
    }
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (p[i][j] && a[i][j]) res.add(new int[]{i, j});
      }
    }
    return res;
  }
  int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private void dfs(boolean[][] visited, int[][] matrix, int x, int y, int prev) {
    int m=matrix.length, n=matrix[0].length;
    if (x<0 || x>=m || y<0 || y>=n || visited[x][y] || matrix[x][y]<prev) return;
    visited[x][y]=true;
    for (int[] dir : dirs) {
      dfs(visited, matrix, x+dir[0], y+dir[1], matrix[x][y]);
    }
  }

  // beat 37%
  public List<int[]> pacificAtlantic_bfs(int[][] matrix) {
    List<int[]> res = new LinkedList();
    if (matrix==null || matrix.length==0 || matrix[0].length==0)
      return res;
    int m = matrix.length, n = matrix[0].length;

    // create 2 boolean matrix for P and A and initialize borders
    boolean[][] p = new boolean[m][n];
    boolean[][] a = new boolean[m][n];
    Queue<int[]> pq = new LinkedList();
    Queue<int[]> aq = new LinkedList();
    for (int i = 0; i<m; i++) {
      p[i][0] = true;
      a[i][n - 1] = true;
      pq.add(new int[]{i, 0});
      aq.add(new int[]{i, n - 1});
    }
    for (int i = 0; i<n; i++) {
      p[0][i] = true;
      a[m - 1][i] = true;
      pq.add(new int[]{0, i});
      aq.add(new int[]{m - 1, i});
    }

    // bfs to find p[i][j] and a[i][j]
    bfs(matrix, pq, p);
    bfs(matrix, aq, a);

    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if (p[i][j] && a[i][j]) {
          res.add(new int[]{i, j});
        }
      }
    }
    return res;
  }

  private void bfs(int[][] matrix, Queue<int[]> visited, boolean[][] array) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    while (!visited.isEmpty()) {
      int[] cur = visited.poll();
      for (int[] dir : dirs) {
        int x = cur[0] + dir[0], y = cur[1] + dir[1];
        if (x<0 || x>=m || y<0 || y>=n || array[x][y] || matrix[x][y]<matrix[cur[0]][cur[1]])
          continue;
        array[x][y] = true;
        visited.offer(new int[]{x, y});
      }
    }
  }
}
