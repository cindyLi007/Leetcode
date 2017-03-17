package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/27/2017.
 * The nature of this problem is in-order traverse this BST, and find the 2 swapped nodes, for example,
 * [1, 2, 3, 4, 5, 6] swap 2&5 becomes to [1, 5, 3, 4, 2, 6], 1st node > next node, 2nd node < prev node, based on this
 * observation, during our in-order traverse, we just need record prev val, and compare it with current value
 */
public class RecoverBST {
  TreeNode firstNode, secondNode;
  TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

  public void recoverTree(TreeNode root) {
    traverse(root);
    /**
     * we need NOT switch 2 TreeNode, just reset their values
     */
    int temp = firstNode.val;
    firstNode.val = secondNode.val;
    secondNode.val = temp;
  }

  private void traverse(TreeNode root) {
    if (root==null)
      return;
    traverse(root.left);
    /**
     * based on above example, we first find 5>3, so firstNode=5, secondNode=3, then we find 4>2, so we overwrite
     * secondNode=2, we could not replace line 37 to 40 as
     * if (prevNode.val>root.val) {
     *  if (firstNode==null) firstNode=prevNode;
     *  else secondNode=root;
     * }
     * because this code does NOT work for adjacent nodes. For example, if we swap as [1, 2, 4, 3, 5, 6], prevNode is 4,
     * root is 3, we need set firstNode and secondNode in the meantime, which is only following code can do it
     */
    if (firstNode==null && prevNode.val>root.val)
      firstNode = prevNode;
    if (firstNode!=null && prevNode.val>root.val)
      secondNode = root;
    prevNode = root;
    traverse(root.right);
  }
}
