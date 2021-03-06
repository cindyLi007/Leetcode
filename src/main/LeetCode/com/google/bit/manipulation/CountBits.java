package com.google.bit.manipulation;

/**
 * Created by ychang on 5/13/2018.
 * <p>
 * Leetcode 338
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                // since a number mod 2 is 0 means the most right digit is 0, so we can use the number of (num>>1)
                // for example 1110, >> is 111, # of 1 is same.
                res[i] = res[i / 2];
            } else {
                // a number mod 2 is 1 means the most right digit is 1, so we can use the number of (num>> 1) + 1
                // for example, 1111, >> is 111, # of 1 is (# of 111 + 1)
                res[i] = res[i / 2] + 1;
            }
        }
        return res;
    }
}
