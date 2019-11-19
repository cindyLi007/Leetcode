package com.google.bfs.dfs.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {

  public int shortestPathAllKeys(String[] grid) {
    // first find the start point and how many locks and transfer grid to board
    int M = grid.length, N = grid[0].length();
    char[][] board = new char[M][N];
    int[] startPoint = new int[2];
    int locks = findLocks(grid, board, startPoint);
    int mask = (1 << locks) - 1;

    // BFS the grid to find shortest path
    Queue<int[]> queue = new LinkedList();
    queue.offer(new int[]{startPoint[0], startPoint[1], 0}); // save x, y and lock bits as status
    Set<String> visited = new HashSet();
    visited.add(startPoint[0] + "-" + startPoint[1] + "-" + 0); // avoid to visit same status more than once
    int layer = 0;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // Time: O(N*M*2^T) T is number of keys
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i=0; i<size; i++) {
        int[] cur = queue.poll();
        if (hasAllKeys(cur[2], mask)) return layer;
        for (int[] dir : dirs) {
          int x = cur[0]+dir[0], y = cur[1] + dir[1], key = cur[2];
          if (x<0 || y<0 || x>=M || y>=N || board[x][y]=='#') continue;
          char c = board[x][y];
          if (Character.isLowerCase(c)) {
            key |= 1<<(c-'a');
          } else if (Character.isUpperCase(c)) {
            if ((key & 1<<(c-'A'))==0) continue;
          }
          String s = x + "-" + y + "-" + key;
          if (!visited.contains(s)) {
            visited.add(s);
            queue.add(new int[]{x, y, key});
          }
        }
      }
      layer++;
    }

    return -1;
  }

  // Time: O(M*N)
  private int findLocks(String[] grid, char[][] board, int[] startPoint) {
    int count = 0;
    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[0].length(); j++) {
        board[i][j]=grid[i].charAt(j);
        if (board[i][j]=='@') {
          startPoint[0]=i;
          startPoint[1]=j;
        } else if (Character.isUpperCase(board[i][j])) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean hasAllKeys(int key, int mask) {
    return (key ^ mask) == 0;
  }

  public static void main(String... args) {
    ShortestPathToGetAllKeys shortestPathToGetAllKeys = new ShortestPathToGetAllKeys();
    String[] grid = new String[]{"@.a.#", "###.#", "b.A.B"};
    System.out.println(shortestPathToGetAllKeys.shortestPathAllKeys(grid)); // should be 8

    grid = new String[]{".@aA"};
    System.out.println(shortestPathToGetAllKeys.shortestPathAllKeys(grid)); // should be 1

    grid = new String[]{"@..aA", "..B#.", "....b"};
    System.out.println(shortestPathToGetAllKeys.shortestPathAllKeys(grid)); // should be 6

    grid = new String[]{"@...a", ".###A", "b.BCc"};
    System.out.println(shortestPathToGetAllKeys.shortestPathAllKeys(grid)); // should be 10
  }

}
