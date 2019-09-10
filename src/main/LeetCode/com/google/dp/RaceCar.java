package com.google.dp;

import java.util.*;

/**
 * Leetcode 818
 * Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)
 * Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).
 * When you get an instruction "A", your car does the following: position += speed, speed *= 2.
 * When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)
 */
public class RaceCar {
  /**
   * The BFS runs at O(target * log(target)) in the worst case, with O(target * log(target)) space. The reasoning is as
   * follows: in the worst case, all positions in the range [-target, target] will be visited and for each position
   * there can be as many as 2 * log(target) different speeds. that is because speed is always 1, 2, 4, 8, 16, or -1, -2, -4, -8, -16
   */
  public int raceCar(int target) {
    Set<String> visited = new HashSet();
    visited.add("0-1");
    Deque<int[]> prev = new LinkedList();
    prev.addLast(new int[]{0, 1});

    for (int level = 0; !prev.isEmpty(); level++) {
      for (int i=prev.size()-1; i>=0; i--) {
        int[] cur = prev.pollFirst();
        if (cur[0]==target) return level;
        int[] next = new int[]{cur[0] + cur[1], cur[1] * 2};
        String key = next[0] + "-" + next[1];
        if (!visited.contains(key) && next[0] > 0 && next[0] < target*2) {
          visited.add(key);
          prev.addLast(next);
        }
        int[] next2 = new int[]{cur[0], cur[1]>0 ? -1 : 1};
        key = next2[0] + "-" + next2[1];
        if (!visited.contains(key) && next2[0] > 0 && next2[0] < target*2) {
          visited.add(key);
          prev.addLast(next2);
        }
      }
    }
    return -1;
  }

  public static void main(String... args) {
    RaceCar raceCar = new RaceCar();
    System.out.println(raceCar.raceCar(3)); // should be 2
    System.out.println(raceCar.raceCar(6)); // should be 5
    System.out.println(raceCar.raceCar(5617)); // should be 41
  }
}
