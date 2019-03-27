package com.google.bit.manipulation;

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
