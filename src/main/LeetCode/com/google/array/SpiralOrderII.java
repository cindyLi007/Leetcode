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

    public int[][] generateMatrix_1(int n) {
        int num = 1;
        int[][] res = new int[n][n];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0;

        while (num<=n*n) {
            res[x][y] = num++;
            int nextX = x+dirs[d][0];
            int nextY = y+dirs[d][1];
            if (nextX<0 || nextX==n || nextY<0 || nextY==n || res[nextX][nextY] != 0) {
                d = (d+1) % 4;
                nextX = x+dirs[d][0];
                nextY = y+dirs[d][1];
            }
            x = nextX;
            y = nextY;
        }

        return res;
    }

    public static void main(String... args) {
        SpiralOrderII spiralOrderII = new SpiralOrderII();

        int[][] ints = spiralOrderII.generateMatrix_1(3);


    }
}
