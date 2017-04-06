package com.google.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ychang on 12/8/2016.
 */
public class MissingRange {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> res = new ArrayList();
    long lo = lower, up = upper;
    for (int num : nums) {
      if (lo<num) {
        if (lo==num - 1)
          res.add(lo + "");
        else
          res.add(lo + "->" + (num - 1));
      }
      lo = (long) num + 1;
    }
    if (lo<=up) {
      if (lo==up)
        res.add(lo + "");
      else
        res.add(lo + "->" + up);
    }
    return res;
  }

  public static void main(String[] args) {
    MissingRange missingRange = new MissingRange();
    int[] array = new int[]{0, 1, 3, 50, 75};
    Arrays.stream(array).forEach(i -> System.out.print(i + " "));
    System.out.println();
    List<String> result = missingRange.findMissingRanges(array, 0, 99);
    result.forEach(System.out::println);
  }

}
