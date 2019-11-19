package com.google.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ychang on 3/9/2017. Must consider all corner cases, such as 010, 101, 110
 */
public class DecodeWays {
  public int numDecodings(String s) {
    int N = s.length();
    if (N == 0 || s.charAt(0) == '0') return 0;
    if (N == 1) return 1;

    int[] dp = new int[N + 1];
    dp[0] = 1;
    dp[1] = 1; // dp[i] means # of decode ways for string end in i (s.substring(0, i))
    // dp[i+1] based on 1) dp[i] which s.charAt(i) must be a valid decode 2) dp[i-1] which s.substring(i-1, i+1) must be a valid decode
    for (int i = 2; i <= N; i++) {
      char c = s.charAt(i - 1);
      dp[i] = c == '0' ? 0 : dp[i - 1];
      char c1 = s.charAt(i - 1);
      if (c1 == '1' || c1 == '2' && c <= '6') dp[i] += dp[i - 2];
    }
    return dp[N];
  }

  // Time: O(N), Space: O(1)
  public int numDecodings_faster(String s) {
    int N = s.length();
    if (N == 0 || s.charAt(0) == '0') return 0;
    if (N == 1) return 1;

    /**
     * we only need 2 values, becasue for each dp[i], we only care dp[i-1] and dp[i-2]
     */
    int c0 = 1, c1 = 1;
    for (int i = 2; i <= s.length(); i++) {
      char ch = s.charAt(i - 1);
      int temp = ch == '0' ? 0 : c1;
      char ch1 = s.charAt(i - 2);
      if (ch1 == '1' || ch1 == '2' && ch <= '6') temp += c0;
      c0 = c1;
      c1 = temp;
    }
    return c1;
  }

  // Time: O(N*N)
  public static List<String> decodeWaysList(String s) {
    int N = s.length();
    if (N == 0 || s.charAt(0) == '0') return Collections.emptyList();
    List<String> dp1 = new ArrayList<>();
    List<String> dp2 = new ArrayList<>();
    dp1.add("");
    dp2.add(String.valueOf(s.charAt(0)));
    // Time: O(N * N)
    for (int i = 2; i <= N; i++) {
      char c = s.charAt(i - 1);
      char c1 = s.charAt(i - 2);
      List<String> newDp1 = new ArrayList<>();
      if (c1 == '1' || c1 == '2' && c <= '6') {
        for (String t : dp1) {
          newDp1.add(t + ", " + s.substring(i - 2, i));
        }
      }
      dp1 = dp2;
      if (c != '0') {
        for (String t : dp2) {
          newDp1.add(t + ", " + c);
        }
      }
      dp2 = newDp1;
    }
    return dp2;
  }

  public static void main(String... args) {
    List<String> res = decodeWaysList("226");
    res.stream().forEach(o -> System.out.println(o));
  }
}
