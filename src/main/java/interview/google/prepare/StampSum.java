package interview.google.prepare;

/**
 * 阿三手头有三种面值分别为c1, c2和c3的邮票，数量分别为n1, n2和n3。要邮寄一个包裹，所需邮资为V(假定不超过阿三手头邮票面值总额）
 * 注意到阿三未必能凑出总面值恰好为的邮票，请问阿三应该如何给包裹贴上邮票，使得他超额的邮资最少？
 */
public class StampSum {

  public static int stampSum(int[] stamps, int[] count, int V) {
    int N = 0;
    for (int i=0; i<count.length; i++) N+=count[i];
    int[] A = new int[N];
    int idx = 0;
    for (int i=0; i<count.length; i++) {
      for (int j=0; j<count[i]; j++) {
        A[idx++] = stamps[i];
      }
    }
    boolean[] visited = new boolean[N];
    return dfs(A,0, V, 0, visited);
  }

  private static int dfs(int[] A, int sum, int V, int startIdx, boolean[] visited) {
    if (sum >= V) return sum-V;
    int min = Integer.MAX_VALUE;
    for (int i=startIdx; i<A.length; i++) {
      visited[i]=true;
      int diff = dfs(A, sum + A[i], V, i+1, visited);
      visited[i]=false;
      min = Math.min(min, diff);
      if (min == 0) return min;
    }
    return min;
  }

  public static void main(String... args) {
    int[] stamps = new int[]{6, 4, 5}, count = new int[]{8, 4, 3};
    for (int i=72; i<80; i++)
    System.out.println("sum is " + i + " " + stampSum(stamps, count, i));
  }
}
