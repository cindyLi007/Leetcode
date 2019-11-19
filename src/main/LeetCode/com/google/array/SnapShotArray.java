package com.google.array;

import java.util.Map;
import java.util.TreeMap;

public class SnapShotArray {
  // Space: O(S) S is the number of set called
  TreeMap<Integer, Integer>[] map;
  int time;

  public SnapShotArray(int length) {
    map = (TreeMap<Integer, Integer>[])new TreeMap[length];
    time = 0;
  }

  // O(1)
  public void set(int index, int val) {
    if (map[index]==null) map[index] = new TreeMap();
    map[index].put(time, val);
  }

  // O(1)
  public int snap() {
    time++;
    return time-1;
  }

  // O(lgM), M is the snap number
  public int get(int index, int snap_id) {
    if (map[index]==null) return 0;
    Map.Entry<Integer, Integer> entry = map[index].floorEntry(snap_id);
    if (entry==null) return 0;
    return entry.getValue();
  }

  public static void main(String... args) {
    /*SnapShotArray snapShotArray = new SnapShotArray(3);
    snapShotArray.set(0, 5);
    snapShotArray.snap();
    snapShotArray.set(0, 6);*/
    SnapShotArray snapShotArray = new SnapShotArray(2);
    snapShotArray.snap();
    snapShotArray.get(1, 0);
    snapShotArray.get(0, 0);
    snapShotArray.set(1, 8);
    snapShotArray.set(1, 0);
    snapShotArray.set(0, 20);
    snapShotArray.get(0, 0);
    snapShotArray.set(0, 7);
    System.out.println(snapShotArray.snap());
    System.out.println(snapShotArray.get(0, 0));
    System.out.println(snapShotArray.snap());
  }
}
