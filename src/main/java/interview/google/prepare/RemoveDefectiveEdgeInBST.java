package interview.google.prepare;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree, where an arbitrary node has 2 parents i.e two nodes in the tree have the same child. Identify
 * the defective node and remove an extra edge to fix the tree.
 * Follow-up 1: What if the tree is a BST? Answer: we could not arbit
 * Follow-up 2: Wha‍‌‌‌‌‌‍‍‌‌‍‌‌‍‌‌‌‍‌‌t if the tree is an N-ary tree?
 */
public class RemoveDefectiveEdgeInBST {

  public void remove(TreeNode root) {
    if (root==null) return;
    Set<TreeNode> visited = new HashSet<>();
    traverse(root, visited);
  }

  private boolean traverse(TreeNode node, Set<TreeNode> visited) {
    if (!visited.add(node)) {
      return true;
    }
    if (node.left==null && node.right==null) return false;
    if (node.left!=null) {
      if (traverse(node.left, visited)) node.left = null;
    }
    if (node.right!=null) {
      if (traverse(node.right, visited)) node.right = null;
    }
    return false;
  }

  public void removeBST(TreeNode root) {
    if (root==null) return;
    traverse(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }

  private boolean traverse(TreeNode root, int upperBound, int lowerBound) {
    if (root.left==null && root.right==null) return false;
    if (root.left!=null) {
      if (root.left.val > root.val || root.left.val < lowerBound) {
        root.left = null;
        return true;
      }
      traverse(root.left, root.val, lowerBound);
    }
    if (root.right!=null) {
      if (root.right.val < root.val || root.right.val > upperBound) {
        root.right = null;
        return true;
      }
      traverse(root.right, upperBound, root.val);
    }
    return false;
  }

  public static void inorder(TreeNode root) {
    System.out.print(root.val + ", ");
    if (root.left != null) inorder(root.left);
    if (root.right!=null) inorder(root.right);
  }

  public static void main(String... args) {
    TreeNode root = new TreeNode(6, null, null);
    TreeNode node = new TreeNode(5, null, null);
    TreeNode left = new TreeNode(4, new TreeNode(2, null, null), node);
    TreeNode right = new TreeNode(13, node, new TreeNode(22, null, null));
    root.left = left; root.right = right;
    inorder(root);
    System.out.println("**************");
    RemoveDefectiveEdgeInBST removeDefectiveEdgeInBST = new RemoveDefectiveEdgeInBST();
    removeDefectiveEdgeInBST.removeBST(root);
//    removeDefectiveEdgeInBST.remove(root);
    inorder(root);

  }

}
