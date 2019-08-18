package com.google.array;

public class KEmptySlots {
    public int kEmptySlots(int[] bulbs, int K) {
        int N = bulbs.length;
        int[] day = new int[N];
        for (int i=0; i<N; i++) {
            day[bulbs[i]-1]=i;
        }
        int res = Integer.MAX_VALUE;
        int left = 0, right = K+1;
        while (right < N) {
            int i=left+1;
            //for each interval [left, right] (starting with the first available one), we'll check whether it is a candidate: whether days[i] > days[left] and days[i] > days[right] for left < i < right.
            for (; i<right; i++) {
                if (day[i]<day[left] || day[i]<day[right]) {
                    left = i;
                    right = i+K+1;
                    break;
                }
            }
            if (i==right) {
                // if we succeed, then it's a candidate answer, and we'll check the new interval [right, right+k+1].
                // we can jump to [right, right+k+1] because we know interval [left+i, left+i+k] could not valid i is between (left, right)
                // since day[i] > day[right]
                res = Math.min(res, Math.max(day[left], day[right]));
                left = right;
                right += K+1;
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res+1;
    }

    public static void maint(String... args) {

    }
}
