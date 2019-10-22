package com.google.minimax;

public class PredictWinner {
    public boolean predictTheWinner(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][N];
        return max(nums, 0, N-1, dp) > 0;
    }

    private int max(int[] nums, int start, int end, int[][] dp) {
        if (dp[start][end]!=0)
            return dp[start][end];
        if (start==end)
            return nums[start];
        if (start+1==end)
            return Math.max(nums[start], nums[end]) - Math.max(nums[start], nums[end]);

        int v1 = nums[end] - max(nums, start, end-1, dp);
        int v2 = nums[start] - max(nums, start+1, end, dp);
        dp[start][end]=Math.max(v1, v2);
        return dp[start][end];
    }

    public static void main(String... args) {
        PredictWinner predictWinner = new PredictWinner();
        System.out.println(predictWinner.predictTheWinner(new int[]{1, 1, 1}));
    }
}
