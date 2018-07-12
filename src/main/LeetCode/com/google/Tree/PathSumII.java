package com.google.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    pathSum(root, sum, res, new ArrayList<Integer>());
    return res;
  }

  private void pathSum(TreeNode node, int remainingVal, List<List<Integer>> res, List<Integer> curVals) {
    if (node==null) return;
    curVals.add(node.val);
    if (node.left==null && node.right==null) {
      if (remainingVal == node.val) {
        List<Integer> temp = new ArrayList<>(curVals);
        res.add(temp);
      }
    } else {
      pathSum(node.left, remainingVal-node.val, res, curVals);
      pathSum(node.right, remainingVal-node.val, res, curVals);
    }
    curVals.remove(curVals.size()-1);
  }
}
