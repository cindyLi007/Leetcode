package com.google.greedy;

/**
 Leetcode 955. Delete Columns to Make Sorted II
 */
public class MinDeleteSizeII {

  public static int minDeletionSize(String[] A) {
    int res = 0, N = A.length;
    if (N <= 1) return res;
    int L = A[0].length();
    boolean[] check = new boolean[N];
    for (int i=0; i<L; i++) {
      char c = A[0].charAt(i);
      for (int j=1; j<N; j++) {
        if (check[j]) {

        } else if (A[j].charAt(i)>c) {
          check[j]=true;
        } else if (A[j].charAt(i)<c) {
          res++;
          break;
        }
        c = A[j].charAt(i);
      }
    }
    return res;
  }

  public static void main(String... args) {
    System.out.println(minDeletionSize(new String[]{"doeeqiy", "yabhbqe", "twckqte"}));
  }
}
