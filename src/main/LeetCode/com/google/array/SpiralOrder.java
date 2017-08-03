package com.google.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/12/2017.
 */
public class SpiralOrder {
  public List<Integer> spiralOrder_recursive(int[][] matrix) {
    List<Integer> res = new LinkedList();
    if (matrix==null || matrix.length==0 || matrix[0].length==0) return res;
    int m=matrix.length, n=matrix[0].length;
    spiral(matrix, 0, m-1, 0, n-1, res);
    /**
     * use subList to avoid duplicated elements, since all duplicated elements can only happened in the end of the list,
     * we can safely truncate till m*n (exclusive as subList)
    */
    return res.subList(0, m*n);
  }

  private void spiral(int[][] matrix, int s1, int e1, int s2, int e2, List<Integer> list) {
    if (e1<s1 || e2<s2) return;
    for (int i=s2; i<=e2; i++) {
      list.add(matrix[s1][i]);
    }
    for (int i=s1+1; i<e1; i++) {
      list.add(matrix[i][e2]);
    }
    for (int i=e2; i>=s2; i--) {
      list.add(matrix[e1][i]);
    }
    for (int i=e1-1; i>s1; i--) {
      list.add(matrix[i][s2]);
    }
    spiral(matrix, s1+1, e1-1, s2+1, e2-1, list);
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new LinkedList();
    if (matrix==null || matrix.length==0 || matrix[0].length==0) return res;
    int s1=0, e1=matrix.length-1, s2=0, e2=matrix[0].length-1;

    // we need make sure anytime s1<=e1, s2<=e2, even in the while loop to avoid duplicated elements
    while (s1<=e1 && s2<=e2) {
      for (int i=s2; i<=e2; i++) {
        res.add(matrix[s1][i]);
      }
      s1++;
      for (int i=s1; i<=e1; i++) {
        res.add(matrix[i][e2]);
      }
      e2--;

      // when go left or up, maybe can introduce duplicated elements, so first row_begin still <= row_end
      if (s1<=e1) {
        for (int i=e2; i>=s2; i--) {
          res.add(matrix[e1][i]);
        }
        e1--;
      }
      if (s2<=e2) {
        for (int i=e1; i>=s1; i--) {
          res.add(matrix[i][s2]);
        }
        s2++;
      }
    }
    return res;
  }
}
