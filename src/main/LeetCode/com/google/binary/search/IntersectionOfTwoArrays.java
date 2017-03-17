package com.google.binary.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ychang on 1/28/2017.
 * This problem can be solved using HashSet, binary search and two pointer
 */
public class IntersectionOfTwoArrays {
  // beat 46% O(n)
  public int[] intersection_twoHashSet(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet();
    Set<Integer> res = new HashSet();
    for (int i : nums2) {
      set.add(i);
    }
    for (int i : nums1) {
      if (set.contains(i)) {
        res.add(i);
      }
    }
    return set.stream().mapToInt(i->i).toArray();
  }

  // beat 2% O(nlogn)
  public int[] intersection_twoPointer(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    Set<Integer> set = new HashSet();
    int i=0, j=0;
    while (i<nums1.length && j<nums2.length) {
      if (nums1[i]<nums2[j]) {
        i++;
      } else if (nums2[j]<nums1[i]) {
        j++;
      } else {
        set.add(nums2[j++]); i++;
      }
    }
    return set.stream().mapToInt(num->num).toArray();
  }

  // beat 0.85%
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
    return Arrays.stream(nums1).distinct().filter(i -> set.contains(i)).toArray();
  }

  // beat 2% O(nlogn)
  public int[] intersection_binarySearch(int[] nums1, int[] nums2) {
    if (nums1.length<nums2.length) return intersection_binarySearch(nums2, nums1);
    Arrays.sort(nums1);
    Set<Integer> set = new HashSet();
    for (int i : nums2) {
      if (binarySearch(nums1, i)){
        set.add(i);
      }
    }
    return set.stream().mapToInt(i->i).toArray();
  }

  private boolean binarySearch(int[] array, int t) {
    int lo=0, hi=array.length-1;
    while (lo<=hi) {
      int mid = lo+(hi-lo)/2;
      if (array[mid]==t) {
        return true;
      }
      if (array[mid]>t) {
        hi=mid-1;
      } else {
        lo=mid+1;
      }
    }
    return false;
  }
}
