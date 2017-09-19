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
  public void wallsAndGates_dfs_faster(int[][] rooms) {
    for (int i=0; i<rooms.length; i++) {
      for (int j=0; j<rooms[0].length; j++) {
        if (rooms[i][j]==0) dfs(rooms, i, j, 0);
      }
    }
  }
  private void dfs(int[][] rooms, int x, int y, int dis) {
    /**
     * must rooms[x][y]<dis, not rooms[x][y]<=dis, because from a gate, dis=0, if room[x][y]<=dis, will skip all gates
     */
    if (x<0 || y<0 || x>=rooms.length || y>=rooms[0].length || rooms[x][y]<dis) return;
    rooms[x][y]=dis;
    // use this way instead of dirs[][], faster
    dfs(rooms, x+1, y, dis+1);
    dfs(rooms, x-1, y, dis+1);
    dfs(rooms, x, y+1, dis+1);
    dfs(rooms, x, y-1, dis+1);
  }
}
