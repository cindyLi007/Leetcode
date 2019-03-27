package com.google.bit.manipulation;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        // power of 2 can only have 1 bit set, if after remove the most left set bit
        // the number == 0, that means there is only one bit set, so it is power of 2
        return (n & (n-1)) == 0;
    }
}
