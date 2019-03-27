package com.google.math;

/**
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public boolean isUgly_Recursive(int num) {
        if (num<=0) {
            return false;
        }
        if (num==1 || num==5 || num==3 || num==2) {
            return true;
        }
        if (num%5==0) return isUgly_Recursive(num/5);
        if (num%3==0) return isUgly_Recursive(num/3);
        if (num%2==0) return isUgly_Recursive(num/2);
        return false;
    }
}
