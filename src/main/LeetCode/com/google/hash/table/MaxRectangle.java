package com.google.hash.table;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ychang on 2/15/2017. Leetcode 85. Maximal Rectangle
 */
public class MaxRectangle {
  /**
   * M * N
   */
  public int maximalRectangle(char[][] matrix) {
    int M = matrix.length, N = M==0 ? 0 : matrix[0].length;
    if (M==0 || N==0) return 0;
    int max = 0, height[]=new int[N+1];
    for (int i=0; i<M; i++) {
      Stack<Integer> stack = new Stack<>();
      for (int j=0; j<N; j++) {
        if (matrix[i][j]=='0') {
          height[j]=0;
        } else {
          height[j]++;
        }
      }
      stack.push(0);
      for (int j=1; j<=N; j++) {
        while (!stack.isEmpty() && height[j] < height[stack.peek()]) {
          int h = height[stack.pop()];
          int w = stack.isEmpty() ? j : j-stack.peek()-1;
          max = Math.max(max, h * w);
        }
        stack.push(j);
      }
    }
    return max;
  }

  /**
   * this can beat 98%
   * height counts the number of successive '1's above (plus the current one). The value of left & right means the
   * boundaries of the rectangle which contains the current point with a height of value height
   */
  public int maximalRectangle_dp(char[][] matrix) {
    if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
    int n=matrix[0].length, res=0;
    int[] h=new int[n], left=new int[n], right=new int[n];
    /**
     * notice must first fill right to value n
     */
    Arrays.fill(right, n);
    for (char[] row : matrix) {
      // curLeft and curRight is to record for current row the left and right bound
      int curLeft=0, curRight=n;
      for (int j=0; j<n; j++) {
        if (row[j]=='0') {
          h[j]=0;
          left[j]=0; // when row[j]=='0', set left[j]=0 means we reset it's value, only consider curLeft in next column
          curLeft=j+1;
        } else {
          h[j]++;
          // left[j] comes from the above row, if left[j] > curLeft, that means in the above rows, there must be some break point
          // in left[j]-1 which make cur column bar is higher than the left column bar
          left[j]=Math.max(left[j], curLeft);
        }
      }
      for (int j=n-1; j>=0; j--) {
        if (row[j]=='0') {
          right[j]=n;
          curRight=j;
        } else {
          right[j]=Math.min(right[j], curRight);
          res=Math.max(res, h[j]*(right[j]-left[j]));
        }
      }
    }
    return res;
  }
}