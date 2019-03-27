package com.google.recursive;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path
 * may or may not pass through the root.
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * Example 1:
 * Input:
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output: 2
 * Example 2:
 * Input:
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output: 2
 */
public class LongestUniValuePath {
    // use global var to hold the current max path, if recursion back track to root node, res is final result
    int res;

    // Time: O(N), Space(h) for recursion
    public int longestUniValuePath(TreeNode treeNode) {
        res=0;
        longest(treeNode);
        return res;
    }

    // return is the longest path extend from this root node
    private int longest(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLongestPath = longest(root.left);
        int rightLongestPath = longest(root.right);
        int leftPathToRoot = 0, rightPathToRoot = 0;
        if (root.left!=null && root.left.val == root.val) {
            leftPathToRoot = leftLongestPath + 1;
        }
        if (root.right!=null && root.right.val == root.val) {
            rightPathToRoot = rightLongestPath + 1;
        }
        // left/right PathToRoot hold the value which max path extend from root
        // if root.val==left.val and/or root.val==righ.val, this value will be >=1, sum of them will be the path
        // from left+root+right
        res = Math.max(res, leftPathToRoot + rightPathToRoot);
        return Math.max(leftPathToRoot, rightPathToRoot);
    }
}
