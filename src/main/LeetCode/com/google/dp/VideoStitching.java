package com.google.dp;

public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];
        dp[0]=0; // time end at T0
        // for each dp[i], which 0<i<=T, we should find a min dp[j],
        // which 0<=j<i, there is a clip can connect j to i, and dp[j] is connect
        // connect means the clip.end >= i
        for (int i=1; i<T+1; i++) {
            dp[i]=-1;
            for (int[] c : clips) {
                if (connect(c, i)) {
                    if (dp[i]==-1 || dp[c[0]]+1 < dp[i])
                        dp[i] = dp[c[0]]+1;
                }
            }
            if (dp[i]==-1) return -1;
        }
        return dp[T];
    }


    private boolean connect(int[] c, int T) {
        int start = c[0], end = c[1];
        if (start<T && end>=T) return true;
        return false;
    }

    public static void main(String... args) {
//        int[][] clips = new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        int[][] clips = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        VideoStitching videoStitching = new VideoStitching();
        int clip = videoStitching.videoStitching(clips, 10);
        System.out.println(clip);
    }
}
