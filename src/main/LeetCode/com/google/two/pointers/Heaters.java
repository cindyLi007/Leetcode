package com.google.two.pointers;

import java.util.Arrays;

/**
 * Created by ychang on 12/15/2016.
 * This is a 2-pointer problem, we keep 2 pointers, one for heaters, one for house
 * 20 ms
 */
public class Heaters {
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int res = 0;
    int i=0;
    for (int house : houses) {
      // for each house, find the closest heater, 2*house >= heaters[i]+ heaters[i+1] equals
      // Math.abs(house-heaters[i]) <= Math.abs(heaters[i+1]-house)
      while (i<heaters.length-1 && 2*house >= heaters[i]+heaters[i+1])
        i++;
      res = Math.max(res, Math.abs(heaters[i]-house));
    }

    return res;
  }

  public static void main(String[] args) {
    Heaters heaters = new Heaters();
    int[] array = new int[15210];
    for (int i=0; i<15200; i++) {
      array[i] = i+1;
    }
    for (int i=0; i<10; i++) {
      array[i+15200] = i+15200+10;
    }
    int radius = heaters.findRadius(array, array);
    System.out.println(radius);
  }
}
