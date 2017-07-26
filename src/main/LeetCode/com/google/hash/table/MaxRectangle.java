package com.google.hash.table;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ychang on 2/15/2017.
 */
public class MaxRectangle {
  /**
   * this can beat 54%
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
    int[] height = new int[matrix[0].length];
    int res=0;
    for (char[] row : matrix) {
      for (int i=0; i<row.length; i++) {
        if (row[i]=='0') height[i]=0;
        else {
          height[i]++;
        }
      }
      res=Math.max(res, largest(height));
    }
    return res;
  }

  private int largest(int[] height) {
    int res=0, i=0;
    int[] h = Arrays.copyOf(height, height.length+1);
    Stack<Integer> stack = new Stack();
    while (i<h.length) {
      if (stack.isEmpty() || h[i]>=h[stack.peek()]) stack.push(i++);
      else {
        int j=stack.pop();
        res=Math.max(res, h[j]*(stack.isEmpty() ? i : i-stack.peek()-1));
      }
    }
    return res;
  }

  /**
   * this can beat 98%
   * height counts the number of successive '1's above (plus the current one). The value of left & right means the
   * boundaries of the rectangle which contains the current point with a height of value height
   */
  public int maximalRectangle_dp(char[][] matrix) {
    if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
    int m=matrix.length, n=matrix[0].length, res=0;
    int[] h=new int[n], left=new int[n], right=new int[n];
    /**
     * notice must first fill right to value n
     */
    Arrays.fill(right, n);
    for (int i=0; i<m; i++) {
      // curLeft and curRight is to record for current row the left and right bound
      int curLeft=0, curRight=n;
      for (int j=0; j<n; j++) {
        int v=matrix[i][j];
        if (v=='0') {
          h[j]=0;
          left[j]=0; // when v=='0', set left[j]=0 mean we only consider curLeft in next row
          curLeft=j+1;
        } else {
          h[j]++;
          left[j]=Math.max(left[j], curLeft);
        }
      }
      for (int j=n-1; j>=0; j--) {
        if (matrix[i][j]=='0') {
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
