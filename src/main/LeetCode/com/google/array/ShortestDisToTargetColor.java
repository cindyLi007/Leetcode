package com.google.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDisToTargetColor {

  public static void main(String... args) {
    List<Integer> res = shortestDistanceColor(new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3}, new int[][]{{1, 3}, {2, 2}, {6, 1}});
    res.stream().forEach(o-> System.out.print(o + " ")); // 3, 0, 3
    System.out.println();
    res = shortestDistanceColor(new int[]{1, 2}, new int[][]{{0, 3}});
    res.stream().forEach(o-> System.out.print(o + " ")); // -1
    System.out.println();
    res = shortestDistanceColor(new int[]{2, 1, 2, 2, 1}, new int[][]{{4, 2}}); // 1
    res.stream().forEach(o-> System.out.print(o + " ")); // 1
    System.out.println();
  }

  public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
    int N = colors.length;
    int[][] dp = new int[N][4];
    for (int[] row : dp) Arrays.fill(row, N+10);
    for (int i=0; i<N; i++) {
      dp[i][colors[i]]=0;
      for (int j=1; j<=3; j++) {
        if (i>0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
      }
    }
    for (int i=N-1; i>=0; i--) {
      dp[i][colors[i]] = 0;
      for (int j=1; j<=3; j++) {
        if (i<N-1) dp[i][j] = Math.min(dp[i][j], dp[i+1][j]+1);
      }
    }

    List<Integer> list = new ArrayList();
    for (int[] query : queries) {
      int v = dp[query[0]][query[1]];
      list.add(v<N ? v : -1);
    }
    return list;
  }
}
