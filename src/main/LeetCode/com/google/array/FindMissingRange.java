package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRange {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> res = new ArrayList<String>();
    if (nums.length == 0) {
      res.add(generate(lower, upper));
      return res;
    }
    // 这里我们利用了一个特性就是Integer.MAX + 1 = Integer.MIN, Integer.MIN - 1 = Integer.MAX
    int prev = lower - 1;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num > prev + 1) {
        res.add(generate(prev + 1, num - 1));
      }
      prev = num;
      if (num >= upper) break;
    }

    if (prev < upper) res.add(generate(prev + 1, upper));

    return res;
  }

  private String generate(int start, int end) {
    return start == end ? start + "" : start + "->" + end;
  }

  public static void main(String... args) {
    FindMissingRange findMIssingRange = new FindMissingRange();
        /*List<String> missingRanges = findMIssingRange.findMissingRanges(
                new int[]{-2147483648,2147483647},
        -2147483648,
        2147483647);*/
    List<String> missingRanges = findMIssingRange.findMissingRanges(
        new int[]{2147483647},
        -2147483648,
        2147483647);
    System.out.println(Integer.MAX_VALUE + 1);
    System.out.println(Integer.MIN_VALUE - 1);
  }
}
