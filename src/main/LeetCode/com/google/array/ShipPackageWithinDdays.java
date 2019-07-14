package com.google.array;

public class ShipPackageWithinDdays {
    // Time; O(N * lgM), M is the distance from max to sum
    public static int shipWithinDays(int[] weights, int D) {
        // find the possible min
        int sum=0, N=weights.length, max=0;
        for (int n : weights) {
            max=Math.max(max, n);
            sum+=n;
        }
        max = Math.max(max, sum%D==0 ? sum/D : sum/D+1);
        if (isValid(weights, D, max)) return max;
        int s=max, e=sum;
        // when s==e, break;
        while (s < e) {
            int m = s+(e-s)/2;
            if (isValid(weights, D, m)) {
                e=m;
            } else {
                s=m+1;
            }
        }
        return s;
    }

    // if each interval should be <= v and after run out of weights, the # of
    // intervals <= D, return true; otherwise return false;
    // loop through the array, if sum > v, reset sum to current v, and increment count_bruteForce. set count_bruteForce init to 1, because
    // when we encounter sum > v, that means we need split array.
    // O(N)
    private static boolean isValid(int[] weights, int D, int v) {
        int count=1, sum=0;
        for (int n : weights) {
            sum+=n;
            if (sum>v) {
                sum=n;
                count++;
                if (count>D) return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        int res = shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        System.out.println(res);
    }
}
