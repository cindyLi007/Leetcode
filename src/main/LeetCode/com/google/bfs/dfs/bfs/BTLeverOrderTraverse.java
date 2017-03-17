package com.google.bfs.dfs.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ychang on 3/1/2017.
 */
public class BTLeverOrderTraverse {
  /**
   * beat 41%
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList();
    if (root==null) return res;
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size=queue.size();
      List<Integer> level = new LinkedList();
      for (int i=0; i<size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left!=null) queue.offer(node.left);
        if (node.right!=null) queue.offer(node.right);
      }
      res.add(level);
    }
    return res;
  }
}
