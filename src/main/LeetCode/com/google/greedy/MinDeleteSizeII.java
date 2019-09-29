package com.google.greedy;

/**
 Leetcode 955. Delete Columns to Make Sorted II
 */
public class MinDeleteSizeII {

  // Time: O(M*L)
  public static int minDeletionSize(String[] A) {
    int res=0, N=A.length;
    if (N<=1) return res;
    int L=A[0].length();
    boolean[] check = new boolean[N];
    for (int i=0; i<L; i++) {
      int j=0;
      // we could not change check[j] in this loop, because we do not know whether there is any following char break the
      // rule, we can only do it when we are done for checking all chars in this column
      for (; j<N-1; j++) {
        // if check[j] is true, that means we already know A[j] less than A[j+1] from previous chars
        if (!check[j] && A[j].charAt(i) > A[j+1].charAt(i)) {
          res++;
          break;
        }
      }
      if (j<N-1) continue;
      else if (i<L-1) {
        // if all strings has check[j] is true, all of them is less than it's next string, so we can early terminate
        boolean all = false;
        for (j=0; j<N-1; j++) {
          check[j] |= A[j].charAt(i) < A[j+1].charAt(i);
          all &= check[j];
        }
        if (all) break;
      }
    }
    return res;
  }

  public static void main(String... args) {
    System.out.println(minDeletionSize(new String[]{"doeeqiy", "yabhbqe", "twckqte"}));
  }
}
