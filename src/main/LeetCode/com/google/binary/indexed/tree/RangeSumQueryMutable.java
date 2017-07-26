package com.google.binary.indexed.tree;

/**
 * Created by ychang on 6/12/2017.
 * this can beat 73%
 */
public class RangeSumQueryMutable {
  // if we need return min and sum and/or other summary values, we can use Node[], in Node we can save multiple values
  int[] nums;
  int[] bit;

  public RangeSumQueryMutable(int[] nums) {
    this.nums = new int[nums.length];
    bit = new int[nums.length + 1];
    for (int i = 0; i<nums.length; i++) {
      update(i, nums[i]);
    }
  }

  public void update(int i, int val) {
    int diff = val - nums[i];
    nums[i++] = val;
    while (i<bit.length) {
      bit[i] += diff;
      i += i & -i; // this is to add the right-most 1, for stride
    }
  }

  public int sumRange(int i, int j) {
    return getSum(j) - getSum(i - 1); // note include i, so should be (i-1)
  }

  private int getSum(int idx) {
    int sum = 0;
    idx++;
    while (idx>0) {
      sum += bit[idx];
      idx -= idx & -idx;
    }
    return sum;
  }
}
