package com.google.string;

/**
 Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return true if and only
 if for every integer X from 1 to N, the binary representation of X is a substring of S.
 */
public class BinaryStringWithSubstring {
    public boolean queryString(String S, int N) {
        // 9 is 1001, 1000, 111, 110, 101, 100, 11, 10, 1
        for (int i=N; i>N/2; i--) {
            // useful built-in Integer API, return only till the first left most 1
            String s = Integer.toBinaryString(i);
            if (!S.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
