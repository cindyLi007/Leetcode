package com.google.two.pointers;

/**
 * Created by ychang on 1/31/2017.
 */
public class FindDuplicateNumber {
  public int findDuplicate(int[] nums) {
    int slow=nums[0], fast=nums[nums[0]];
    while (slow!=fast) {
      slow=nums[slow];
      fast=nums[nums[fast]];
    }
    slow=0;
    while (slow!=fast) {
      slow=nums[slow];
      fast=nums[fast];
    }
    return slow;
  }
}
