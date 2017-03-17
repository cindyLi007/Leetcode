package com.google.binary.search;

import java.util.Arrays;

/**
 * Created by ychang on 12/19/2016.
 * 30 ms
 */
public class Heaters {
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);
    int res = 0;

    for (int house : houses) {
      /**
       * Arrays.binarySearch will return a), if we can find the elem, return index, b), otherwise, return (-insertion-1)
       */
      int index = Arrays.binarySearch(heaters, house);
      // if index >=0, that means there is a heater in the house spot, radius = 0;
      // if index <0, index = (-insertion -1), we need compare insertion-1, insertion which one is closer to the house
      if (index<0) {
        index = -(index + 1);
        int dist1 = index>0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
        int dist2 = index<heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
        res = Math.max(res, Math.min(dist1, dist2));
      }
    }
    return res;
  }
}
