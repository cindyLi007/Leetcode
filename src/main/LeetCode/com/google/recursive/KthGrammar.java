package com.google.recursive;

public class KthGrammar {
    public int kthGrammar(int N, int K) {
        return helper(--N, --K);
    }

    private int helper(int N, int K) {
        if (N<=1) return K==0 ? 0 : 1;
        int len = (int)Math.pow(2, N);
        if (K<len/2) return helper(N-1, K);
        return helper(N-1, K-len/2) ^ 1;
    }

    public static void main(String... args) {
        KthGrammar kthGrammar = new KthGrammar();
        int N = 4, K = 5;
        int res = kthGrammar.kthGrammar(N, K);
        System.out.println(N + ", " + K + "-> " + res);
        N=1; K=1;
        System.out.println(N + ", " + K + "-> " + kthGrammar.kthGrammar(N, K));
        N=2; K=1;
        System.out.println(N + ", " + K + "-> " + kthGrammar.kthGrammar(N, K));
        N=2; K=2;
        System.out.println(N + ", " + K + "-> " + kthGrammar.kthGrammar(N, K));
        N=4; K=6;
        System.out.println(N + ", " + K + "-> " + kthGrammar.kthGrammar(N, K));
        N=4; K=7;
        System.out.println(N + ", " + K + "-> " + kthGrammar.kthGrammar(N, K));
        N=4; K=8;
        System.out.println(N + ", " + K + "-> " + kthGrammar.kthGrammar(N, K));
        N=4; K=3;
        System.out.println(N + ", " + K + "-> " + kthGrammar.kthGrammar(N, K));

    }
}
