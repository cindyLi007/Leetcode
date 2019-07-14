package com.google.dp;

public class New21Game {
    public static double new21Game(int N, int K, int W) {
        double p = 1.0/(double)W;
        double[] dp = new double[K+W];
        for (int i=1; i<=W; i++) dp[i]=p;
        if (check(dp, K)) {
            return calculate(dp, K, N);
        }
        while (true) {
            double[] next = new double[K+W];
            for (int i=1; i<=W+K-1; i++) {
                for (int j=1; j<=W && i+j<=W+K-1; j++) {
                    next[i+j] +=  dp[i]*1/p;
                }
            }
            dp = next;
            if (check(dp, K)) break;
        }
        return calculate(dp, K, N);
    }

    private static double calculate(double[] dp, int K, int N) {
        double res = 0;
        for (int i=K; i<=N; i++) {
            res+= dp[K];
        }
        return res;
    }

    private static boolean check(double[] dp, int K) {
        boolean b = true;
        for (int i=1; i<K; i++) {
            if (dp[i]>0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
//        double v = new21Game(10, 1, 10);
        double v = new21Game(6, 1, 10);
        System.out.println(v);
    }
}
