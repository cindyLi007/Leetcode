package com.google.math;

import java.util.PriorityQueue;

public class SupperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int count=1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        int prev = 0;
        while (count<=n) {
            int cur = pq.poll();
            if (cur==prev) {
                continue;
            }
            System.out.println(cur);
            for (int num : primes) {
                pq.add(cur*num);
            }
            count++;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        SupperUglyNumber supperUglyNumber = new SupperUglyNumber();
        int res = supperUglyNumber.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        System.out.println(res);
    }
}
