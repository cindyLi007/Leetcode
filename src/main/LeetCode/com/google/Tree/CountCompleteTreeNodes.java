package com.google.Tree;

/**
 * Given a complete binary tree, count_bruteForce the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level
 * are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 */
public class CountCompleteTreeNodes {
  // Time: h (height of the tree=logN) + (h-1) + (h-2)...+1 = O(h^2) = O(logN*logN)
  public int countNodes(TreeNode root) {
    if (root==null) return 0;
    int leftDepth = depthOfLeft(root);
    int rightDepth = depthOfRight(root);

    // 他们相等表示root一定是full complete tree, 因为他们一个是最左边的点可以到达的深度 一个是最右边点可以到达的深度
    if (leftDepth==rightDepth)
      // 1<<leftDepth == (int)Math.pow(2, leftDepth), but need not do int cast
      return (1<<leftDepth)-1;

    return countNodes(root.left) + countNodes(root.right) + 1;
  }

  public int depthOfLeft(TreeNode root) {
    int depth=0;
    while (root!=null) {
      depth++;
      root=root.left;
    }
    return depth;
  }

  public int depthOfRight(TreeNode root) {
    int depth=0;
    while (root!=null) {
      depth++;
      root=root.right;
    }
    return depth;
  }
}
