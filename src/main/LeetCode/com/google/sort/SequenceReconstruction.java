package com.google.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 444. Sequence Reconstruction
/*
  Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
  How to check only one order? queue.size() should always be one, then only one element at a time has indegree to be 0, so you only have one choice
 */
public class SequenceReconstruction {

    // Time: O(V+E), Space: O(V+E)
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int N = org.length;
        // corner case
        if (checkEmpty(seqs)) return N==0;

        List<Integer>[] graph = (List<Integer>[])new List[N+1];
        int[] inDegree = new int[N+1];
        for (int i=1; i<=N; i++) graph[i]=new ArrayList<>();

        // build up graph and every vertex's inDegree
        // Time: O(E)
        for (List<Integer> edges : seqs) {
            int i=0;
            // corner case
            if (edges.size()==1 && edges.get(0)>N) return false;

            while (i<edges.size()-1) {
                int v1=edges.get(i), v2=edges.get(i+1);
                // corner case
                if (v1<=0 || v2<=0 || v1>N || v2>N) return false;

                inDegree[v2]++;
                graph[v1].add(v2);
                i++;
            }
        }

        // Time: O(V)
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            if (inDegree[i]==0) queue.add(i);
        }

        // Time: O(V+E)
        while (!queue.isEmpty()) {
            // every time we should only have one start point (inDegree==0) so we can only choose this point
            if (queue.size()>1) return false;

            N--;
            int cur = queue.poll();
            List<Integer> neighbors = graph[cur];
            for (int i : neighbors) {
                inDegree[i]--;
                if (inDegree[i]==0) queue.offer(i);
            }
        }
        // N==0 means we cover all vertex in the graph
        return N==0;
    }

    private boolean checkEmpty(List<List<Integer>> list) {
        if (list.size()==0) return true;
        for (List<Integer> l : list) {
            if (l.size()>0) return false;
        }
        return true;
    }
}
