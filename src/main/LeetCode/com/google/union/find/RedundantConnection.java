package com.google.union.find;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] ids = new int[N+1];
        for (int i=1; i<=N; i++) ids[i]=i;
        for (int[] edge : edges) {
            int p = find(edge[0], ids);
            int q = find(edge[1], ids);
            if (p==q) return edge;
            ids[p]=q;
        }
        return new int[]{0, 0};
    }

    private int find(int n, int[] ids) {
        while (n!=ids[n]) {
            ids[n]=ids[ids[n]];
            n=ids[n];
        }
        return n;
    }

    public static void main(String... args) {
        RedundantConnection redundantConnection = new RedundantConnection();
        int[][] nodes = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[] res = redundantConnection.findRedundantConnection(nodes);
        System.out.println(res[0] + " " + res[1]);
    }
}
