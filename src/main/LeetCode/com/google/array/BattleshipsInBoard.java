package com.google.array;

/**
 * Created by ychang on 3/10/2017.
 * Given an 2D board, count_bruteForce how many battleships are in it. The battleships are represented with 'X's, empty slots are
 * represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN
 * (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.

 * Going over all cells, we can count_bruteForce only those that are the "first" cell of the battleship. First cell will be defined
 * as the most top-left cell. We can check for first cells by only counting cells that do not have an 'X' to the left
 * and do not have an 'X' above them.
 */
public class BattleshipsInBoard {
  public int countBattleships(char[][] board) {
    if (board==null || board.length==0 || board[0].length==0) return 0;
    int res=0, m=board.length, n=board[0].length;
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (board[i][j]=='X') { //if this X is not below or right of any 'X', we count_bruteForce it
          if (i>0 && board[i-1][j]=='X') continue;
          if (j>0 && board[i][j-1]=='X') continue;
          res++;
        }
      }
    }
    return res;
  }
}
