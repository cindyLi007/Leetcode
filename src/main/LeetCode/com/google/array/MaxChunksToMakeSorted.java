package com.google.array;

public class MaxChunksToMakeSorted {
    public static int maxChunksToSorted(int[] arr) {
        int N=arr.length;
        int[] maxA = new int[N], minA = new int[N];
        int max=arr[0];
        for (int i=0; i<N; i++) {
            maxA[i]=max;
            max=Math.max(max, arr[i]);
        }
        int min=arr[N-1];
        for (int i=N-1; i>=0; i--) {
            minA[i]=min;
            min=Math.min(min, arr[i]);
        }
        int res=1;
        for (int i=1; i<N; i++) {
            if (arr[i]>=maxA[i] && maxA[i]<=minA[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String... args) {
        int shouldOne = maxChunksToSorted(new int[]{5, 4, 3, 2, 1});
       int should4 = maxChunksToSorted(new int[]{2, 1, 3, 4, 4});
        int should3 = maxChunksToSorted(new int[]{1, 0, 1, 3, 2});
        System.out.println(should3);
//        System.out.println(should4);
    }
}
