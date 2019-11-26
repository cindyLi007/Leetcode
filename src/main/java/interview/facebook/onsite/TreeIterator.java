package interview.facebook.onsite;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 * Witer a iterator to in-order iterator a tree, for ex
 *         1
 *      2    4
 *    5  6  7
 *      8
 * after we create a Tree iterator, hasNext should return true / false, and next() should return the value or throw an exception
 */
public class TreeIterator implements Iterator {
  Stack<TreeNode> stack;

  public TreeIterator(TreeNode node) {
    stack = new Stack<>();
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  // O(H), H = lgN
  public Integer next() {
    if (stack.isEmpty()) throw new EmptyStackException();
    TreeNode res = stack.pop();
    TreeNode node = res.right;
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
    return res.val;
  }

  public static void main(String... args) {
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null),
        new TreeNode(5, null, new TreeNode(6, null, null))), new TreeNode(3, null, new TreeNode(7, null, null)));
    TreeIterator treeIterator = new TreeIterator(root);
    while (treeIterator.hasNext()) {
      System.out.print(treeIterator.next() + ", ");
    }
  }
}

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int v, TreeNode left, TreeNode right) {
    val = v;
    this.left = left;
    this.right = right;
  }
}
