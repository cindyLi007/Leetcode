package interview.facebook.onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an int array[] in which each item is an array, and an target int, we need find a pair item which the corresponding
 * items in them 's sum is target int.
 * For ex. Array [[1, 2], [2, 3], [3, 2]], target is 4. should return [[1, 2], [3, 2]] because A[0] + B[0] (1+3) == 4,
 * A[1] + B[1] (2+2) == 4
 */
public class PairArray {

  // Time: O(N), Space: O(N)
  public static List<int[]> findPair(int[][] A, int K) {
    Map<Integer, Integer> map = new HashMap<>();
    List<int[]> res = new ArrayList<>();
    for (int[] a : A) {
      int x = a[0], y = a[1];
      if (map.containsKey(K-x) && map.get(K-x)==K-y) {
          res.add(new int[]{K-x, K-y});
          res.add(a);
          return res;
      }
      map.put(x, y);
    }
    return res;
  }

  public static void main(String... args) {
    int[][] A = new int[][]{{1, 2}, {2, 3}, {3, 2}};
    List<int[]> pair = findPair(A, 5);
    for (int[] p : pair) {
      System.out.println(p[0] + ", " + p[1]);
    }
  }

  // Notes: first I think use Map<String, String> to store "x -> y", because we want to find "(K-x) -> (K-y)", however,
  // it takes more space to store String than store int (4 bytes) and compare String also have more overhead.
  // So we should store Integer in Map. we use the Key to store x, and value to store y. And during the traverse, if we can
  // find (K-x), (K-y) pair, we return it.

}
