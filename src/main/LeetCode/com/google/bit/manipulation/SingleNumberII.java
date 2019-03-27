package com.google.bit.manipulation;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
    // Time: (N * M), M is the number of bit in an Integer
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i=0; i<32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >>>i ) & 1;
            }
            res += (sum % 3) << i;
        }
        return res;
    }
}
