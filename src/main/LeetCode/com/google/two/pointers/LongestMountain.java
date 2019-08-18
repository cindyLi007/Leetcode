package com.google.two.pointers;

public class LongestMountain {
    public static int longestMountain(int[] A) {
        int N = A.length, max=0, l=0, r=0;
        while (l<N-1) {
            while (l<N-1 && A[l]>=A[l+1]) l++;
            if (l==N-1) return max;
            // now l is the start point
            r=l;
            // find the highest point
            while (r<N-1 && A[r+1]>A[r]) r++;
            // invalid start over
            if (A[r+1]==A[r]) {
                l=r+1; continue;
            }
            while (r<N-1 && A[r+1]<A[r]) r++;
            max = Math.max(max, r-l+1);
            // should reset l to r instead of r+1
            l = r;
        }
        return max;
    }

    public static void main(String... args) {
//        int[] array = {2, 1, 4, 7, 3, 2, 5};
        int[] array = {875,884,239,731,723,685};
        int res = longestMountain(array);
        System.out.println(res);
    }
}
