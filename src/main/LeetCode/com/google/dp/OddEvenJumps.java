package com.google.dp;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {

    public static void main(String... args) {
        OddEvenJumps oddEvenJumps = new OddEvenJumps();
        int[] a = new int[]{5, 1, 3, 4, 2};
        System.out.println(oddEvenJumps(a));
    }

    public static int oddEvenJumps(int[] A) {
        int N = A.length;
        TreeMap<Integer, Integer> map = new TreeMap();
        int sum = 1;
        map.put(A[N-1], N-1);
        boolean[][] res = new boolean[N][2];
        res[N-1][0] = true;
        res[N-1][1] = true;
        for (int i=N-2; i>=0; i--) {
            int v = A[i];
            Map.Entry<Integer, Integer> entry = map.floorEntry(v); // most great vaule <= v
            if (entry != null) {
                int j = entry.getValue();
                if (res[j][1]) res[i][0] = true;
            }
            entry = map.ceilingEntry(v);
            if (entry != null) {
                int j = entry.getValue();
                if (res[j][0]) res[i][1] = true;
            }
            if (res[i][1])
                sum++;
            map.put(A[i], i);
        }
        return sum;
    }
}
