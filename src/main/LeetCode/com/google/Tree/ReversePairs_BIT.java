package com.google.Tree;

import java.util.Arrays;

/**
 * Created by ychang on 6/12/2017.
 */
public class ReversePairs_BIT {
  public int reversePairs(int[] nums) {
    int[] copy=Arrays.copyOf(nums, nums.length);
    Arrays.sort(copy);
    /**
     * built upon sorted array, index has one right shift, tree[i] record one or multiple values sum in f[i] which means
     * number of >= copy[i-1]
     */
    int[] tree=new int[nums.length+1];

    int res=0;
    for (int num : nums) {
      res+=search(tree, index(copy, num*2L+1));
      int index = index(copy, num);
      System.out.println(num + " will be insert to " + index);
      insert(tree, index);
      System.out.println(Arrays.toString(tree));
    }
    return res;
  }

  /**
   * return the first index in sorted array which value is no less than @param value
   */
  private int index(int[] nums, long value) {
    int l=0, h=nums.length-1;
    while (l<=h) {
      int m=l+(h-l)/2;
      if (nums[m]>=value) h=m-1;
      else l=m+1;
    }
    return l+1;
  }

  /**
   * When we insert a value to tree, we need update all tree[i] which no greater than it, traverse from some index towards root.
   */
  private void insert(int[] tree, int index) {
    while (index>0) {
      tree[index]++;
      index-=index&-index;
    }
  }

  /**
   * since we need find the number of elements greater than some value, we need traverse from an index towards the end of
   * tree array.
   */
  private int search(int[] tree, int index) {
    int sum=0;
    while (index<tree.length) {
      sum+=tree[index];
      index+=index&-index;
    }
    return sum;
  }
}
