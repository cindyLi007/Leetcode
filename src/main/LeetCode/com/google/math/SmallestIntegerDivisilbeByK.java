package com.google.math;

/**
 * 1015. Smallest Integer Divisible by K
 * Given a positive integer K, you need find the smallest positive integer N such that N is divisible by K, and N only
 * contains the digit 1.
 *
 * Return the length of N.  If there is no such N, return -1.
 */
public class SmallestIntegerDivisilbeByK {
    public int smallestRepunitDivByK(int K) {
        if (K%2==0 || K%5==0) return -1;
        int a = 1, count=1;
        // to prevent overflow, a = (a*10+1) % K instead of (a*10+1), that is because we does not care the value of (a*10+1),
        // we only care whether (a*10+1)%K==0 and (a*10+1) % K = (((a%K) * 10)+1) % K.
        // for ex. 28/3 = 9*3 remainder is 1, 281%3=[(9*3+1)*10 + 1]%3=270%3+(10+1)%3=11%3=(1*10+1)%3
        while (a%K!=0) {
            a = (a*10 + 1)%K;
            count++;
        }
        return count;
    }
}
