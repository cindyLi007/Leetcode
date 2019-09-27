package com.google.greedy;

public class CoupleHoldingHands {

  public static int minSwapsCouples(int[] row) {
    int N = row.length/2;
    int res = 0;
    for (int i=0; i<N; i++) {
      int x = row[i*2], y = row[i*2+1];
      if ((x^y)!=1)
        res++;
    }
    return (res+1)/2;
  }

  public static void main(String... args) {
    System.out.println(minSwapsCouples(new int[]{5, 4, 2, 6, 3, 1, 0, 7}));
  }
}
