package com.google.array;

/**
 * Created by ychang on 8/16/2017.
 */
public class FindMinInRotatedSortedII {
  public int findMin(int[] nums) {
    return find(nums, 0, nums.length - 1);
  }

  private int find(int[] nums, int low, int high) {
    if (low>=high)
      return nums[low];
    int mid = low + (high - low)/2;
    if (nums[mid]<nums[high]) {
      return find(nums, low, mid);
    } else if (nums[mid]>nums[high]) {
      return find(nums, mid + 1, high);
    } else {
      if (nums[low]==nums[mid]) {
        return Math.min(find(nums, low, mid - 1), find(nums, mid + 1, high));
      } else {
        return find(nums, low, mid);
      }
    }
  }
}
