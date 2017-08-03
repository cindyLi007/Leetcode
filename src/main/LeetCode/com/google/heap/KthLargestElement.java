package com.google.heap;

/**
 * Created by ychang on 5/10/2017.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargestElement {
  public int findKthLargest(int[] nums, int k) {
    int high=nums.length-1;
    return helper(nums, 0, high, nums.length-k);
  }

  private int helper(int[] nums, int low, int high, int k) {
    if (low==high) return nums[low];
    int lt=low, gt=high, i=low;
    int pivot=nums[lt];
    while (i<=gt) {
      if (nums[i]<pivot) exchange(nums, i++, lt++);
      else if (nums[i]>pivot) exchange(nums, i, gt--);
      else i++;
    }
    /**
     * in quick sort, after sort, "lt" is the 1st pivot element index, "i" is the 1st greater-than-pivot element index
     * for example, [0, 0, 0, 1, 1, 2, 2], lt should be 3, i should be 5.
     */
    if (k>=lt && k<i) return nums[lt];
    if (k<lt) return helper(nums, low, lt-1, k);
    else return helper(nums, i, high, k);
  }

  private void exchange(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }
}
