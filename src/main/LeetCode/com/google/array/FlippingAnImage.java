package com.google.array;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int N=A.length;
        for (int[] row : A) {
            for (int i=0; i*2<N; i++) {
                // only when row[i]==row[N-1-i] we need both revert them.
                if (row[i]==row[N-1-i]) {
                    // when i==N-1-i, this can guarantee we only change once
                    row[i]=(row[N-1-i]^=1);
                }
            }
        }
        return A;
    }

    public static void main(String... args) {
        int[][] A = new int[][] {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        FlippingAnImage flippingAnImage = new FlippingAnImage();
        int[][] ints = flippingAnImage.flipAndInvertImage(A);
        for (int[] a : ints) {
            for (int n : a) System.out.print(n + " ");
            System.out.println();
        }
    }
}
