package com.google.array;

public class DuplicateZero {
    public static void duplicateZeros(int[] arr) {
        int N = arr.length;
        int count=0;
        for (int i=0; i<N; i++) {
            if (arr[i]==0) {
                count++;
            }
        }
        if (count==0 || count==1 && arr[N-1]==0) return;
        int len = N+count;
        for (int i=N-1, j=len-1; i>=0 && j>=0; i--, j--) {
            if (arr[i]!=0) {
                if (j<N) arr[j]=arr[i];
            } else {
                if (j<N) arr[j]=0;
                j--;
                if (j<N) arr[j]=0;
            }
        }
    }

    public static void main(String... args) {
        duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
    }
}
