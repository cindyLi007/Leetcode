package com.google.array.bit.manipulation;

import java.util.Arrays;

/**
 * Created by ychang on 12/13/2016.
 */
public class GameOfLife {
  /**
   * [2nd bit, 1st bit] = [next state, current state]
   - 00  dead (next) <- dead (current)
   - 01  dead (next) <- live (current)
   - 10  live (next) <- dead (current)
   - 11  live (next) <- live (current)
   */
  public void gameOfLife(int[][] board) {
    if (board==null || board.length==0 || board[0].length==0)
      return;
    int m = board.length, n = board[0].length;

    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        int lives = findLives(board, m, n, i, j);
        if (board[i][j]==0 && lives==3)
          board[i][j] = 2; // 00 -> 10
        else if (board[i][j]==1 && (lives==2 || lives==3))
          board[i][j] = 3; //01 -> 11
      }
    }

    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        // shift right to get rid of prev status
        board[i][j] >>= 1;
      }
    }
  }

  int findLives(int[][] board, int m, int n, int x, int y) {
    int res = 0;
    for (int i = -1; i<=1; i++) {
      for (int j = -1; j<=1; j++) {
        /*
         * please notice (board[x + i][y + j] & 1)==1, we need use board[i][j]&1 to only check previous status.
         * in case the value has been changed
         */
        if ((x + i)>=0 && (x + i)<m && (y + j)>=0 && (y + j)<n && (board[x + i][y + j] & 1)==1)
          res++;
      }
    }
    res -= (board[x][y] & 1);
    return res;
  }

  public static void main(String[] args) {
    GameOfLife gameOfLife = new GameOfLife();
    //    int[][] board = new int[][]{{1}};
    int[][] board = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
    gameOfLife.gameOfLife(board);
    for (int[] row : board) {
      Arrays.stream(row).forEach(i -> System.out.print(i + " "));
      System.out.println();
    }
  }
}
