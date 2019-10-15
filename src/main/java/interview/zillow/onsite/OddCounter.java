package interview.zillow.onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of numbers, return all numbers which occurs odd times
 */
public class OddCounter {

  // Time: O(N), Space: O(N)
  public static List<Integer> countNumbers(int[] nums) {
    Map<Integer, Integer> numOfCount = new HashMap<>();
    for (int n : nums) {
      // This is a tricky part: since we only need know whether currently the number appears odd time or even time
      // we do not care the count, so we can flip between 0 and 1
      numOfCount.put(n, numOfCount.getOrDefault(n, 0) ^ 1);
    }
    List<Integer> res = new ArrayList<>();
    for (int key : numOfCount.keySet()) {
      if (numOfCount.get(key)==1) res.add(key);
    }
    return res;
  }

  public static void main(String... args) {
    List<Integer> res = countNumbers(new int[]{1, 2, 3, 4, 2});
    res.stream().forEach(o-> System.out.print(o + ", "));
  }
}
