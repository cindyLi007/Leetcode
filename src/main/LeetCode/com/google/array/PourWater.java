package com.google.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Input: heights = [2,1,1,2,1,2,2], V = 4, K = 3
 * Output: [2,2,2,3,2,2,2]
 */
public class PourWater {
    public static int[] pourWater(int[] heights, int V, int K) {
        for (int i=0; i<V; i++) {
            int min = -1;
            for (int j=K-1; j>=0; j--) {
                if (heights[j]<heights[K]) {
                    if (min==-1) min = j;
                    else min = heights[j]<heights[min] ? j : min;
                }
            }
            if (min==-1) {
                for (int j=K+1; j<heights.length; j++) {
                    if (heights[j]<heights[K]) {
                        if (min==-1) min=j;
                        else min = heights[j]<heights[min] ? j : min;
                    }
                }
            }
            if (min==-1) {
                heights[K]++;
            } else {
                heights[min]++;
            }
        }
        return heights;
    }

    public static void main(String... args) {
        // int[] res = pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3);
//        int[] res = pourWater(new int[]{1, 2, 3, 4}, 2, 2);
        int[] res = pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1}, 2, 5);
        for (int i=0; i<res.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }
}
