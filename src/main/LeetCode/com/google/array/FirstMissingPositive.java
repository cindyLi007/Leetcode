package com.google.array;

/**
 * Created by ychang on 7/24/2017.
 * Given an unsorted integer array, find the first missing positive integer.
 */
public class FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    int n=nums.length;
    if (n==0) return 1;
    for (int i=0; i<n; i++) {
      while (nums[i]>0 && nums[i]<n && nums[nums[i]-1]!=nums[i]) {
        swap(nums, nums[i]-1, i);
      }
    }
    for (int i=0; i<n; i++) {
      if (nums[i]!=i+1) return i+1;
    }
    return n+1;
  }
  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i]=a[j];
    a[j]=temp;
  }
}
