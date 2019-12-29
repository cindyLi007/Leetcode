package com.google.binary.search.tree;

/**
 * Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree
 * has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.
 * It's not necessarily the case that the tree contains a node with value V.
 *
 * Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original tree,
 * if they are both in the same subtree after the split, then node C should still have the parent P.
 *
 * You should output the root TreeNode of both subtrees after splitting, in any order.
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3,5,7], V = 2
 * Output: [[2,1],[4,3,6,null,null,5,7]]
 * Explanation:
 * Note that root, output[0], and output[1] are TreeNode objects, not arrays.
 * The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
 *
 *           4
 *         /   \
 *       2      6
 *      / \    / \
 *     1   3  5   7
 *
 * while the diagrams for the outputs are:
 *
 *           4
 *         /   \
 *       3      6      and    2
 *             / \           /
 *            5   7         1
 */
public class SplitBST {

    // return an array with 2 TreeNode, 1st is small substree which is <= target, 2nd is big subtree which is > target
    // Time: O(h), Space: O(h)
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        TreeNode big = null, small = null;
        if (root.val > target) {
            big = root;
            TreeNode[] fromLeft = splitBST(root.left, target);
            root.left = fromLeft[1];
            small = fromLeft[0];
        } else if (root.val == target) {
            big = root.right;
            small = root;
        } else { // root.val < target
            small = root;
            TreeNode[] fromRight = splitBST(root.right, target);
            root.right = fromRight[0];
            big = fromRight[1];
        }
        return new TreeNode[]{small, big};
    }
}
