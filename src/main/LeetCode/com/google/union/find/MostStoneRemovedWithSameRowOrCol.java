package com.google.union.find;

import java.util.HashMap;
import java.util.Map;

// Leetcode 947
// 1 <= stones.length <= 1000
// 0 <= stones[i][j] < 10000

/**
 * we can remove a stone if and only if, there is another stone in the same column OR row. We try to remove as many as stones as possible.
 * So for each point, if its x and y duplicate with other point's x or y, the 2 points are in the same set, we can remove one of them.
 * That translate the problem as find all how many sets, we need keep one stone in each set. So result = # of stones - # of sets
 * How to find all sets? if a points x or y belongs to any existing set, we can union these 2 sets.
 */
public class MostStoneRemovedWithSameRowOrCol {
  int U;

  // Time: O(N*lgN), Space: O(N)
  public int removeStones(int[][] stones) {
    int N = stones.length;
    U = 0;
    for (int[] stone : stones) {
      // to diff x and y, since 0 <= stones[i][j] < 10000, we make key_Y = y+10000
      union(stone[0], stone[1] + 10000);
    }
    return N - U;
  }

  Map<Integer, Integer> map = new HashMap();

  private void union(int x, int y) {
    if (!map.containsKey(x)) {
      map.put(x, x);
      U++;
    }
    while (x != map.get(x)) {
      map.put(x, map.get(map.get(x)));
      x = map.get(x);
    }
    if (!map.containsKey(y)) {
      map.put(y, x);
    } else {
      while (y != map.get(y)) {
        map.put(y, map.get(map.get(y)));
        y = map.get(y);
      }
      if (y != x) {
        map.put(y, x);
        U--;
      }
    }
  }

  public static void main(String... args) {
    MostStoneRemovedWithSameRowOrCol mostStoneRemovedWithSameRowOrCol = new MostStoneRemovedWithSameRowOrCol();
    int[][] stones = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
    System.out.println(mostStoneRemovedWithSameRowOrCol.removeStones(stones));
  }
}
