package com.google.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int N=A.length, M=B.length, i=0, j=0;
        List<int[]> res = new ArrayList();
        while (i<N && j<M) {
            int[] x = A[i], y = B[j];
            int start = Math.max(x[0], y[0]), end = Math.min(x[1], y[1]);
            if (start<=end) res.add(new int[]{start, end});
            if (end == x[1]) i++;
            if (end == y[1]) j++;
        }
        return res.stream().toArray(int[][]::new);
    }

    public static void main(String... args) {
        int[][] A = new int[][]{{0,2},{5,10},{13,23},{24,25}}, B = {{1,5},{8,12},{15,24},{25,26}};
        int[][] res = intervalIntersection(A, B);
        Arrays.stream(res).forEach(o-> System.out.println(o[0] + " " + o[1]));
    }
}
