package com.google.array;

public class SpiralOrderII {
    public int[][] generateMatrix(int n) {
        int r0 = 0, r1 = n - 1, c0 = 0, c1 = n - 1;
        int num = 1;
        int[][] res = new int[n][n];
        while (r0 < r1 && c0 < c1) {
            for (int i = c0; i < c1; i++) res[r0][i] = num++;
            for (int i = r0; i < r1; i++) res[i][c1] = num++;
            for (int i = c1; i > c0; i--) res[r1][i] = num++;
            for (int i = r1; i > r0; i--) res[i][c0] = num++;
            r0++;
            r1--;
            c0++;
            c1--;
        }
        if (r0 == r1) {
            res[r0][c0] = num;
        }
        return res;
    }

    public static void main(String... args) {
        SpiralOrderII spiralOrderII = new SpiralOrderII();

        int[][] ints = spiralOrderII.generateMatrix(3);


    }
}
