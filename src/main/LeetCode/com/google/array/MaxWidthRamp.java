package com.google.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 962
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.
 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 */
public class MaxWidthRamp {
    public int maxWidthRamp(int[] A) {
        // keep a descending ordered list, because only if a element less than
        // prev ones, it can be candidates of left
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i=0; i<A.length; i++) {
            int v = A[i];
            if (i==0 || v < A[list.get(list.size()-1)]) {
                list.add(i);
            } else {
                // if a value is >= the top of the list, it can be the candidats or right, we do binary search for most left idx which <= this value
                int l=0, r=list.size()-1;
                while (l<r) {
                    int m=l+(r-l)/2;
                    if (A[list.get(m)]>v) l=m+1;
                    else r=m;
                }
                res = Math.max(res, i - list.get(r));
            }
        }
        return res;
    }
}
