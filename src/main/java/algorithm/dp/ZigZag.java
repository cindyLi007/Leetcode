package algorithm.dp;

/**
 * Created by ychang on 11/25/2016.
 */
public class ZigZag {
  public static void main(String[] args) {
    int result1 = longestZigZag(new int[]{1, 7, 4, 9, 2, 5});
    int result2 = longestZigZag(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
    int result3 = longestZigZag(new int[]{44});
    int result4 = longestZigZag(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    int result5 = longestZigZag(new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32});
    int result6= longestZigZag(new int[]{374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
        600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
        67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
        477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
        249, 22, 176, 279, 23, 22, 617, 462, 459, 244});
    System.out.println("result1 is " + result1); //should be 6
    System.out.println("result2 is " + result2); //should be 7
    System.out.println("result3 is " + result3); //should be 1
    System.out.println("result4 is " + result4); //should be 2
    System.out.println("result5 is " + result5); //should be 8
    System.out.println("result6 is " + result6); //should be 36
  }

  public static int longestZigZag(int[] arrays) {
    int[][] result = new int[arrays.length][2];
    int max = arrays.length > 0 ? 1 : 0;
    /*
      result[i][0] represents length of longest ZigZag subsequence ending at i and array[i] > previous element
      result[i][1] represents length of longest ZigZag subsequence ending at i and array[i] < previous element
     */
    for (int i = 0; i < result.length; i++) {
      result[i][0]=result[i][1]=1;
    }
    for (int i=1; i<arrays.length; i++) {
      for (int j=0; j<i; j++) {
        if (arrays[j] < arrays[i]) {
          result[i][0] = Math.max(result[i][0], result[j][1] + 1);
        } else if (arrays[j] > arrays[i]) {
          result[i][1] = Math.max(result[i][1], result[j][0] + 1);
        }
        max = Math.max(max, Math.max(result[i][0], result[i][1]));
      }
    }
    return max;
  }
}
