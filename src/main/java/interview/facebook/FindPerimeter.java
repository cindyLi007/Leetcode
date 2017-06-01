package interview.facebook;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a colored grid and one position inside the grid, find out the perimeter of the same-colored shape in which the
 * position belongs to.

 4x4 grid

   0 1 2 3
 0 1 1 1 1
 1 1 1 1 1
 2 1 1 0 1
 3 1 1 1 1
 Point: (2, 2) is a 0 pixel
 Perimeter: 4

   0 1 2 3
 0 1 1 1 1
 1 1 1 1 1
 2 1 0 0 1
 3 1 1 1 1
 Point: (2, 2) is a 0 pixel
 Perimeter: 6

   0 1 2 3
 0 1 0 0 0
 1 1 1 0 1
 2 1 1 0 1
 3 1 1 1 1
 Point: (2, 2) is a 0 pixel
 Perimeter: 12
 */
public class FindPerimeter {
  int findPerimeter(int [][] grid, int r, int c) {
    // counting can based on left, right, up and down
    /**
     * please note we must use {@link Point} instead of int[]{}, because different int[]s have different hashcode, even
     * the contents are same.
     */
    Set<Point> visited = new HashSet();
    int res=dfs(grid, r, c, grid[r][c], visited);
    return res;
  }

  private int dfs(int[][] grid, int r, int c, int color, Set<Point> visited) {
    int m=grid.length, n=grid[0].length;
    if (visited.contains(new Point(r, c)))
      return 0;
    // grid[r][c]!=color mean it can be treated as a boundary, if hit grid boundary, count 1
    if (r==m || r<0 || c==n || c<0 || grid[r][c]!=color) return 1;
    /**
     * only same color points need to be put in visited set
     */
    visited.add(new Point(r, c));
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int res=0;
    for (int[] dir : dirs) {
      int x=r+dir[0], y=c+dir[1];
      res+=dfs(grid, x, y, color, visited);
    }
    return res;
  }
}

/**
 * The time complexity for DFS is O(n + m). (|V|=n and |E|=m) We get this complexity considering the fact that we are
 * visiting each node only once and in the case of a tree (no cycles) we are crossing all the edges once.
 */
