package com.google.dp;

/**
 * Leetcode 837 Alice starts with 0 points, and draws numbers while she has less than K points.
 * During each draw, she gains an integer number of points randomly from the range [1, W]
 * Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
 */
public class New21Game {

    // This method will have TLE Problem, but it helps to understand the question
    public static double new21Game_TLE(int N, int K, int W) {
        // since we will stop when we reach K or greater, the max value is K-1+W (W is the max value for single draw
        int max = K-1+W;
        if (N>=max) return 1.0;
        double[] dp = new double[max+1];
        // base case
        dp[0]=1.0;

        // from value 1 to max, calculate the prob
        for (int i=1; i<=max; i++) {
            // we need sum all probs for this time draw from 1, to W
            for (int j=1; j<=W; j++) {
                // dp[i] is based on previous draw which (i-j) >=0, i-j==0 means we draw nothing, so no previous conditional prob
                // if (i-j) > K, we will stop drawing, no chance to draw this time
                if (i-j>=0 && i-j<K){
                    dp[i] += dp[i-j]/W;
                }
            }
        }
        double res = 0.0;
        // to calculate the prob which is N or less, we know the final answer is in [K, K-1+W], so should from K to N, sum all probs
        // Note, SHOULD NOT FROM 1, that is because final value could not less than K
        for (int i=K; i<=N; i++) res+=dp[i];
        return res;
    }

    // keep a sliding window to record sum of previous W prob
    // Time: O(N), Space: O(N)
    public static double new21Game(int N, int K, int W) {
        if (K==0 || N>=K-1+W) return 1.0;
        // dp[i]: probability of get points i, and from previous method, we can see it is sum(last W dp values) / W
        double[] dp = new double[N+1];
        // first we set wSum == 1.0, important,
        double wSum = 1.0, res = 0.0;
        dp[0]=1.0;
        for (int i=1; i<=N; i++) {
            dp[i] = wSum/W;
            // only when i<k we count it for next time useful prob
            if (i<K) wSum += dp[i];
            // if i>=K, we count it as part of the final answer
            else res+= dp[i];
            if (i>=W)
                wSum -= dp[i-W];
        }
        return res;
    }

    public static void main(String... args) {
        System.out.println(new21Game(10, 1, 10)); // should be 1.000
        System.out.println(new21Game(6, 1, 10)); // should be 0.6000
        System.out.println(new21Game(21, 17, 10)); // should be 0.73278
    }
}
