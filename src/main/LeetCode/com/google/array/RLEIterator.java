package com.google.array;

class RLEIterator {
    int N, index;
    int[] A;

    public RLEIterator(int[] A) {
        this.A = A;
        N = A.length;
        index = 0;
    }

    public int next(int n) {
        while (index<N && A[index] < n) {
            n-=A[index];
            index+=2;
        }
        if (index>=N) return -1;
        A[index]-=n;
        return A[index+1];
    }

    public static void main(String... args) {
        RLEIterator rleIterator = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(rleIterator.next(2) + ", " +
                rleIterator.next(1) + ", " +
                rleIterator.next(1) + ", " +
                rleIterator.next(2));
    }
}
