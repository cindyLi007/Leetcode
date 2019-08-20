package com.google.heap;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by ychang on 5/10/2017.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * EPI 11.8
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, (o1, o2) -> o2 - o1);
    }

    private int find(int[] nums, int k, Comparator<Integer> com) {
        int left = 0, right = nums.length-1;
        Random random = new Random();
        while (left<=right) {
            int p = random.nextInt(right-left+1) + left;
            int[] range = partition(nums, k, left, right, p, com);
            int low = range[0], high = range[1];
            if (low<=k-1 && k-1<=high) return nums[low];
            if (k-1<low) right=low-1;
            else left=high+1;
        }
        return -1;
    }

    private int[] partition(int[] nums, int k, int left, int right, int p, Comparator<Integer> com) {
        int v = nums[p];
        swap(nums, p, left);
        int i=left;
        while (i<=right) {
            int c = com.compare(nums[i], v);
            if (c==0) i++;
            else if (c<0) swap(nums, left++, i++);
            else swap(nums, right--, i);
        }
        return new int[]{left, right};
    }

    private void swap(int[] nums, int i, int j) {
        int n = nums[i];
        nums[i]=nums[j];
        nums[j]=n;
    }

}
