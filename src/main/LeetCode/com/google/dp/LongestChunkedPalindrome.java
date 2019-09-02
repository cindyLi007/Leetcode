package com.google.dp;

public class LongestChunkedPalindrome {
  public static int longestDecomposition(String text) {
    int N = text.length();
    for (int i=1; i<=N/2; i++) {
      String s1 = text.substring(0, i), s2 = text.substring(N-i, N);
      if (s1.equals(s2))
        return 2 + longestDecomposition(text.substring(i, N-i));
    }
    return N>0? 1 : 0;
  }

  public static void main(String... args) {
    String s1 = "ghiabcdefhelloadamhelloabcdefghi";
    System.out.println(longestDecomposition(s1));
    String s2 = "merchant";
    System.out.println(longestDecomposition(s2));
    String s3 = "antaprezatepzapreanta";
    System.out.println(longestDecomposition(s3));
    String s4 = "aaa";
    System.out.println(longestDecomposition(s4));
    String s5 = "elvtoelvto";
    System.out.println(longestDecomposition(s5));
  }
}
