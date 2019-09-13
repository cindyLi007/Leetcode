package com.google.array;

import java.util.ArrayList;
import java.util.List;

/** Leetcode 969. Pancake Sorting
 * each time find the max in the remaining array, flip it to the 1st one, then flip from the 1st to the remaining array
 * Time: O(N^2), Space: O(1)
 */
public class PancakeSort {
  public List<Integer> pancakeSort(int[] A) {
    int N=A.length, curMax = N;
    List<Integer> res = new ArrayList();
    for (int i=N-1; i>=0; i--) {
      for (int j=i; j>=0; j--) {
        if (A[j]==curMax) {
          if (j!=0) {
            reverse(A, 0, j);
            res.add(j);
          }
          reverse(A, 0, i);
          if (i>0) res.add(i);
          curMax--;
          break;
        }
      }
    }
    return res;
  }

  private void reverse(int[] A, int i, int j) {
    while (i<j) {
      int temp = A[i];
      A[i++]=A[j];
      A[j--]=temp;
    }
  }

  public static void main(String... args) {
    PancakeSort pancakeSort = new PancakeSort();
    pancakeSort.pancakeSort(new int[]{3, 2, 4, 1});
  }
}
