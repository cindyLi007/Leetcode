package com.google.dp;

import java.util.TreeSet;

public class MaxSumOfRectangle {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int M=matrix.length, N=matrix[0].length, res=0;
        for (int left=0; left<N; left++) {
            int[] sum = new int[M];
            for (int right=left; right<N; right++) {
                for (int row=0; row<M; row++) {
                    sum[row]+=matrix[row][right];
                }
                TreeSet<Integer> set = new TreeSet();
                set.add(0);
                int curSum=0;
                for (int n : sum) {
                    curSum+=n;
                    Integer i = set.ceiling(curSum-k);
                    if (i!=null) res=Math.max(res, curSum-i);
                    set.add(curSum);
                }
            }
        }
        return res;
    }

    public static void main(String... args) {
//        int[][] array = new int[][]{{2, 1, -3, -4, 5}, {0, 6, 3, 4, 1}, {2, -2, -1, 4, -5}, {-3, 3, 1, 0, 3}};
        int[][] array = new int[][]{{1, 0, 1}, {0, -2, 3}};
        System.out.println(maxSumSubmatrix(array, 2));
    }
}
