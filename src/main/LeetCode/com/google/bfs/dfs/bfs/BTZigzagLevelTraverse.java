package com.google.bfs.dfs.bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/5/2017.
 * A linear collection that supports element insertion and removal at both ends. The name deque is short for
 * "double ended queue" and is usually pronounced "deck". Always keep elements in queue normal level order (left -> right),
 * but when push and pop, depends on level, pop and push last or first.
 */
public class BTZigzagLevelTraverse {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList();
    Deque<TreeNode> queue = new LinkedList();
    if (root!=null) queue.offer(root);
    boolean left=false;
    Deque<TreeNode> level = new LinkedList();
    while (!queue.isEmpty()) {
      List<Integer> list = new LinkedList();
      while (!queue.isEmpty()) {
        TreeNode node = left ? queue.pollLast() : queue.pollFirst();
        list.add(node.val);
        if (!left) {
          if (node.left!=null) level.offer(node.left);
          if (node.right!=null) level.offer(node.right);
        } else {
          if (node.right!=null) level.offerFirst(node.right);
          if (node.left!=null) level.offerFirst(node.left);
        }
      }
      queue.addAll(level);
      level.clear();
      res.add(list);
      left=!left;
    }
    return res;
  }
}
