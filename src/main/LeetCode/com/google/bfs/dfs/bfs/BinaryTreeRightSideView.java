package com.google.bfs.dfs.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ychang on 2/22/2017.
 */
public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new LinkedList();
    if (root!=null) {
      Queue<TreeNode> queue = new LinkedList();
      queue.offer(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i<size; i++) {
          TreeNode node = queue.poll();
          if (i==size - 1)
            list.add(node.val);
          if (node.left!=null)
            queue.add(node.left);
          if (node.right!=null)
            queue.add(node.right);
        }
      }
    }
    return list;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}