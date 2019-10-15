package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 8/7/2017.
 */
public class WordSearch {
  // Time: O(N*M*4^L), Space: O(L)
  public boolean exist(char[][] board, String word) {
    if (board==null || board.length==0 || board[0].length==0 || word==null || word.length()==0) return false;
    int M=board.length, N=board[0].length;
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        if (dfs(board, M, N, i, j, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }
  private boolean dfs(char[][] board, int M, int N, int i, int j, String word, int index) {
    if (index==word.length()) return true;
    if (i<0 || i>=M || j<0 || j>=N || word.charAt(index)!=board[i][j]) return false;
    // set a used position char as '-', that is to prevent this position char is used another time in next search
    board[i][j]='-';
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int[] dir : dirs) {
      if (dfs(board, M, N, i+dir[0], j+dir[1], word, index+1)) return true;
    }
    // recover this position to correct char
    board[i][j]=word.charAt(index);
    return false;
  }
}

