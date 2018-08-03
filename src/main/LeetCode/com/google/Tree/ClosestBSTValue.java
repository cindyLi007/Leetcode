package com.google.Tree;

/**
 * Created by grchan on 7/30/2018
 */
public class ClosestBSTValue {

  // Time : O(lgN), the key point is we need NOT traverse all node, we only need traverse left or right. For example, if
  // the target value is less than root value, we know all nodes in the root's right could not be closer to target than
  // root, we only need check root's left tree
  public int closestValue(TreeNode root, double target) {
    int res = root.val;
    TreeNode kid = root.val<target ? root.right : root.left;
    if (kid==null) {
      return res;
    }
    int res_1 = closestValue(kid, target);
    double diff = Math.abs(res-target), diff_1 = Math.abs(res_1-target);
    return diff<diff_1 ? res : res_1;
  }
}
