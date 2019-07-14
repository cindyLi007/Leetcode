package com.google.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {
    // Time: O(N), Space: O(1)
    public static void nextPermutation(int[] nums) {
        // [6, 2, 1, 5, 4, 3, 0]
        if (nums==null || nums.length <=1) return;
        int N=nums.length, i=N-2;

        // 1. find most-right K, which nums[K] < nums[K+1], suffix[K+1, N) is descending
        while (i>=0 && nums[i]>=nums[i+1]) i--;
        // if array is fully descreasing, revert it [3, 2, 1] -> [1, 2, 3]
        if (i<0) reverse(nums, 0, N-1);
        else {
            // find the smallest entry > nums[i] from suffix [i+1, N) and swap i with it, since we know suffix [i+1, N) is
            // descreaing, we can from N-1 to i+1, the first elem > nums[i] must be the smallest entry > nums[i]
            for (int j=N-1; j>i; j--) {
                if (nums[j]>nums[i]) {
                    swap(nums, i, j);
                    // we still could not guarantee that now suffix is smallest, since before swap is it descreasing, after swap
                    // suffix [i+1, N) is still descending, we only need revert it
                    reverse(nums, i+1, N-1);
                    break;
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private static void reverse(int[] nums, int s, int e) {
        while (s<e) swap(nums, s++, e--);
    }

    public static void main(String... args) {
        int[] nums = {6, 2, 3, 5, 4, 1, 0};
//        nextPermutation(nums);
        previousPermutation(nums);
        for (int n : nums) System.out.print(n + ", ");
        System.out.println();
    }

    public static void previousPermutation(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int N=nums.length, i=N-2;
        for (; i>=0; i--) {
            if (nums[i] > nums[i+1]) break;
        }
        if (i==-1) return;
        for (int j=N-1; j>i; j--) {
            if (nums[j] < nums[i]) {
                swap(nums, i, j);
                reverse(nums, i+1, N-2);
            }
        }
    }
}
