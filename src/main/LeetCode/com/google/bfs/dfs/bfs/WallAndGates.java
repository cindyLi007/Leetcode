package com.google.bfs.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ychang on 12/13/2016.
 */
public class WallAndGates {
  // this can beat 42%
  public void wallsAndGates(int[][] rooms) {
    if (rooms==null || rooms.length==0 || rooms[0].length==0)
      return;
    int m = rooms.length, n = rooms[0].length;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    Queue<int[]> gateList = new LinkedList();
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if (rooms[i][j]==0)
          gateList.add(new int[]{i, j});
      }
    }

    while (!gateList.isEmpty()) {
      int[] node = gateList.remove();
      for (int[] dir : dirs) {
        int x = node[0] + dir[0], y = node[1] + dir[1];
        /**
        * we just need check rooms[x][y]!=Integer.MAX_VALUE, because if rooms[x][y]!=Integer.MAX_VALUE, that means we have
        * visited this node, since BFS guarantee we always first hit with shortest level, we can ignore check as
        * rooms[x][y]!= rooms[node[0]][node[1]] + 1, that will significantly improve performance
        */
        if (x<0 || y<0 || x>=m || y>=n || rooms[x][y]!=Integer.MAX_VALUE)
          continue;
        rooms[x][y] = rooms[node[0]][node[1]] + 1;
        gateList.add(new int[]{x, y});
      }
    }
  }

  // this can beat 85%
  int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  public void wallsAndGates_dfs_faster(int[][] rooms) {
    int M=rooms.length, N=M==0? 0 : rooms[0].length;
    if (M==0 || N==0) return;
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        if (rooms[i][j]==0)
          dfs(rooms, M, N, i, j, 1);
      }
    }
  }

  private void dfs(int[][] rooms, int M, int N, int i, int j, int dis) {
    for (int[] dir : dirs) {
      int x=i+dir[0], y=j+dir[1];
      if (x>=0 && x<M && y>=0 && y<N && rooms[x][y]>dis) {
        rooms[x][y]=dis;
        dfs(rooms, M, N, x, y, dis+1);
      }
    }
  }
}
