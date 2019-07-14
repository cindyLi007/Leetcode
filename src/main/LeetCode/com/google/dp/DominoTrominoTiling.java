package com.google.dp;

public class DominoTrominoTiling {
    public static int numTilings(int N) {
        int[] dp = new int[Math.max(N+1, 4)];
        if (N==0) return 0;
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;
        if (N<=3) return dp[N];
        int M = (int)Math.pow(10, 9) + 7;
        System.out.println(M);
        // dp[n-1] and dp[n-2] have one way to transform to dp[n]
        // dp[n-3] ... dp[0] have 2 way to transfrom to dp[n]
        // dp[n] = dp[n-1]+dp[n-2]+2*(dp[n-3]+dp[n-4]...+dp[0])
        // dp[n] = dp[n-1]+dp[n-3]+dp[n-2]+dp[n-3]+2*(dp[n-4]...dp[0])
        // dp[n] = dp[n-1]+dp[n-3]+dp[n-1]
        // dp[n] = 2*dp[n-1]+dp[n-3] for ex dp[4]=2*dp[3]+dp[1]=11
        for (int i=4; i<=N; i++) {
            dp[i]=(2*dp[i-1]%M+dp[i-3]%M)%M;
        }
        return dp[N];
    }

    public static void main(String... args) {
        int res = numTilings(30);
        System.out.println(res);
    }
}
