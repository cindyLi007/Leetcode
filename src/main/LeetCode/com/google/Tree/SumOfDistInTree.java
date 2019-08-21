package com.google.Tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfDistInTree {
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        // tree is a <node, neighbors> map
        Set<Integer>[] tree = (Set<Integer>[]) new Set[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1];
            tree[v1].add(v2);
            tree[v2].add(v1);
        }

        // res is the sum of dist for each node, it also store the middle result which a node to all its subnodes sum of distance
        int[] res = new int[N];
        // count store count of subtree nodes (include node itself)
        int[] count = new int[N];

        // arbitrary set 0 is the entire tree's root
        dfs(0, tree, res, count, -1);
        dfs2(0, tree, res, count, N, -1);
        return res;
    }

    private static void dfs2(int root, Set<Integer>[] tree, int[] res, int[] count, int N, int parent) {
        for (Integer child : tree[root]) {
            if (child==parent) continue;

            // for node "root", compare to node "parent", it is 1 more closer to all its own descendants, one 1 more further to
            // all parents descendants which is not in its own subtree. For first part, we use (-count[root])) and for the 2nd
            // part, we use (N - count[child])
            res[child] = res[root] - count[child] + (N - count[child]);
            dfs2(child, tree, res, count, N, root);
        }
    }

    private static void dfs(int root, Set<Integer>[] tree, int[] res, int[] count, int from) {
        for (Integer child : tree[root]) {
            if (child == from) continue;
            dfs(child, tree, res, count, root);

            // as the parent of node "child", since this a tree structure, these is no loop, and from one node to the other node, there is
            // only ONE path, so we can safely depend on a child's result to count a parent's result, no need to compare with other's child's result
            // the root node's path to all nodes which is descendants of node "child" must pass node "child", and the distance is 1,
            // that is the reason we add "count[child]" and res[child] is the sum of node "child" to all its descendants nodes distance
            res[root] += count[child] + res[child];
            count[root] += count[child];
        }
        count[root]++;
    }

    public static void main(String... args) {
        int[] sum = sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
        Arrays.stream(sum).boxed().forEach(o-> System.out.print(o + ", "));
    }
}
