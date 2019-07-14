package com.google.dp;

public class PushDominoes {
    public static String pushDominoes(String dominoes) {
        char[] dc = dominoes.toCharArray();
        int N=dc.length;
        int[] dist = new int[N];
        // first round, record R from l to r
        int idx=N;
        for (int i=0; i<N; i++) {
            if (dc[i]=='L' || dc[i]=='R') {
                idx = dc[i]=='R' ? i : N;
            } else { // dc[i] must be '.'
                dist[i] = idx!=N ? i-idx : 0;
            }
        }
        // second round, record L from r to l
        idx=N;
        for (int i=N-1; i>=0; i--) {
            if (dc[i]=='L' || dc[i]=='R') {
                idx = dc[i]=='L' ? i : N;
            } else { // dc[i] must be '.'
                if (idx==N) { // no L in right
                    if (dist[i]!=0) dc[i]='R';
                } else {
                    if (dist[i]==0) dc[i]='L';
                    else {
                        int d = dist[i]-(idx-i);
                        if (d!=0) dc[i]= (d>0 ? 'L' : 'R');
                    }
                }
            }
        }
        return String.valueOf(dc);
    }

    public static void main(String... args) {
        String s = pushDominoes(".L.R...LR..L..");
        System.out.println(s);
    }
}