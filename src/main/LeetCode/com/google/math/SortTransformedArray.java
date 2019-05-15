package com.google.math;

public class SortTransformedArray {
    // Time: O(N)
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int N=nums.length;
        int[] res = new int[N];
        /**
         * 1.a>0, two ends in original array are bigger than center
         * 2.a<0, center is bigger than two ends.
         */
        int idx = a>=0 ? N-1 : 0, i=0, j=N-1;
        while (i<=j) {
            int left = q(nums[i], a, b, c), right = q(nums[j], a, b, c);
            if (a>=0) {
                res[idx--] = left>=right ? left : right;
                if (left >= right) i++;
                else j--;
            } else {
                res[idx++] = left <=right ? left : right;
                if (left<=right) i++;
                else j--;
            }
        }
        return res;
    }

    private int q(int v, int a, int b, int c) {
        return a*v*v + b*v + c;
    }
}
