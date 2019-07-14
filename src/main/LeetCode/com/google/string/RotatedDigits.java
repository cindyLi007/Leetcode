package com.google.string;

public class RotatedDigits {
    public int rotatedDigits(int N) {
        int res=0;
        for (int i=1; i<=N; i++) {
            if (good(i)) res++;
        }
        return res;
    }

    private boolean good(int n) {
        int count=0;
        while (n>0) {
            int t = n%10;
            if (t==3 || t==4 || t==7) return false;
            if (t==2 || t==5 || t==6 || t==9) count++;
            n/=10;
        }
        return count>0;
    }

    public static void main(String... args) {
        RotatedDigits rotatedDigits = new RotatedDigits();
        int res = rotatedDigits.rotatedDigits(10);
    }
}
