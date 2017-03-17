package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 2/9/2017.
 */
public class ValidSudokuTest {

  @Test
  public void isValidSudoku() throws Exception {
    // Given
    char[][] board = new char[][]{"53..7....".toCharArray(), "6..195...".toCharArray(), ".98....6.".toCharArray(),
        "8...6...3".toCharArray(), "4..8.3..1".toCharArray(), "7...2...6".toCharArray(), ".6....28.".toCharArray(),
        "...419..5".toCharArray(), "....8..79".toCharArray()};
    ValidSudoku validSudoku = new ValidSudoku();

    // when
    boolean isValidSudoku = validSudoku.isValidSudoku(board);

    // Then
    assertThat(isValidSudoku, is(Boolean.TRUE));
  }

}