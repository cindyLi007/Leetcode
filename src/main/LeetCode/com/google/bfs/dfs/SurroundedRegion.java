package com.google.bfs.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ychang on 1/14/2017.
 * Check four boundaries, use BFS (could not use dfs, will have stack overflow error) to find all 'O' nodes connected
 * with boundary 'O' nodes, set it to 'p'. If a node still 'O', that means there is no any boundary 'O' node connected to it.
 * Should flip it it 'X'.
 */
public class SurroundedRegion {
  public void solve(char[][] board) {
    if (board==null || board.length<=2 || board[0].length<=2) return;
    int m=board.length, n=board[0].length;
    Queue<int[]> q = new LinkedList();
    // upper and lower boundaries
    for (int j=0; j<m; j+=m-1) {
      for (int i=0; i<n; i++) {
        checkLine(board, m, n, q, j, i);
      }
    }
    // left and right boundaries
    for (int j=0; j<n; j+=n-1) {
      for (int i=0; i<m; i++) {
        checkLine(board, m, n, q, i, j);
      }
    }
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (board[i][j]=='O') {
          board[i][j]='X';
        } else if (board[i][j]=='p') {
          board[i][j]='O';
        }
      }
    }
  }

  private void checkLine(char[][] board, int m, int n, Queue<int[]> q, int j, int i) {
    if (board[j][i]=='O') {
      board[j][i]='p';
      q.offer(new int[]{j, i});
      while (!q.isEmpty()) {
        int[] node = q.poll();
        int x=node[0], y=node[1];
        bfs(x+1, y, board, m, n, q);
        bfs(x-1, y, board, m, n, q);
        bfs(x, y+1, board, m, n, q);
        bfs(x, y-1, board, m, n, q);
      }
    }
  }

  private void bfs(int x, int y, char[][] board, int m, int n, Queue<int[]> q) {
    if (x<0 || x>=m || y<0 || y>=n || board[x][y]!='O') return;
    board[x][y]='p';
    q.offer(new int[]{x, y});
  }
}
