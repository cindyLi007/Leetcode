package com.google.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 835. Image Overlap
 * we can convert a 2-D matrix as 1-D list, so check overlap of 2-D matrix convert to shift one list to see how many bits are same
 * for ex. A [0, 1, 1, 1, 0, 0, 1, 1, 0, 0]
 *         B [0, 0, 0, 1, 1, 1, 0, 0, 1, 0], right shift A 2 times, there are 4 bits same
 * so we only need record all delta position and see in the delta, how many bits can overlap
 */
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        // first find all '1' in A and B, put coordinate in a List
        List<Integer> listA = new ArrayList();
        List<Integer> listB = new ArrayList();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // here we must use i*N*100 instead of i*N, because i*N+j can be equal to j*N+i
                if (A[i][j]==1) listA.add(i*N*100+j);
                if (B[i][j]==1) listB.add(i*N*100+j);
            }
        }
        Map<Integer, Integer> map = new HashMap();
        int res=0;
        for (Integer a : listA) {
            for (Integer b : listB) {
                int k = a-b;
                map.put(k, map.getOrDefault(k, 0)+1);
                res=Math.max(res, map.get(k));
            }
        }
        return res;
    }
}
