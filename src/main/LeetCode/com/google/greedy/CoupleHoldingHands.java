package com.google.greedy;

public class CoupleHoldingHands {

  // Time: O(N)
  public static int minSwapsCouples(int[] row) {
    int N = row.length, res = 0;
    int[] pos = new int[N];
    for (int i = 0; i < N; i++) {
      pos[row[i]] = i;
    }
    for (int i = 0; i < N; i += 2) {
      int j = i + 1;
      // a number m and (m^1) is a pair
      while (row[j] != (row[i] ^ 1)) {
        // find row[j]'s pair position, swap row[j] to the next position of row[j]'s pair, so row[j] always the next-should-process number
        // until row[j] is row[i]'s pair, we finish a cycle
        int p = pos[row[j] ^ 1];
        swap(row, j, (p%2==0? p+1 : p-1));
        res++;
      }
    }
    return res;
  }

  private static void swap(int[] row, int i, int j) {
    int temp = row[i];
    row[i] = row[j];
    row[j] = temp;
  }

  public static void main(String... args) {
    // System.out.println(minSwapsCouples(new int[]{5, 4, 2, 6, 3, 1, 0, 7}));
    //System.out.println(minSwapsCouples(new int[]{0, 2, 4, 6, 7, 1, 3, 5}));
    String ip = "1.1.1.1";
    String s = ip.replaceAll("\\.", "[.]");
    System.out.println(s);
  }
}
