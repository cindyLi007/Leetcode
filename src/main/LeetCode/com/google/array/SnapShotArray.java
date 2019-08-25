package com.google.array;

import java.util.TreeMap;

public class SnapShotArray {
  // Space: O(S) S is the number of set called
  TreeMap<Integer, Integer>[] map;
  int snapTimes;

  // O(N)
  public SnapShotArray(int length) {
    map = (TreeMap<Integer, Integer>[])new TreeMap[length];
    snapTimes = 0;
    for (int i=0; i<length; i++) {
      map[i] = new TreeMap();
      map[i].put(snapTimes, 0);
    }
  }

  // O(1)
  public void set(int index, int val) {
    map[index].put(snapTimes, val);
  }

  // O(1)
  public int snap() {
    return snapTimes++;
  }

  // O(lgM), M is the snap number
  public int get(int index, int snap_id) {
    return map[index].floorEntry(snap_id).getValue();
  }

  public static void main(String... args) {
    /*SnapShotArray snapShotArray = new SnapShotArray(3);
    snapShotArray.set(0, 5);
    snapShotArray.snap();
    snapShotArray.set(0, 6);*/
    SnapShotArray snapShotArray = new SnapShotArray(1);
    snapShotArray.set(0, 4);
    snapShotArray.set(0, 16);
    snapShotArray.set(0, 13);
    System.out.println(snapShotArray.snap());
    System.out.println(snapShotArray.get(0, 0));
    System.out.println(snapShotArray.snap());
  }
}
