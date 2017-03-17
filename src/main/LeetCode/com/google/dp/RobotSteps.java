package com.google.dp;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ychang on 3/9/2017.
 */
public class RobotSteps {
  public boolean getPath(int[][] grid) {
    int x=grid.length-1, y=grid[0].length-1;
    List<Point> path = new LinkedList<>();
    Map<Point, Boolean> cache = new HashMap<>();

    boolean res = getPath(grid, x, y, path, cache);
    return res;
  }

  private boolean getPath(int[][] grid, int x, int y, List<Point> path, Map<Point, Boolean> cache) {
    if (x==0 && y==0) return true;
    Point key = new Point(x, y);
    if (cache.containsKey(key))
      return cache.get(key);
    boolean res=false;
    if (x>0 && grid[x-1][y]==0) {
      res = getPath(grid, x - 1, y, path, cache);
    }
    if (!res && (y>0 && grid[x][y-1]==0)) {
      res = getPath(grid, x, y - 1, path, cache);
    }
    if (res)
      path.add(key);
    cache.put(key, res);
    return res;
  }
}
