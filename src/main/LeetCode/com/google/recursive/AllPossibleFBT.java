package com.google.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFBT {
    Map<Integer, List<TreeNode>> cache = new HashMap();

    // Time: O(2^N), Space: O(2^N)
    public List<TreeNode> allPossibleFBT(int N) {
        if (!cache.containsKey(N)) {
            List<TreeNode> res = new ArrayList();
            if (N == 1) {
                res.add(new TreeNode(0));
            } else {
                for (int i = 1; i <= N - 2; i += 2) {
                    List<TreeNode> left = allPossibleFBT(i);
                    List<TreeNode> right = allPossibleFBT(N - i - 1);
                    for (TreeNode l : left) {
                        for (TreeNode r : right) {
                            TreeNode root = new TreeNode(0);
                            root.left = l;
                            root.right = r;
                            res.add(root);
                        }
                    }
                }
            }
            cache.put(N, res);
        }
        return cache.get(N);
    }

}

class TreeNode {
    TreeNode left, right;
    int val;

    TreeNode(int v) {
        val = v;
    }
}
