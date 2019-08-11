package com.google.math;

public class SortTransformedArray {
    // Time: O(N)
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int N=nums.length;
        int[] res = new int[N];
        /**
         * 1.a>=0, two ends in original array are bigger than center
         * 2.a<0, center is bigger than two ends.
         */
        int idx = a>=0 ? N-1 : 0;
        int left=0, right=N-1;
        while (left<=right) {
            int left_res = q(nums[left], a, b, c), right_res = q(nums[right], a, b, c);
            if (a>=0) {
                res[idx--] = left_res>=right_res ? left_res : right_res;
                if (left_res >= right_res) left++;
                else right--;
            } else {
                res[idx++] = left_res <=right_res ? left_res : right_res;
                if (left_res<=right_res) left++;
                else right--;
            }
        }
        return res;
    }

    private int q(int v, int a, int b, int c) {
        return a*v*v + b*v + c;
    }
}
