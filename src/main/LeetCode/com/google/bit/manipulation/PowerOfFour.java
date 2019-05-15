package com.google.bit.manipulation;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num<=0) {
            return false;
        }
        if ((num & (num-1))!=0) return false;
        // each time right shift 2 bits, because 4 is 100, so power of 4 is 1, 100, 100,00, 100,00,00
        while (num!=0) {
            if ((num&1)==1) return true;
            num>>=2;
        }
        return false;
        // ln(x^y) = yln(x), so if num is a power of 4, Math.log10(num) = y * Math.log10(4), which y is int
        /* double x = Math.log10(num) / Math.log10(4);
        return (int) x - x == 0; */
    }
}
