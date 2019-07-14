package com.google.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = (List<Integer>[])new List[n];
        for (int i=0; i<n; i++) graph[i] = new ArrayList();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (!dfs(graph, 0, visited, -1)) return false;
        for (int i=0; i<n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    private boolean dfs(List<Integer>[] graph, int i, boolean[] visited, int prev) {
        if (visited[i]) return false;
        visited[i]=true;
        for (Integer next : graph[i]) {
            if (next==prev) continue;
            if (!dfs(graph, next, visited, i)) return false;
        }
        return true;
    }

    private boolean validTree_UnionFind(int n, int[][] edges) {
        int[] id = new int[n];
        Arrays.fill(id, -1);
        for (int[] edge : edges) {
            int x = find(edge[0], id);
            int y = find(edge[1], id);
            if (x==y) return false;
            id[x]=y;
        }
        return edges.length==n-1;
    }

    private int find(int node, int[] id) {
        if (id[node]==-1) return node;
        return find(id[node], id);
    }

    public static void main(String... args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        int[][] array = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        boolean validTree = graphValidTree.validTree(5, array);
        System.out.println(validTree);
    }
}
