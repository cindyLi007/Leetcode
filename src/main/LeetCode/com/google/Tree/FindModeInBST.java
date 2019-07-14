package com.google.Tree;

// Time: O(N), Space: O(1)
public class FindModeInBST {
    int modeCount = 0;
    int[] res;
    int max = 0;
    int curCount = 0;
    TreeNode prev;

    public int[] findMode(TreeNode root) {
        inorder(root);
        res = new int[modeCount];
        modeCount = 0;
        curCount = 0;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && root.val != prev.val) {
            curCount = 0;
        }
        curCount++;
        prev = root;
        if (curCount > max) {
            modeCount = 1;
            max = curCount;
        } else if (curCount == max) {
            modeCount++;
            if (res != null) {
                res[modeCount - 1] = root.val;
            }
        }
        inorder(root.right);
    }
}
