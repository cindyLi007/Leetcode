package com.google.union.find;

import java.util.HashMap;
import java.util.Map;

public class MostStoneRemovedWithSameRowOrCol {

  int U, N;

  public int removeStones(int[][] stones) {
    // keep union numbers
    N = stones.length;
    U = N;
    for (int i=0; i<N; i++) {
      int x = stones[i][0], y = stones[i][1];
      union(x, y);
    }
    return N - U;
  }

  Map<String, String> map = new HashMap();

  private void union(int x, int y) {
    String px = find("x" + x), py = find("y" + y);
    if (!px.equals(py)) {
      map.put(py, px);
      U--;
    }
  }

  private String find(String idx) {
    if (!map.containsKey(idx)) {
      map.put(idx, idx);
      return idx;
    }
    while (!map.get(idx).equals(idx)) {
      idx = map.get(idx);
      map.put(idx, map.get(map.get(idx)));
    }
    return idx;
  }

  public static void main(String... args) {
    MostStoneRemovedWithSameRowOrCol mostStoneRemovedWithSameRowOrCol = new MostStoneRemovedWithSameRowOrCol();
    int[][] stones = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
    System.out.println(mostStoneRemovedWithSameRowOrCol.removeStones(stones));
  }
}
