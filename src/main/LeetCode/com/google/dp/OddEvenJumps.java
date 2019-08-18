package com.google.dp;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {

    public int oddEvenJumps(int[] A) {
        int N=A.length, count=1;
        boolean[] odd=new boolean[N], even=new boolean[N];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[N-1], N-1);
        odd[N-1]=true;
        even[N-1]=true;
        for (int i=N-2; i>=0; i--) {
            Map.Entry<Integer, Integer> max = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> min = map.floorEntry(A[i]);
            odd[i] = max!=null && even[max.getValue().intValue()];
            even[i] = min!=null && odd[min.getValue().intValue()];
            if (odd[i]) count++;
            map.put(A[i], i);
        }
        return count;
    }

    public static void main(String... args) {
        OddEvenJumps oddEvenJumps = new OddEvenJumps();
        int[] a = new int[]{1,2,3,2,1,4,4,5};
        System.out.println(oddEvenJumps.oddEvenJumps(a));
    }
}
