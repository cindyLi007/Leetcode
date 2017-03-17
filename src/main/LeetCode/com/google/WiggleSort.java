package com.google;

import java.util.Arrays;

/**
 * Created by ychang on 12/9/2016.
 * Every even-index must less than its neighbors, every odd-index must greater than its neighbors.
 * When loop to ith element, if it is odd, it's left neighbor (i-1)th element must be even, if (ith) < ((i-1)th),
 * that means it must be less than ((i-2)th), so no need to compare (ith) with ((i-2)th), just swap (ith) with ((i-1)th)
 */
public class WiggleSort {
  public void wiggleSort(int[] nums) {
    for(int i=1;i<nums.length;i++) {
      int a=nums[i-1];
      if ((i%2==1) == (nums[i]<a)) {
        nums[i-1] = nums[i];
        nums[i] = a;
      }
    }
  }

  public static void main(String[] args) {
    WiggleSort instance = new WiggleSort();
    int[] a = new int[]{3, 5, 2, 1, 6, 4};
    instance.wiggleSort(a);
    Arrays.stream(a).forEach(i -> System.out.print(" "+ i));
  }
}
