package com.google.graph;

import java.util.*;

/**
 * 802. Find Eventual Safe States
 */
public class FindEventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N=graph.length;
        boolean[] safe = new boolean[N];

        List<Set<Integer>> g = new ArrayList();
        List<Set<Integer>> r = new ArrayList();
        for (int i=0; i<N; i++) {
            g.add(new HashSet());
            r.add(new HashSet());
        }

        Queue<Integer> terminal = new LinkedList<>();
        for (int i=0; i<N; i++) {
            if (graph[i].length==0) terminal.offer(i);
            for (int n : graph[i]) {
                g.get(i).add(n);
                r.get(n).add(i);
            }
        }

        while (!terminal.isEmpty()) {
            int i = terminal.poll();
            safe[i]=true;
            for (int n : r.get(i)) {
                g.get(n).remove(i);
                if (g.get(n).size()==0) terminal.offer(n);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<N; i++) {
            if (safe[i]) res.add(i);
        }

        return res;
    }

    // utilize the cache for each node's factor, during DFS the graph, use color[] to record whether the node is safe node
    // color = 0 means not visited, color=1 means is terminal, color=2 means in a cycle
    public List<Integer> eventualSafeNodes_dfs(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> res = new ArrayList<>();

        for (int i=0; i<N; i++) {
            if (dfs(graph, i, color)) res.add(i);
        }

        return res;
    }

    private boolean dfs(int[][] graph, int idx, int[] color) {
        if (color[idx]!=0) return color[idx]==1;

        color[idx]=2;
        for (int n : graph[idx]) {
            if (!dfs(graph, n, color)) return false;
        }
        color[idx]=1;
        return true;
    }
}
