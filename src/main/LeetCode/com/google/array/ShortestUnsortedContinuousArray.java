package com.google.array;

import java.util.Arrays;

public class ShortestUnsortedContinuousArray {
    public int findUnsortedSubarray(int[] nums) {
        int N=nums.length;

        // This is a good way to copy Array
        int[] prev = nums.clone();
        Arrays.sort(nums);

        int s=N-1, e=0;
        for (int i=0; i<N; i++) {
            if (prev[i]!=nums[i]) {
                s=Math.min(s, i);
                e=Math.max(e, i);
            }
        }
        return e-s>0 ? e-s+1 : 0;
    }
}
