package com.google.array;

import java.util.TreeSet;

public class KEmptySlots {

    // Time: O(N), Space: O(N)
    public static int kEmptySlots_basedOnPos(int[] bulbs, int K) {
        int N = bulbs.length;
        int[] day = new int[N];
        for (int i=0; i<N; i++) {
            day[bulbs[i]-1]=i;
        }
        int res = Integer.MAX_VALUE;
        int left = 0, right = K+1;
        while (right < N) {
            int i=left+1;
            // for each interval [left, right] (starting with the first available one), we'll check whether it is a candidate:
            // whether days[i] > days[left] and days[i] > days[right] for left < i < right.
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

    // Time: O(N*N) Space: O(N)
    public static int kEmptySlots(int[] bulbs, int K) {
        int N = bulbs.length;
        int[] days = new int[N+1];
        for (int i=0; i<N; i++) {
            int pos = bulbs[i];
            days[pos] = 1;
            if (isValid(days, pos, K)) return i+1;
        }
        return -1;
    }

    private static boolean isValid(int[] days, int pos, int K) {
        int left = pos-K-1, right = pos+K+1;
        if (left>0 && days[left]==1) {
            for (int i=left+1; i<=pos; i++) {
                if (i==pos) return true;
                if (days[i]==1) break;
            }
        }
        if (right<days.length && days[right]==1) {
            for (int i=right-1; i>=pos; i--) {
                if (i==pos) return true;
                if (days[i]==1) return false;
            }
        }
        return false;
    }

    // Time: O(NlgN), Space: O(N)
    public int kEmptySlots_orderMap(int[] bulbs, int K) {
        int N = bulbs.length;
        TreeSet<Integer> set = new TreeSet();
        for (int i=0; i<N; i++) {
            int pos = bulbs[i], left = pos - (K+1), right = pos + (K+1);
            Integer l = set.lower(pos), r = set.higher(pos);
            if (l!=null && l == left) return i+1;
            if (r!=null && r == right) return i+1;
            set.add(pos);
        }
        return -1;
    }

    public static void main(String... args) {
        int res = kEmptySlots(new int[]{6,5,8,9,7,1,10,2,3,4}, 2);
        System.out.println(res);
    }
}
