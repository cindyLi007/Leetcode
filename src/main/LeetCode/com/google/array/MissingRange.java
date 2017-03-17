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
    for (int num : nums) {
      if (lower < num) {
        if (lower == num-1) res.add(lower+"");
        else res.add(lower+"->"+(num-1));
      }
      lower=num+1;
    }
    if (lower==Integer.MIN_VALUE) return res;
    if (lower<=upper) {
      if (lower==upper) res.add(lower+"");
      else res.add(lower+"->"+upper);
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
