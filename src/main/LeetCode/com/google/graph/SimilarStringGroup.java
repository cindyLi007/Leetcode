package com.google.graph;

import java.util.*;

public class SimilarStringGroup {
    // Time: O(N*N*L), Space: O(V)
    public int numSimilarGroups(String[] A) {
        int count = 0;
        BitSet visited = new BitSet(A.length);
        for (int i = 0; i < A.length; i++) {
            if (visited.get(i)) continue;
            String s = A[i];
            dfs(A, i, visited);
            count++;
        }
        return count;
    }

    private void dfs(String[] A, int start, BitSet visited) {
        visited.set(start);
        // NOTICE: i must begin from 0, not start + 1, for ex. s0 - s9, s9 - s2, but s0 is not similar s2, if we begin
        // from start+1, we will misss s2 which should be in the same group as s0xcel
        for (int i = 0; i < A.length; i++) {
            if (visited.get(i)) continue;
            if (isSimilar(A[start], A[i])) {
                dfs(A, i, visited);
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) res++;
            if (res > 2) return false;
        }
        return true;
    }
}
