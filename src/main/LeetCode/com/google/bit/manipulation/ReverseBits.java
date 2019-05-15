package com.google.bit.manipulation;

/**
 * Leetcode 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 * Follow up, if this function is called many times, how would you optimize it
 * We can divide an int into 4 bytes, and reverse each byte then combine into an int. For each byte, we can use cache to improve performance.
 */
public class ReverseBits {
    // Reverse bits of a given 32 bits unsigned integer.
    public int reverseBits(int n) {
        for (int i=0, j=31; i<j; i++, j--) {
            if ((n>>>i & 1) == (n>>>j & 1)) // first compare 2 bits, if they are same, we need not swap them
                continue;
            // NOTICE: we could not use 1 <<< i, leftshift can only use arithmetic leftshift, that is because
            // we need preserve sign bit
            int mask = (1<<i) | (1<<j);
            // ^ 1 means reverse
            n ^= mask;
        }
        return n;
    }
}
