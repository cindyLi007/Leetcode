package com.google.string;

public class SwapAdjacentLRString {

  public static boolean canTransform(String start, String end) {
    char[] ch1 = start.toCharArray(), ch2 = end.toCharArray();
    int N = ch1.length;
    if (N != ch2.length) return false;
    int i = 0, j = 0;
    while (i < N && j < N) {
      while (i < N && ch1[i] == 'X') i++;
      while (j < N && ch2[j] == 'X') j++;
      if (i == N || j == N) break;
      if (ch1[i] != ch2[j]|| (ch1[i] == 'R' && i > j) || (ch1[i] == 'L' && i < j))
        return false;
      i++;
      j++;
    }
    while (i < N) {
      if (ch1[i++] != 'X') return false;
    }
    while (j < N) {
      if (ch2[j++] != 'X') return false;
    }
    return true;
  }

  // RXXLRXRXL", end = "XRLXXRRLX"
  public static void main(String... args) {
    System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLL"));
  }
}
