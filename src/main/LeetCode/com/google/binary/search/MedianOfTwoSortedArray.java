package com.google.binary.search;

/**
 * Created by ychang on 1/31/2017.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * ==========================================================================================================================================
 * In order to solve this question, we need to first understand what a median is. A median is the middle value of a dataset.                ||
 * Since we have 2 seperately sorted array in this question, to findKthElementInTwoSortedArray the middle value is somewhat complicated.    ||
 * However, keep in mind that we do not care about the actual value of the numbers, what we want is the middle point                        ||
 * from the combination of 2 arrays. In other words, we are looking for the middle index of the 2 arrays.                                   ||
 * Thus approach like binary search could be employed.                                                                                      ||
 * Based on the fact that the 2 arrays are sorted seperatedly, we could try to get the submedian of the 2 arrays in each round.             ||
 * Than compare them. And the basic idea is that the left half of the array with a smaller submedian can never contains the common median.  ||
 * The key idea is to recursively remove (k-1)th element from either array, that is based on if we compare N1[k/2] and
 * N2[k/2], the smaller part never can include kth element
 */
public class MedianOfTwoSortedArray {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int M=nums1.length, N=nums2.length;
    int left=(M+N+1)/2, right=(M+N+2)/2;
    int median=findKth(nums1, 0, nums2, 0, left);
    if (left==right) return median*1.0;
    return (median + findKth(nums1, 0, nums2, 0, right)) * 0.5;
  }

  private int findKth(int[] n1, int s1, int[] n2, int s2, int k) {
    if (s1>n1.length-1) return n2[s2+k-1];
    if (s2>n2.length-1) return n1[s1+k-1];
    if (k==1) return Math.min(n1[s1], n2[s2]);

    // if an array length < k/2, no matter its values, we must remove the other array's k/2, so we set m1 to Integer.MAX
    int m1=Integer.MAX_VALUE, m2=Integer.MAX_VALUE;
    if (s1+k/2-1<n1.length) m1=n1[s1+k/2-1];
    if (s2+k/2-1<n2.length) m2=n2[s2+k/2-1];
    if (m1<m2) {
      return findKth(n1, s1+k/2, n2, s2, k-k/2);
    }
    return findKth(n1, s1, n2, s2+k/2, k-k/2);
  }
}
