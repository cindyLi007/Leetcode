package interview.google.prepare;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给了一个数学公式 如果 input n 是偶数就除以二， 奇数就乘三加一， 给了假设任意 input如果一直循环 call 这个function， 一定会到1
 part a: 写下给随意input， 要多少个steps才能到1 （就很简单。。）
 part b: 给一个大的 N， 返回1 到 N 之间用最多steps 的数
 */
public class CollatzStep {

  public static int collatzStep_1(int N) {
    int res = 0;
    while (N>1) {
      if (N%2==1) {
        N = N*3 + 1;
      } else {
        N/=2;
      }
      res++;
    }
    return res;
  }

  public static int collatzStep_2(int N) {
    Map<Integer, Integer> dp = new HashMap<>();
    int res = 0;
    dp.put(1, 0);
    for (int i=2; i<=N; i++) {
      res = Math.max(res, f(dp, i));
    }
    return res;
  }

  private static int f(Map<Integer, Integer> dp, int N) {
    if (dp.containsKey(N)) {
      return dp.get(N);
    }
    int res = N%2==1 ? f(dp, N*3 +1) : f(dp, N/2);
    dp.put(N, res+1);

    return dp.get(N);
  }

  public static void main(String... args) {
    System.out.println(collatzStep_2(11));
  }
}
