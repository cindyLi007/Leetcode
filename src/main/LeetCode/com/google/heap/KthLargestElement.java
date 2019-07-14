package com.google.heap;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by ychang on 5/10/2017.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, (o1, o2) -> o2 - o1);
    }

    private int findKthLargest(int[] nums, int k, Comparator<Integer> cmp) {
        int left = 0, right = nums.length - 1;
        Random rand = new Random();
        while (left <= right) {
            int idx = rand.nextInt(right - left + 1) + left;
            int newIdx = partition(nums, k, cmp, idx, left, right);
            if (newIdx == k - 1) return nums[newIdx];
            if (newIdx > k - 1) right = newIdx - 1;
            else left = newIdx + 1;
        }
        return -1;
    }

    private int partition(int[] nums, int k, Comparator<Integer> cmp, int idx, int left, int right) {
        int val = nums[idx];
        swap(nums, idx, right);
        int newIdx = left;

        for (int i = left; i < right; i++) {
            if (cmp.compare(nums[i], val) <= 0) {
                swap(nums, i, newIdx++);
            }
        }

        swap(nums, newIdx, right);
        return newIdx;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
