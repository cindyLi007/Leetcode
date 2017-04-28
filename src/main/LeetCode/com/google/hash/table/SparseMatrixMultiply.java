package com.google.hash.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 4/24/2017.
 */
public class SparseMatrixMultiply {
  /**
   * this method will have overflow for big test data
   */
  public int[][] multiply_hashTable_overflow(int[][] A, int[][] B) {
    Map<Integer, Integer>[] mapA = (Map<Integer, Integer>[]) new HashMap[A.length];
    Map<Integer, Integer>[] mapB = (Map<Integer, Integer>[]) new HashMap[B[0].length];

    for (int i = 0; i<A.length; i++) {
      mapA[i] = new HashMap();
      for (int j = 0; j<A[0].length; j++) {
        if (A[i][j]!=0)
          mapA[i].put(j, A[i][j]);
      }
    }

    for (int i = 0; i<B[0].length; i++) {
      mapB[i] = new HashMap();
      for (int j = 0; j<B.length; j++) {
        if (B[j][i]!=0)
          mapB[i].put(j, B[j][i]);
      }
    }

    int[][] res = new int[A.length][B[0].length];
    for (int i = 0; i<res.length; i++) {
      for (int j = 0; j<res[0].length; j++) {
        res[i][j] = dotProduct(mapA[i], mapB[j], B.length);
      }
    }
    return res;
  }

  private int dotProduct(Map<Integer, Integer> a, Map<Integer, Integer> b, int size) {
    int res = 0;
    for (int i = 0; i<size; i++) {
      if (a.containsKey(i) && b.containsKey(i)) {
        res += a.get(i)*b.get(i);
      }
    }
    return res;
  }

  /**
   * this method can beat 99%
   */
  public int[][] multiply(int[][] A, int[][] B) {
    int rowA = A.length, rowB = B.length, colB = B[0].length; // colA==rowB
    /**
     * final result array should have rowA rows and colB columns
     */
    int[][] res = new int[rowA][colB];
    for (int i = 0; i<rowA; i++) {
      for (int j = 0; j<rowB; j++) {
        if (A[i][j]!=0) {
          for (int k = 0; k<colB; k++) {
            if (B[j][k]!=0)
              // A[i][j]*B[j][k] -> C[i][k] where j from 0 to colA(rowB)
              res[i][k] += A[i][j]*B[j][k];
          }
        }
      }
    }
    return res;
  }
}
