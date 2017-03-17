package com.google.array;

import java.util.Arrays;

/**
 * Created by ychang on 12/8/2016.
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    if (digits==null || digits.length==0)
      return digits;
    for (int i = digits.length - 1; i>=0; i--) {
      if (digits[i]<9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 9, 9, 9};
    PlusOne plusOne = new PlusOne();
    int[] result = plusOne.plusOne(nums);
    Arrays.stream(result).forEach(System.out::println);
  }
}
