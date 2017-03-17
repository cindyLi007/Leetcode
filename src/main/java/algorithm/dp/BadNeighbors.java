package algorithm.dp;

/**
 * Created by ychang on 11/25/2016.
 */
public class BadNeighbors {

  public static void main(String[] args) {
    int result1 = maxDonations(new int[]{10, 3, 2, 5, 7, 8}); // 19
    int result2 = maxDonations(new int[]{11, 15}); //15
    int result3 = maxDonations(new int[]{7, 7, 7, 7, 7, 7, 7}); //21
    int result4 = maxDonations(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}); //16
    int result5 = maxDonations(new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
        6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
        52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72}); //2926
    System.out.println("result1 is " + result1);
    System.out.println("result2 is " + result2);
    System.out.println("result3 is " + result3);
    System.out.println("result4 is " + result4);
    System.out.println("result5 is " + result5);
  }

  public static int maxDonations(int[] donations) {
    int length = donations.length;
    int[] sums = new int[length];
    boolean[] iInclude = new boolean[length];
    boolean[] zeroInclude = new boolean[length];
    if (length < 3) {
      return Math.max(donations[0], donations[1]);
    }
    sums[0] = donations[0];
    iInclude[0]=zeroInclude[0]=true;
    sums[1] = donations[1];
    for (int i = 2; i < length; i++) {
      if (sums[i - 2] + donations[i] > sums[i - 1]) {
        sums[i] = sums[i - 2] + donations[i];
        iInclude[i] = true;
        zeroInclude[i] = zeroInclude[i - 2];
      } else {
        sums[i] = sums[i - 1];
        zeroInclude[i] = zeroInclude[i - 1];
      }
    }

    if (zeroInclude[length - 1] && iInclude[length - 1]) {
      return Math.max(Math.max(sums[length - 2], sums[length - 3]), sums[length-1] - donations[0]);
    } else {
      return sums[length - 1];
    }
  }
}
