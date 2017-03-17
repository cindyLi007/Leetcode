package com.google.bfs.dfs.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ychang on 12/8/2016. The problem's key idea is from each building to reach all empty cell instead of from each
 * empty cell to reach all buildings, because buildings are sparse
 */
public class ShortestDistance {
  /**
  this method O(m^2*n^2), beat 70%, so it is around 22 ms, we can have a improvement which is if an empty land has been missed from
  previous buildings, we will skip it for all next building check, because this empty land can not reach to all buildings
   */
  public int shortestDistance(int[][] grid) {
    if (grid==null || grid[0].length==0)
      return 0;
    final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    int m = grid.length, n = grid[0].length;
    int[][] reach = new int[m][n];
    int[][] bNum = new int[m][n];
    int buildings = 0;

    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        /**
        for each building, reach all empty lands, for each empty land, record dist and how many building visit this land
         */
        if (grid[i][j]==1) {
          buildings++;

          Queue<int[]> q = new LinkedList();
          q.add(new int[]{i, j});
          int dis = 1;
          boolean[][] visited = new boolean[m][n];

          while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z<size; z++) {
              int[] node = q.poll();

              for (int[] dir : dirs) {
                int x = node[0] + dir[0], y = node[1] + dir[1];
                if (x<0 || y<0 || x>=m || y>=n || grid[x][y]!=0 || visited[x][y] || bNum[x][y]<buildings-1)
                  continue;
                reach[x][y] += dis;
                bNum[x][y]++;
                q.add(new int[]{x, y});
                visited[x][y] = true;
              }
            }
            dis++;
          }
        }
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if (grid[i][j]==0 && bNum[i][j]==buildings) {
          if (reach[i][j]<res)
            res = reach[i][j];
        }
      }
    }
    return res==Integer.MAX_VALUE ? -1 : res;
  }

  /**
   * beat 78% 13ms, the only difference with best we have another loop to build a build list, but we need not to compute
   * res when visit each building
   */
  public int shortestDistance_improve(int[][] grid) {
    int m=grid.length, n=grid[0].length;
    int res=Integer.MAX_VALUE;
    int[][] dist=new int[m][n];
    int[][] dirs=new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    List<int[]> buildings = new LinkedList();

    // build a building List
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j]==1) buildings.add(new int[]{i, j});
      }
    }

    for (int i=0; i<buildings.size(); i++) {
      int[] b = buildings.get(i);
      Queue<int[]> queue = new LinkedList();
      queue.add(b);
      int level=1;
      while (!queue.isEmpty()) {
        int size=queue.size();
        for (int j=0; j<size; j++) {
          int[] point = queue.poll();
          for (int[] dir : dirs) {
            int x = point[0]+dir[0], y=point[1]+dir[1];
            /**
             * instead of using visited array, we increment empty cell's value, and since it is BFS(we just check current level
             * nodes), we need NOT worry about go further levels
             */
            if (x>=0 && x<m && y>=0 && y<n && grid[x][y]==-i) {
              dist[x][y]+=level;
              grid[x][y]--;
              queue.offer(new int[]{x, y});
              if (i==buildings.size()-1) res=Math.min(res, dist[x][y]);
            }
          }
        }
        level++;
      }
    }
    return res==Integer.MAX_VALUE ? -1 : res;
  }

  /**
   * Similar with shortestDistance_improve, but no need to build a building queue first. Just improved from shortestDistance
   * the improvement is from the first building I only walk onto cells where grid is 0, and make them -1, so anytime we only
   * check grid[x][y]=-building_number. 12 ms, beat 82%
   */
  public int shortestDistance_best(int[][] grid) {
    int m=grid.length, n=grid[0].length;
    int res=Integer.MAX_VALUE;
    int bnum=0;
    int[][] dist=new int[m][n];
    int[][] dirs=new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j]==1) {
          res=Integer.MAX_VALUE;
          Queue<int[]> queue = new LinkedList();
          queue.offer(new int[]{i, j});
          int level=1;
          while(!queue.isEmpty()) {
            int size=queue.size();
            for (int z=0; z<size; z++) {
              int[] point = queue.poll();
              for (int[] dir : dirs) {
                int x = point[0]+dir[0], y=point[1]+dir[1];
                if (x>=0 && x<m && y>=0 && y<n && grid[x][y]==-bnum) {
                  dist[x][y]+=level;
                  grid[x][y]--;
                  queue.offer(new int[]{x, y});
                  res=Math.min(res, dist[x][y]);
                }
              }
            }
            level++;
          }
          bnum++;
        }
      }
    }
    return res==Integer.MAX_VALUE ? -1 : res;
  }

  public static void main(String[] args) {
    ShortestDistance sd = new ShortestDistance();
    int[][] array = new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    int res = sd.shortestDistance_best(array);
    System.out.println(res);
  }
}
