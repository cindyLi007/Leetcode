package com.google.Reservior.Sampling;

import java.util.Random;

/**
 * Created by ychang on 5/30/2017.
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 */
public class RandomPickIndex {
  int[] nums;
  Random random;

  public RandomPickIndex(int[] nums) {
    this.nums = nums;
    random = new Random();
  }

  public int pick(int target) {
    int res = -1;
    int count = 0;
    for (int i = 0; i<nums.length; i++) {
      /**
       * random.nextInt(x) returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the
       * specified value (exclusive)
       */
      if (nums[i]==target && random.nextInt(++count)==count - 1) {
        res = i;
      }
    }
    return res;
  }
}
