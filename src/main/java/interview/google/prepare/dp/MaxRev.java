package interview.google.prepare.dp;

/**
 * 给两个数组Rev1 Rev2，表示在Rev1, Rev2 表示在i天能获得的价值 只能二选一， 可以任意从Rev1和Rev2开始，但是如果前一天在1，
 * 第二天到了2就会有一些travel cost 然后这个cost一开始是常数. 问总共N天能拿到的最大价值，
 */
public class MaxRev {

  // Time: O(N), Space: O(N)
  public static int maxRev(int[] rev0, int[] rev1, int cost) {
    int N = rev1.length;
    int[][] dp = new int[N][2];
    dp[0][0] = rev0[0];
    dp[0][1] = rev1[0];

    for (int i = 1; i < N; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - cost) + rev0[i];
      dp[i][1] = Math.max(dp[i - 1][0] - cost, dp[i - 1][1]) + rev1[i];
    }

    return Math.max(dp[N-1][0], dp[N-1][1]);
  }

  // Time: O(N), Space: O(1)
  public static int maxRev_saveSpace(int[] rev0, int[] rev1, int cost) {
    int N = rev1.length;
    int[] dp = new int[2];
    dp[0] = rev0[0];
    dp[1] = rev1[0];
    int[] path = new int[N];
    path[0] = dp[0]>dp[1] ? 0 : 1;

    for (int i = 1; i < N; i++) {
      int temp = dp[0];
      dp[0] = Math.max(dp[0], dp[1] - cost) + rev0[i];
      dp[1] = Math.max(temp - cost, dp[1]) + rev1[i];
      path[i] = dp[0]>dp[1] ? 0 : 1;
    }

    for (int i=0; i<N; i++) {
      int v = path[i] == 0 ? rev0[i] : rev1[i];
      System.out.print(path[i] +  " value is " + v + " to -> ");
    }
    return Math.max(dp[0], dp[1]);
  }

  public static void main(String... args) {
    int[] rev0 = new int[]{5, 6, 4, 12, 10, 1};
    int[] rev1 = new int[]{8, 2, 9, 3, 7, 6};
    int res = maxRev_saveSpace(rev0, rev1, 2);
    System.out.println(res);
  }
}
