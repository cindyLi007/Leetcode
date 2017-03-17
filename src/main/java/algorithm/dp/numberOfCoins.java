package algorithm.dp;

/**
 * Created by ychang on 11/25/2016.
 */
public class numberOfCoins {
  public static void main(String[] args) {
    int result = minNumber(new int[]{1, 3, 5}, 11);
    System.out.println("The result is " + result);
  }

  public static int minNumber(int[] coins, int sum) {
    int[] sums = new int[sum + 1];
    // initial sums array
    sums[0] = 0;
    for (int i = 1; i < sums.length; i++) {
      sums[i] = Integer.MAX_VALUE;
    }

    for (int i = 1; i <= sum; i++) {
      for (int j = 0; j < coins.length && coins[j] <= i; j++) {
        sums[i] = Math.min(sums[i - coins[j]] + 1, sums[i]);
      }
    }

    return sums[sum];
  }
}
