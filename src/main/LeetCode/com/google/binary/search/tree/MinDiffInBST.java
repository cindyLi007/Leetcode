package com.google.binary.search.tree;

import java.util.Stack;

public class MinDiffInBST {
    public int minDiffInBST(TreeNode root) {
        // inorder traverse, keep the precessor
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        int res = Integer.MAX_VALUE;
        while (root!=null || !stack.isEmpty()) {
            if (root==null) {
                root = stack.pop();
                if (prev != null) {
                    res = Math.min(res, root.val - prev.val);
                }
                prev = root;
                root = root.right;
            }
            else {
                stack.push(root);
                root=root.left;
            }
        }
        return res;
    }
}
