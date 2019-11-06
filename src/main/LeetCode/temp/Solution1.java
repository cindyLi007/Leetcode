package temp;

/**
 * Created by ychang on 10/3/2017.
 */
class Solution1 {
  public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int N = nums.length, max = 0;
    // left[i] is the starting index for the left interval in range [0, i];
    // right[i] is the starting index for the right interval in range [i, n-1];
    // k<=i<=n-2k mid interval is [i, i+k-1]
    int[] sum = new int[N+1], left = new int[N], right = new int[N];

    // for quick get an interval sum, first calculate all sum of range [0, i], 0<=i<N
    for (int i=1; i<=N; i++) {
      sum[i] = sum[i-1]+nums[i-1];
    }

    // find left maxSum idx, from [0, len-2k]
    for (int i=k, curSum=sum[k]; i<N; i++) {
      if (curSum < sum[i+1]-sum[i+1-k]) {
        left[i]=i+1-k;
        curSum = sum[i+1]-sum[i+1-k];
      }
      else left[i]=left[i-1];
    }

    // find right maxSum idx, from [len-1, 0+2k]
    right[N-k]=N-k;
    for (int i=N-k-1, curSum=sum[N]-sum[N-k]; i>=0; i--) {
      if (curSum <= sum[i+k]-sum[i]) {
        right[i]=i;
        curSum = sum[i+k]-sum[i];
      }
      else right[i]=right[i+1];
    }

    // find mid maxSum idx, from [k, len-k]
    int[] res = new int[3];
    for (int i=k; i<=N-2*k; i++) {
      int l=left[i-1], r = right[i+k];
      int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
      if (tot > max) {
        max = tot;
        res[0]=l; res[2]=r; res[1]=i;
      }
    }
    return res;
  }

  public static void main(String... args) {
    /*int[] array = {1, 2, 1, 2, 6, 7, 5, 1};
    int[] res = maxSumOfThreeSubarrays(array, 2);
    // how to sort an existing map
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList arrayList = new ArrayList(map.keySet());
    Collections.sort(arrayList);*/

    // System.out.println(f(5));
    System.out.println(maxTime("?4:5?")); // should be "14:59"
    System.out.println(maxTime("23:5?")); // should be "23;59"
    System.out.println(maxTime("2?:22")); // should be "23:22"
    System.out.println(maxTime("0?:??")); // should be "09:59"
    System.out.println(maxTime("??:??")); // should be "23:59"
  }

  /**
   * Given a positive integer n, find out how many ways of writing n as a sum of positive integers. Two sums that differ
   * only in the order of their summands are considered the same partition.
   * Time: O(N*N)
   */
  public static int f(int n) {
    int[][] dp = new int[n][n + 1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = dp[i-1][j] + (j-i>=0 ? dp[i][j-i] : 0); // without i + with i
      }
    }
    return dp[n - 1][n];
  }

  /**
   * You are given a string that represents time in the format hh:mm. Some of the digits are blank (represented by ?).
   * Fill in ? such that the time represented by this string is the maximum possible.
   * Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.
   *
   * Input: "?4:5?" Output: "14:59"
   * Input: "23:5?" Output: "23:59"
   * Input: "2?:22" Output: "23:22"
   * Input: "0?:??" Output: "09:59"
   * Input: "??:??" Output: "23:59"
   */
  public static String maxTime(String time) {
    char[] ch = time.toCharArray();
    if (ch[0]=='?') {
      if (ch[1]<='3' || ch[1]=='?') ch[0] = '2';
      else ch[0] = '1';
    }
    if (ch[1]=='?') {
      ch[1] = ch[0]=='2' ? '3' : '9';
    }
    if (ch[3]=='?') ch[3] = '5';
    if (ch[4]=='?') ch[4] = '9';
    return String.valueOf(ch);
  }


}
