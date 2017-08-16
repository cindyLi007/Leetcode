package com.google.binary.search;

import java.util.Arrays;

/**
 * Created by ychang on 1/31/2017.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * The key idea is to recursively remove (k-1)th element from either array, that is based on if we compare N1[k/2] and
 * N2[k/2], the smaller part never can include kth element
 */
public class MedianOfTwoSortedArray {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length, left = (m + n + 1)/2, right = (m + n + 2)/2;
    if (left==right) {
      return findKth(nums1, nums2, left)*1.0;
    }
    return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right))/2.0;
  }

  int findKth(int[] nums1, int[] nums2, int k) {
    int m = nums1.length, n = nums2.length;
    // always guarantee nums1 is smaller one
    if (m>n) {
      return findKth(nums2, nums1, k);
    }
    // the following 2 are base cases, since K is the kth element, in 0-index array, should k-1 to get kth element
    if (m==0) {
      return nums2[k - 1];
    }
    if (k==1) {
      return Math.min(nums1[0], nums2[0]);
    }

    // recursive part, to prevent out of bound array
    int i = Math.min(m, k/2), j = Math.min(n, k/2);
    if (nums1[i - 1]>nums2[j - 1]) {
      /**
       * nums2 first 0 to 2/k part never can be median, remove that part
       * Arrays.copyOfRange
       * from - the initial index of the range to be copied, *inclusive*
       * to - the final index of the range to be copied, *exclusive. (This index may lie outside the array.)*
       */
      return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
    } else {  // nums1 first 0 to 2/k part never can be median, remove that part
      return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
    }
  }
}
