package com.google.minimax;

public class GuessNumHighOrLowerII {
    // Time: O(N^3), Space: O(N^2)
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return get(1, n, dp);
    }

    private int get(int start, int end, int[][] dp){
        if (start>=end) return 0;
        if (start+1==end) return start;

        int res = Integer.MAX_VALUE;
        if (dp[start][end]==0) {
            for (int x=start+1; x<end; x++) {
                // for 每次的每一种选择都找后面最坏的可能(minimize result)和它combine(这相当于假设对手总能给我对我最不利的情况）
                // 然后从这所有的可能中选一种最好的选择(maximize result)
                int cost = x + Math.max(get(start, x-1, dp), get(x+1, end, dp));
                res = Math.min(res, cost);
            }
        }
        dp[start][end] = res;
        return dp[start][end];
    }

    public static void main(String... args) {
        GuessNumHighOrLowerII guessNumHighOrLowerII = new GuessNumHighOrLowerII();
        int moneyAmount = guessNumHighOrLowerII.getMoneyAmount(7);
        System.out.println(moneyAmount);
        int moneyAmount_bottomUp = getMoneyAmount_bottomUp(1);
        System.out.println(moneyAmount_bottomUp);
    }

    public static int getMoneyAmount_bottomUp(int n) {
        int[][] dp = new int[n + 1][n + 1];
        // if n==1; dp[1][1]=0
        for (int j = 2; j <= n; j++) {
            dp[j - 1][j] = dp[j - 2][j] = j - 1;
            for (int i = j - 3; i > 0; i--) {
                int temp = Integer.MAX_VALUE;
                for (int x = i + 1; x < j; x++) {
                    int t = x + Math.max(dp[i][x - 1], dp[x + 1][j]);
                    temp = Math.min(temp, t);
                }
                dp[i][j] = temp;
            }
        }
        return dp[1][n];
    }
}
