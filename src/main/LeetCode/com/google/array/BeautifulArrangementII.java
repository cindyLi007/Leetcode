package com.google.array;

public class BeautifulArrangementII {
    public static int[] constructArray(int N, int k) {
        int[] res = new int[N];
        int idx=0;
        for (int i=0; i<(N-k-1); i++)
            res[idx++]=i+1;
        for (int i=0; i<=k; i++) {
            res[idx++]=(i%2==0) ? (N-k+i/2) : (N-i/2);
        }
        return res;
    }

    public static void main(String... args) {
        int[] res = constructArray(3, 2);
        for (int n : res) {
            System.out.print(n + ", ");
        }
    }
}
