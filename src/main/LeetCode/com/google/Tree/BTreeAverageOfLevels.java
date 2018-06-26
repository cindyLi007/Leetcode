package com.google.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BTreeAverageOfLevels {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new LinkedList();
    Deque<TreeNode> currentLevel = new LinkedList<>();
    currentLevel.addLast(root);

    while (!currentLevel.isEmpty()) {
      int size = currentLevel.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = currentLevel.removeFirst();
        sum += node.val;
        if (node.left != null) currentLevel.addLast(node.left);
        if (node.right != null) currentLevel.addLast(node.right);
      }
      res.add(sum / size);
    }
    return res;
  }
}
