package com.google.bfs.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ychang on 12/13/2016.
 */
public class WallAndGates {
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
        we just need check rooms[x][y]!=Integer.MAX_VALUE, because if rooms[x][y]!=Integer.MAX_VALUE, that means we have
        been this node, since BFS guarantee we always first hit with shortest level, we can ignore check as
        rooms[x][y]!= rooms[node[0]][node[1]] + 1, that will significantly improve performance
         */
        if (x<0 || y<0 || x>=m || y>=n || rooms[x][y]!=Integer.MAX_VALUE)
          continue;
        rooms[x][y] = rooms[node[0]][node[1]] + 1;
        gateList.add(new int[]{x, y});
      }
    }
  }
}
