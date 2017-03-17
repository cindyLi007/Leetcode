package com.google.two.pointers;

/**
 * Created by ychang on 3/12/2017.
 */
public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i=m-1, j=n-1, z=m+n-1;
    while (i>=0 && j>=0) {
      nums1[z--]= nums1[i]>nums2[j] ? nums1[i--] : nums2[j--];
    }
    while (j>=0) {
      nums1[z--]=nums2[j--];
    }
  }
}
