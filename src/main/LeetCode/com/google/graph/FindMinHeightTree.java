package com.google.graph;

import java.util.*;

public class FindMinHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList();
            for (Integer l : leaves) {
                int node = graph.get(l).get(0);
                graph.get(node).remove(l);
                if (graph.get(node).size() == 1) newLeaves.add(node);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
