package com.google.design;

/**
 * Created by ychang on 3/12/2017.
 * The key observation is that in order to win Tic-Tac-Toe you must have the ENTIRE row or column. Thus, we don't need
 * to keep track of an entire n^2 board. We only need to keep a count for each row and column. If at any time a row or
 * column matches the SIZE of the board then that player has won.
 * To keep track of which player, add 1 for Player1 and -1 for Player2. There are two additional variables to keep track
 * of the two diagonals. Each time a player moves, just need to check the count of that row, column, diagonal and anti-diagonal.
 */
public class TicTacToe {
  int n;
  int[] rows, cols;
  int dia, antiDia;

  /**
   * Initialize your data structure here.
   */
  public TicTacToe(int n) {
    this.n = n;
    rows = new int[n];
    cols = new int[n];
  }

  /**
   * Player {player} makes a move at ({row}, {col}).
   *
   * @param row    The row of the board.
   * @param col    The column of the board.
   * @param player The player, can be either 1 or 2.
   * @return The current winning condition, can be either:
   * 0: No one wins.
   * 1: Player 1 wins.
   * 2: Player 2 wins.
   */
  public int move(int row, int col, int player) {
    int num = player==1 ? 1 : -1;
    rows[row] += num;
    cols[col] += num;

    if (row==col) {
      dia += num;
    }
    if (row + col==n - 1) {
      antiDia += num;
    }
    if (Math.abs(rows[row])==n || Math.abs(cols[col])==n || Math.abs(dia)==n || Math.abs(antiDia)==n)
      return player;
    return 0;
  }
}
