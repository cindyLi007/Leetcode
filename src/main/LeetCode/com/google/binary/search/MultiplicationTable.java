package com.google.binary.search;

public class MultiplicationTable {
    int r, c;
    public int findKthNumber(int m, int n, int k) {
        // each time remove (m+n-1) item
        if (m*n==k) return m*n;
        r = m; c = n;
        while (m>0 && n>0) {
            int count = m+n-1;
            if (k<=count) {
                return search(r-m, c-n, k);
            } else {
                k-=(m+n-1);
                m--; n--;
            }
        }
        return -1;
    }

    private int search(int i, int j, int k) {
        int m = i, n = j;
        if (k==1) return (i+1) * (j+1);
        k--;
        while (i<r && j<c) {
            int v1 = value(i+1, n), v2 = value(m, j+1);
            k--;
            if (v1<v2) {
                i++;
                if (k==0) return v1;
            } else {
                j++;
                if (k==0) return v2;
            }
        }
        return -1;
    }

    private int value(int x, int y) {
        if (x==r || y==c) return Integer.MAX_VALUE;
        return (x+1) * (y+1);
    }

    public static void main(String... args) {
        MultiplicationTable table = new MultiplicationTable();
        int kthNumber = table.findKthNumber(2, 3, 5);
        System.out.println(kthNumber);
    }
}
