package com.google.union.find;

/**
 * Created by ychang on 12/8/2016.
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    if (grid==null || grid.length==0 || grid[0].length==0)
      return 0;
    UnionFind uf = new UnionFind(grid);
    for (int i = 0; i<grid.length; i++) {
      for (int j = 0; j<grid[0].length; j++) {
        if (grid[i][j]=='1') {
          /**
          only need union nodes in right and down, because left and up node already union-ed this node.
          it is not like dfs, dfs we always need check all directions, because we have a visited array, if
          we only check right and down, for ["111", "010", "111"], we will miss [2][0]. see detail in
          {@link com.google.bfs.dfs.dfs.NumberOfIslands}
           */
          uf.union(i + 1, j, i, j, grid);
          uf.union(i, j + 1, i, j, grid);
        }
      }
    }
    return uf.count;
  }

  class UnionFind {
    private int[] id;
    int count;
    private final int m, n;

    public UnionFind(char[][] grid) {
      m = grid.length;
      n = grid[0].length;
      id = new int[m*n];
      for (int i = 0; i<m; i++) {
        for (int j = 0; j<n; j++) {
          if (grid[i][j]=='1') {
            count++;
            id[i*n + j] = i*n + j;
          }
        }
      }
    }

    public void union(int x, int y, int i, int j, char[][] grid) {
      if (x<0 || y<0 || x>=m || y>=n || grid[x][y]=='0')
        return;
      int rootP = find(x*n + y);
      int rootQ = find(i*n + j);
      if (rootP==rootQ) return;
      id[rootP] = rootQ;
      count--;
    }

    private int find(int x) {
      while (id[x]!=x) {
        // Make every other node in path point to its grandparent, flatting the tree to void long path to ancestor
        id[x]=id[id[x]];
        x = id[x];
      }
      return x;
    }
  }

  public static void main(String[] args) {
    NumberOfIslands instance = new NumberOfIslands();
    //    char[][] grid = new char[][]{"111".toCharArray(), "010".toCharArray(), "111".toCharArray()};
//    char[][] grid = new char[][]{"11110".toCharArray(), "11010".toCharArray(), "11000".toCharArray(), "00000".toCharArray()};
        char[][] grid = new char[][]{"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()};
    int result = instance.numIslands(grid);
    System.out.println(result);
  }
}
