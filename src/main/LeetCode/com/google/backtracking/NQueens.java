package com.google.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by grchan on 7/24/2018
 */
public class NQueens {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    List<Integer> board = new ArrayList<>();
    place(res, board, n, 0);
    return res;
  }

  private void place(List<List<String>> res, List<Integer> board, int n, int row) {
    if (row==n) {
      List<String> list = new ArrayList<>();
      for (Integer i : board) {
        char[] ch = new char[n];
        Arrays.fill(ch, '.');
        ch[i]='Q';
        list.add(String.valueOf(ch));
      }
      res.add(list);
    } else {
      for (int i=0; i<n; i++) {
        board.add(i);
        if (isValid(board, row, i)) {
          place(res, board, n, row+1);
        }
        board.remove(board.size()-1);
      }
    }
  }

  private boolean isValid(List<Integer> board, int row, int column) {
    for (int r=0; r<row; r++) {
      int c = board.get(r);
      if (c==column || row-r == Math.abs(column-c)) {
        return false;
      }
    }
    return true;
  }
}
