package com.google.graph;

import java.util.*;

public class NumberOfConnectedComponent {
    public int countComponents(int n, int[][] edges) {
        int[] id = new int[n];
        for (int i=0; i<n; i++) id[i]=i;
        int count=n;
        for (int[] edge : edges) {
            int x = find(edge[0], id);
            int y = find(edge[1], id);

            if (x!=y) {
                count--;
                id[x]=y;
            }
        }
        return count;
    }

    private int find(int n, int[] id) {
        while (n != id[n]) {
            id[n]=id[id[n]];
            n=id[n];
        }
        return n;
    }
}
