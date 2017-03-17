package com.google;

import java.util.Arrays;

/**
 * Created by ychang on 11/27/2016.
 */
public class BombEnemy {
  public static int maxKilledEnemies(char[][] grid) {
    // Write your code here
    int m = grid.length;
    int n = m > 0 ? grid[0].length : 0;

    int result = 0, rows = 0;
    int[] cols = new int[n];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (j == 0 || grid[i][j - 1] == 'W') {
          // rows represents # of E before next W and after prev W in this row
          rows = 0;
          for (int k = j; k < n && grid[i][k] != 'W'; ++k)
            if (grid[i][k] == 'E')
              rows += 1;
        }
        if (i == 0 || grid[i - 1][j] == 'W') {
          // cols[j] represents # of E before next W and after next prev W in this column
          cols[j] = 0;
          for (int k = i; k < m && grid[k][j] != 'W'; ++k)
            if (grid[k][j] == 'E')
              cols[j] += 1;
        }
        System.out.println("grid[" + i + "][" + j + "] is " + grid[i][j] + "--- cols[" + j + "] is " + cols[j] + "--- rows is " + rows);
        // Note that you can only put the bomb at an empty cell.
        if (grid[i][j] == '0' && rows + cols[j] > result)
          result = rows + cols[j];
      }
      System.out.println();
    }
    return result;
  }

  private static void printOutDP(int[][] dp) {
    System.out.println("--------- Now the dp is ---------");
    Arrays.stream(dp).forEach(charArray -> {
      for (int i=0; i<charArray.length; i++){
        System.out.print(charArray[i] + " ");
      }
      System.out.println();
    });
  }

  public static int maxKilledEnemies_2D_Dp(char[][] grid) {
    int rows = grid.length, cols = rows==0 ? 0 : grid[0].length;
    int[][] bombs = new int[rows][cols];
    int result=0;
    for (int j=0; j<cols; j++) {
      int temp = 0;
      for (int i=0; i<rows; i++) {
        temp = setBombsArray_i_j(grid[i][j], temp, bombs, i, j);
      }
      temp=0;
      for (int i=rows-1; i>=0; i--) {
        temp = setBombsArray_i_j(grid[i][j], temp, bombs, i, j);
      }
    }
    for (int i=0; i<rows; i++) {
      int temp = 0;
      for (int j=0; j<cols; j++) {
        temp = setBombsArray_i_j(grid[i][j], temp, bombs, i, j);
      }
      temp=0;
      for (int j=cols-1; j>=0; j--) {
        char c = grid[i][j];
        switch (c) {
          case 'E': temp++; break;
          case 'W': temp=0; break;
          default: bombs[i][j]+=temp;
            result = Math.max(bombs[i][j], result);
        }
      }
    }
    return result;
  }

  private static int setBombsArray_i_j(char c1, int temp, int[][] bombs, int i, int j) {
    char c = c1;
    switch (c) {
      case 'E': temp++; break;
      case 'W': temp=0; break;
      default: bombs[i][j]+=temp;
    }
    return temp;
  }

  public static void main(String[] args) {
    char[][] array = new char[][]{"0E00".toCharArray(),"E0WE".toCharArray(),"0E00".toCharArray()};
//    int result = maxKilledEnemies(array);
    int result = maxKilledEnemies_2D_Dp(array);
    System.out.println(result);
  }
}
