package com.google.math;

// Time: O(n), Space: O(1)
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0]=1;
        int i=0, j=0, k=0;
        for (int x=1; x<n; x++) {
            int cand2=2*res[i], cand3=3*res[j], cand5=5*res[k];
            int min = Math.min(Math.min(cand2, cand3), cand5);
            if (min==cand2) i++;
            if (min==cand3) j++;
            if (min==cand5) k++;
            res[x]=min;
        }
        return res[n-1];
    }

    class ArrayData {
        int x, y, z;
        int val;

        ArrayData(int i, int j, int k) {
            x=i;
            y=j;
            z=k;
            val=i*2+j*3+k*5;
        }
    }

    public static void main(String... args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        int res = uglyNumberII.nthUglyNumber(10);
        System.out.println(res);
    }
}
