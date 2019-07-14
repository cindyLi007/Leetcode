package com.google.recursive;

public class KthGrammar {
    public int kthGrammar(int N, int K) {
        String s = Integer.toBinaryString(row(N));
        return s.charAt(K-1) - '0';
    }

    private int row(int N) {
        if (N==1) return 0;
        int left = row(N-1);
        int shift = 1<<(N-2);

        int i = left << shift;
        int i1 = left ^ 1;
        return i | i1;

    }

    public static void main(String... args) {
        KthGrammar kthGrammar = new KthGrammar();
        int res = kthGrammar.kthGrammar(2, 2);
        System.out.println(res);

    }
}
