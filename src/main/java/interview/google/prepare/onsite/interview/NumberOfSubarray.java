package interview.google.prepare.onsite.interview;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarray {

  public int numberOfSubArray(int[] A) {
    int N = A.length, res = 0;
    Map<Integer, Integer> dp = new HashMap<>();
    for (int i = 0; i < N; ) {
      while (i < N && A[i] == 1) i++;
      if (i == N) break;
      int count = 0;
      while (i < N && A[i] == 0) {
        i++;
        count++;
      }
      res += subarray(count, dp);
    }
    return res;
  }

  private int subarray(int count, Map<Integer, Integer> dp) {
    if (dp.containsKey(count)) return dp.get(count);
    int res=0;
    for (int i = 1; i <= count; i++) {
      res += i;
    }
    dp.put(count, res);
    return res;
  }

  public static void main(String... args) {
    NumberOfSubarray numberOfSubarray = new NumberOfSubarray();
    int res = numberOfSubarray.numberOfSubArray(new int[]{0, 0, 0, 1, 1, 0, 0, 0, 0});
    System.out.println(res);
  }
}
