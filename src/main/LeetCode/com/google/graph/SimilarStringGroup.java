package com.google.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarStringGroup {
    // Time: O(N*N*L), Space: O(V)
    public int numSimilarGroups(String[] A) {
        // build Graph, this graph is undirect, which means if s1 is similar to s2, s2 must be similar to s1,
        // so for each vertex, must check all other vertice. Otherwise, for ex. s1 - s9, s2 - s9, but s1 is not similar
        // to s2, s1 and s2 should be in same group through s9, but since edges are one-direction, we will miss the
        // connection between s1 and s2
        Map<String, Vertex> G = new HashMap<>();
        // N*N*len of String
        for (int i=0; i<A.length; i++) {
            G.put(A[i], buildGraph(A, i));
        }

        int group=0;
        for (Vertex v : G.values()) {
            if (v.visited==0) {
                dfs(v, G);
                group++;
            }
        }
        return group;
    }

    private void dfs(Vertex v, Map<String, Vertex> G) {
        v.visited=1;
        for (String n : v.neighbors) {
            if (G.get(n).visited == 0) {
                dfs(G.get(n), G);
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {
        int count=0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(i)) {
                count++;
            }
            if (count>2) return false;
        }
        return true;
    }

    private Vertex buildGraph(String[] A, int idx) {
        Vertex v = new Vertex(A[idx]);
        for (int i=0; i<A.length; i++) {
            if (i==idx) continue;
            if (isSimilar(A[i], A[idx])) {
                v.neighbors.add(A[i]);
            }
        }
        return v;
    }

    private class Vertex {
        String label;
        List<String> neighbors;
        int visited;

        Vertex(String name) {
            label = name;
            neighbors = new ArrayList<>();
        }
    }
}
