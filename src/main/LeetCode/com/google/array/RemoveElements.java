package com.google.array;

/**
 * Created by ychang on 3/15/2017.
 * This one is different with {@link com.google.linked.list.RemoveLinkedListElement} that one we must reset next(index)
 * this one we only need reset value in position. Array vs. Linked List nature decide we use different way to handle it
 */
public class RemoveElements {
  /**
   * this can beat 97%
   */
  public int removeElement(int[] nums, int val) {
    if (nums.length==0) return 0;
    int res=0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i]!=val) {
        nums[res++] =nums[i];
      }
    }
    return res;
  }

  /**
   * this can beat 75%
   */
  public int removeElement_twoPointers(int[] nums, int val) {
    if (nums.length==0) return 0;
    int i=0, j=nums.length-1;
    /**
     * must have =, for example ([1], 1) should return 0. if only while (i<j), i=0, j=0, we will not go to while loop,
     * will return 1
     */
    while (i<=j) {
      while(i<=j && nums[i]!=val) i++;
      if (i>j) break;
      while(i<=j && nums[j]==val) j--;
      if (i>j) break;
      nums[i++]=nums[j--];
    }
    return j+1;
  }
}
