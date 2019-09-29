package com.google.greedy;

import java.util.HashMap;
import java.util.Map;

// 659. Split Array into Consecutive Subsequences
public class SplitArrayIntoConsecutiveSubdequences {

  // Time: O(N), Space: O(N)
  public boolean isPossible(int[] nums) {
    // tail map denotes for i, whether there is any previous subarray can connect it (tail.get(i)!=null && tail.get(i) > 0),
    // we always first try append i to existing subarray (greedy), if we could not append i to existing subarray, we will
    // try to create a new subarray starting i, and check we have i+1 and i+2  available to insert in this subarray,
    // if not we will directly return false
    Map<Integer, Integer> count = new HashMap<>(), tail = new HashMap<>();
    for (int i : nums) {
      count.put(i, count.getOrDefault(i, 0) + 1);
    }
    for (int i : nums) {
      if (count.get(i)==0) continue;
      if (tail.get(i)!=null && tail.get(i)>0) {
        tail.put(i, tail.get(i)-1);
        tail.put(i+1, tail.getOrDefault(i+1, 0) + 1);
      } else if (count.get(i+1) !=null && count.get(i+1) > 0 && count.get(i+2) !=null && count.get(i+2) > 0) {
        count.put(i+1, count.get(i+1)-1);
        count.put(i+2, count.get(i+2)-1);
        tail.put(i+3, tail.getOrDefault(i+3, 0) + 1);
      } else return false;
      count.put(i, count.get(i)-1);
    }
    return true;
  }

  public static void main(String... args) {
    SplitArrayIntoConsecutiveSubdequences array = new SplitArrayIntoConsecutiveSubdequences();
    System.out.println(array.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
  }
}
