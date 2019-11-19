package interview.google.prepare;

import java.util.BitSet;

/**
 * Given a binary 2D grid (each element can either be a 1 or a 0). You have the ability to choose any element and flip
 * its value. The only condition is that when you choose to flip any element at index (r, c), the 4 neighbors of that
 * element also get flipped. Find the minimum number of flips that you need to do in order to set all the elements in
 * the matrix equal to 0. If it's not possible, return -1.
 */
/*
  我开始的想法是不对的 没有考虑到一个点可以被它周围的点带着flip multiple times. for ex. [[1,1,1],[1,1,1],[1,1,1]], it can be flipped
  to all 0, 而只想到一个点被它周围的点flip once. so this question should be done by backtracking. for each point, we can do
  a. no flip; b. flip; and based on previous status, (before either action, we can store the dp[pos][status] if dp > 0 means
  from this pos in this status, we finally can make all 0s, if dp < 0 means no way. 这道题和campus bike II 很像
 */
public class MinFlipsToSetAllZeros {
  static int M, N, L, res;

  public static int minFlip(int[][] board) {
    M = board.length;
    N = board[0].length;
    L = M * N;
    res = Integer.MAX_VALUE;
    helper(convert(board), 0, 0);
    return res;
  }

  private static BitSet convert(int[][] board) {
    BitSet bs = new BitSet(L);
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 1) bs.set(i * N + j);
      }
    }
    return bs;
  }

  private static void helper(BitSet status, int pos, int flips) {
    if (pos == L) {
      if (status.cardinality() == 0) res = Math.min(res, flips);
      return;
    }
    // for pos, we can flip or not flip
    helper(status, pos + 1, flips); // no flip

    // flip
    flip(pos / N, pos % N, status);
    helper(status, pos + 1, flips + 1);
    flip(pos / N, pos % N, status);
  }

  private static void flip(int i, int j, BitSet status) {
    status.flip(i * N + j);
    if (i - 1 >= 0) status.flip((i - 1) * N + j);
    if (i + 1 < M) status.flip((i + 1) * N + j);
    if (j + 1 < N) status.flip(i * N + j + 1);
    if (j - 1 >= 0) status.flip(i * N + j - 1);
  }

  public static void main(String... args) {
    int[][] board;
    board = new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
    System.out.println(MinFlipsToSetAllZeros.minFlip(board)); // should return 7
    board = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    System.out.println(MinFlipsToSetAllZeros.minFlip(board)); // should return 0
    board = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    System.out.println(MinFlipsToSetAllZeros.minFlip(board)); // should return 5
    board = new int[][]{{0, 1, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 0}};
    System.out.println(MinFlipsToSetAllZeros.minFlip(board)); // should return 2
    board = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    System.out.println(MinFlipsToSetAllZeros.minFlip(board)); // should return 0
    board = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
    System.out.println(MinFlipsToSetAllZeros.minFlip(board)); // should return 1
    board = new int[][]{{0, 0, 0, 0, 0, 1, 1, 1},
        {0, 1, 0, 0, 1, 0, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 0, 1, 0, 0, 1}};
    System.out.println(MinFlipsToSetAllZeros.minFlip(board)); // should return 4
    board = new int[][]{{0, 0, 0, 0, 0, 0, 1, 1},
        {0, 1, 0, 0, 0, 0, 1, 1},
        {1, 1, 1, 0, 0, 1, 1, 1},
        {0, 1, 0, 0, 0, 0, 1, 0}};
    System.out.println(MinFlipsToSetAllZeros.minFlip(board)); // should return 3
  }
}
