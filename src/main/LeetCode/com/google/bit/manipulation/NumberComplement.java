package com.google.bit.manipulation;

/**
 * Leetcode 476 https://leetcode.com/problems/number-complement/
 */
public class NumberComplement {
    public static int findComplement(int num) {
        // could not num ^ 0xFFFF, cause all leading zero ^ 1 will render 1
        // must find the highest set bit of num and create a mask only from that bit
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }

    public static void main(String... args) {
        int complement = findComplement(48);
        System.out.println(complement);
    }
}
