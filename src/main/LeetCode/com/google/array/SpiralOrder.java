package com.google.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/12/2017.
 */
public class SpiralOrder {
    public List<Integer> spiralOrder_recursive(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        spiral(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, res);
        return res;
    }

    private void spiral(int[][] A, int r0, int r1, int c0, int c1, List<Integer> res) {
        // base case
        if (r0 > r1 || c0 > c1) return;
        // base case when there is single row/column need add to res
        if (r0 == r1 || c0 == c1) {
            if (r0 == r1) {
                for (int i = c0; i <= c1; i++) res.add(A[r0][i]);
            } else {
                for (int i = r0; i <= r1; i++) res.add(A[i][c0]);
            }
            return;
        }
        // r0<r1 && c0<c1
        for (int i = c0; i < c1; i++) res.add(A[r0][i]);
        for (int i = r0; i < r1; i++) res.add(A[i][c1]);
        for (int i = c1; i > c0; i--) res.add(A[r1][i]);
        for (int i = r1; i > r0; i--) res.add(A[i][c0]);
        spiral(A, r0 + 1, r1 - 1, c0 + 1, c1 - 1, res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int M=matrix.length-1, N = M<0 ? 0 : matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        int r0=0, r1=M, c0=0, c1=N;
        while (r0<r1 && c0<c1) {
            for (int i=c0; i<c1; i++) res.add(matrix[r0][i]);
            for (int i=r0; i<r1; i++) res.add(matrix[i][c1]);
            for (int i=c1; i>c0; i--) res.add(matrix[r1][i]);
            for (int i=r1; i>r0; i--) res.add(matrix[i][c0]);
            r0++; r1--; c0++; c1--;
        }
        if (r0>r1 || c0>c1) return res;

        if (r0==r1) {
            for (int i=c0; i<=c1; i++) res.add(matrix[r0][i]);
        } else {
            for (int i=r0; i<=r1; i++) res.add(matrix[i][c0]);
        }

        return res;
    }
}
