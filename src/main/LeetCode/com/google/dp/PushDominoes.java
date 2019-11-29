package com.google.dp;

public class PushDominoes {

    public static void main(String... args) {
        String s = pushDominoes(".L.R...LR..L..");
        System.out.println(s);
    }

    public static String pushDominoes(String dominoes) {
        char[] D = dominoes.toCharArray();
        int N = D.length;
        int[] seconds = new int[N];
        char cur = '.';
        int dist = 0;
        for (int i=0; i<N; i++) {
            char c = D[i];
            if (c=='R') {
                cur = 'R';
                dist = 0;
            } else if (c=='.') {
                if (cur == 'R') { D[i] = 'R'; seconds[i] = ++dist; }
            } else { // c == 'L' block R further
                cur = '.';
                dist = 0;
            }
        }
        cur = '.';
        dist = 0;
        for (int i=N-1; i>=0; i--) {
            char c = D[i];
            if (c=='L') {
                cur = 'L';
                dist = 1;
            } else if (c=='.') {
                if (cur == 'L') { D[i] = 'L'; dist++; }
            } else { // c = 'R'
                if (cur == 'L') {
                    if (dist < seconds[i]) {
                        D[i] = 'L';
                        dist++;
                    } else if (dist == seconds[i]) {
                        D[i] = '.';
                        cur = '.';
                    } else {
                        cur = '.';
                    }
                }
            }
        }
        return String.valueOf(D);
    }
}