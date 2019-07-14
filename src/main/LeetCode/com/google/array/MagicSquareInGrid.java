package com.google.array;

public class MagicSquareInGrid {

    public static int numMagicSquaresInside(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int res = 0;
        for (int i = 0; i <= M - 3; i++) {
            for (int j = 0; j <= N - 3; j++) {
                if (valid(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean valid(int[][] grid, int x, int y) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int sum_1 = 0;
            for (int j = 0; j < 3; j++) {
                sum_1 += grid[x + i][y + j];
            }
            if (sum == 0) sum = sum_1;
            else if (sum != sum_1) return false;
        }
        for (int i = 0; i < 3; i++) {
            int sum_1 = 0;
            for (int j = 0; j < 3; j++) {
                sum_1 += grid[x + j][y + i];
            }
            if (sum != sum_1) return false;
        }
        int i = x + 0, j = y + 0, sum_1 = 0;
        while (i < 3 && j < 3) {
            sum_1 += grid[i++][j++];
        }
        if (sum_1 != sum) return false;
        if (grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2] != sum) return false;
        return true;

    }

    public static void main(String... args) {
        int[][] grid = new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        int res = numMagicSquaresInside(grid);
        System.out.println(res);
    }
}
