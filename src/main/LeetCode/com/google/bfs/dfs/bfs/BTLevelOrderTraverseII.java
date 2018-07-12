package com.google.bfs.dfs.bfs;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BTLevelOrderTraverseII {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> currentLevel = new LinkedList();
    currentLevel.addFirst(root);
    while (!currentLevel.isEmpty()) {
      int size = currentLevel.size();
      List<Integer> list = new LinkedList();
      for (int i = 0; i < size; i++) {
        TreeNode node = currentLevel.removeFirst();
        list.add(node.val);
        if (node.left != null) currentLevel.addLast(node.left);
        if (node.right != null) currentLevel.addLast(node.right);
      }
      res.add(0, list);
    }

    // using stream is acceptable but too slow
    // return queue.stream().collect(Collectors.toList());

    return res;
  }

  // this one is faster than the above solution.
  public List<List<Integer>> levelOrderBottom_recursive(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    levelOrderBottom(root, res, 0);
    return res;
  }

  private void levelOrderBottom(TreeNode root, List<List<Integer>> res, int level) {
    if (root==null) return;
    if (level>=res.size()) {
      // must add to the first place since we use reverse order
      res.add(0, new LinkedList<>());
    }
    levelOrderBottom(root.left, res, level+1);
    levelOrderBottom(root.right, res, level+1);
    res.get(res.size()-level-1).add(root.val);
  }
}
