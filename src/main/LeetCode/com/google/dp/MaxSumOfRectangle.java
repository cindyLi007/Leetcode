package com.google.dp;

import java.util.TreeSet;

// Leetcode 363
public class MaxSumOfRectangle {
  // Time: O(C*C*R + C*C*R*lgR)
  public static int maxSumSubmatrix(int[][] matrix, int k) {
    int R = matrix.length, C = matrix[0].length, res = Integer.MIN_VALUE;
    // for each start left col, find all rect from left to N, we record rect sum in array sum
    for (int left = 0; left < C; left++) {
      // compute sum of rect [(left, right), (0, row)];
      int[] sum = new int[R];

      for (int right = left; right < C; right++) {
        int prev = 0;
        for (int r = 0; r < R; r++) {
          int temp = sum[r];
          // prev is duplicated part of sum[r-1] and prev sum[r]
          sum[r] += (r == 0 ? 0 : sum[r - 1]) - prev + matrix[r][right];
          prev = temp;
          // if we want restrain to square, we can add following code
          int L = right - left + 1;
          if (r >= L - 1) {
            int prevSum = r == L - 1 ? 0 : sum[r - L];
            if (sum[r] - prevSum <= k) res = Math.max(res, sum[r] - prevSum);
          }
        }
        // after this loop we have an array sum which has all sum [W:(left, right), H:(0, r)]

        TreeSet<Integer> set = new TreeSet();
        set.add(0);
        for (int s : sum) {
          // we need sum-i<=k, so we need find a i which sum-k<=i
          Integer i = set.ceiling(s - k);
          if (i != null) res = Math.max(res, s - i);
          set.add(s);
        }
      }
    }
    return res;
  }

  public static void main(String... args) {
    int[][] array = new int[][]{{2, 1, -3, -4, 5}, {0, 6, 3, 4, 1}, {2, -2, -1, 4, -5}, {-3, 3, 1, 0, 3}};
    print(array);
    print(prefixSum(array));
    array = new int[][]{{1, 0, 1}, {0, -2, 3}};
    System.out.println(maxSumSubmatrix(array, 2));
  }

  private static int[][] prefixSum(int[][] array) {
    int R = array.length, C = array[0].length;
    // first init R==0 and C==0 's sum array
    int[][] sum = new int[R][C];
    sum[0][0] = array[0][0];
    for (int i = 1; i < C; i++) sum[0][i] += sum[0][i - 1] + array[0][i];
    for (int i = 1; i < R; i++) sum[i][0] += sum[i - 1][0] + array[i][0];
    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        sum[i][j] = array[i][j] - sum[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1];
      }
    }
    return sum;
  }

  private static void print(int[][] sum) {
    for (int[] row : sum) {
      for (int i : row) {
        System.out.printf("%3d", i);
      }
      System.out.println();
    }
    System.out.println("**************************");
  }

}
