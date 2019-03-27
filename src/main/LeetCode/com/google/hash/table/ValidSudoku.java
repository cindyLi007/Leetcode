package com.google.hash.table;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ychang on 2/9/2017.
 * The most difficult part is for j from 0 to 9, when check column and cube, not go to the column or cube of [i][j],
 * instead, go to other column or cube
 */
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i<9; i++) {
      Set<Character> rows = new HashSet();
      Set<Character> cols = new HashSet();
      Set<Character> cubs = new HashSet();
      int rowOffset = 3*(i/3), colOffset = 3*(i%3);
      for (int j = 0; j<9; j++) {
        if (board[i][j]!='.' && !rows.add(board[i][j]))
          return false;
        if (board[j][i]!='.' && !cols.add(board[j][i]))
          return false;
        /**
         * / changes each 3 number, % changes each number and back to 0 after 3 numbers.
         */
        int x = rowOffset + j/3, y = colOffset + j%3;
        if (board[x][y]!='.' && !cubs.add(board[x][y]))
          return false;
      }
    }
    return true;
  }

  // Time: O(N*N), Space: O(N), N is the board.length
  public boolean isValidSudoku_ezUnderstand(char[][] board) {
    for (int i=0; i<9; i++) {
      if (hasDuplicated(board, i, i+1, 0, 9)||hasDuplicated(board, 0, 9, i, i+1)) {
        return false;
      }
    }
    // a 9*9 board can be divide 3*3 cube to check.
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        if (hasDuplicated(board, i*3, (i+1)*3, j*3, (j+1)*3)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * check whether this is duplicated value from in [rowStart, rowEnd)[columnStart, columnEnd)
   */
  private boolean hasDuplicated(char[][] b, int rowStart, int rowEnd, int columnStart, int columnEnd) {
    Set<Character> set = new HashSet<>();
    for (int i=rowStart; i<rowEnd; i++) {
      for (int j=columnStart; j<columnEnd; j++) {
        if (b[i][j]!='.' && set.contains(b[i][j])) {
          return true;
        }
        set.add(b[i][j]);
      }
    }
    return false;
  }
}
