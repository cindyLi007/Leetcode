package com.google.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ychang on 3/19/2017.
 */
public class FindBottomLeftTreeValue {
  public int findBottomLeftValue(TreeNode root) {
    if (root.left==null && root.right==null) return root.val;
    return findBottom(root, 0).node.val;
  }

  private Result findBottom(TreeNode root, int dep) {
    if (root.left==null && root.right==null) return new Result(dep, root);
    Result left = root.left!=null ? findBottom(root.left, dep+1) : null;
    Result right = root.right!=null ? findBottom(root.right, dep+1) : null;
    if (left!=null && right!=null) {
      return left.depth>=right.depth ? left : right;
    }
    return left==null ? right : left;
  }

  class Result {
    int depth;
    TreeNode node;

    Result(int d, TreeNode n) {
      node=n;
      depth=d;
    }
  }

  /**
   * please note, Java is pass by value, so we can freely change root ref in method, outside this method, root does NOT change
   * Java pass by value means we can change the ref's value, such as array's entry, root.val, but we could not change the
   * ref.
   */
  public int findBottomLeftValue_BFS(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    while (!queue.isEmpty()) {
      root = queue.poll();
      if (root.right!=null) queue.offer(root.right);
      if (root.left!=null) queue.offer(root.left);
    }
    return root.val;
  }
}
