package com.google.math;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <=0) return false;
        // Notice, could not use Math.log(n), do NOT know the reason
        // Math.log10(x) / Math.log10(3) = log3 x, but Math does not have log(a, b)
        double I = Math.log10(n) / Math.log10(3);
        return (int)I - I == 0;
    }

    public static void main(String... args) {
        PowerOfThree powerOfThree = new PowerOfThree();

        boolean res = powerOfThree.isPowerOfThree(243);

        System.out.println(res);
    }
}
