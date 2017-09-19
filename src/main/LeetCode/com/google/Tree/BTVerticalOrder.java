package com.google.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by ychang on 4/26/2017.
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * /\
 * /  \
 * 5   2
 * returns
 * [
 * [4],
 * [9,5],
 * [3,0,1],
 * [8,2],
 * [7]
 * ]
 * based on the above example, we can find each node's left is in the list just BEFORE it's list, each node's right is
 * in the list just AFTER it's list. So can use a index bound in a nodes to record its position in the res.
 *
 * The idea is we traverse the tree in level order, for each node, record its vertical position, left is parent's index-1,
 * right is parent's index+1, when poll the node out, we put it in the corresponding index list in the map, finally we
 * loop through map from most-left to most-right and write each list to res.
 */
public class BTVerticalOrder {

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList();
    if (root==null)
      return res;
    /**
     * it is much faster to use 2 queues than using one queue with customized Node(Treenode, index)
     */
    Queue<TreeNode> queue = new LinkedList();
    Queue<Integer> number = new LinkedList();
    queue.offer(root);
    number.offer(0);
    /**
     * Do not use TreeMap, slow performance
     */
    Map<Integer, List<Integer>> map = new HashMap();
    int min = 0, max = 0;

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      int key = number.poll();
      /** this one is much slower than directly check
       * map.computeIfAbsent(key, k->new ArrayList()).add(node.val);
       */
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList());
      }
      map.get(key).add(node.val);
      if (node.left!=null) {
        queue.offer(node.left);
        number.offer(key - 1);
        /**
         * this is faster than min=Math.min(min, key-1);
         */
        if (key - 1<min)
          min = key - 1;
      }
      if (node.right!=null) {
        queue.offer(node.right);
        number.offer(key + 1);
        if (key + 1>max)
          max = key + 1;
      }
    }

    /**
     * record min and max, min is the most left, max is the most right
     */
    for (int i = min; i<=max; i++) {
      res.add(map.get(i));
    }
    return res;
  }

  /**
   * It is a faster way, we need not use a map for <pos, list>, we first get range [-x, +y], in which -x ia the most-left
   * pos, +y is the most-right pos, 2nd we know root should be in the +x pos in the res (that is because (-x)->0, (-x+1)->1,
   * (-x+x)->x, finally we layer traverse the tree, during this process, we record the pos of each node (left=root-1, right=root+1)
   */
  public List<List<Integer>> verticalOrder_faster(TreeNode root) {
    List<List<Integer>> res = new ArrayList();
    if (root==null) return res;
    int[] range=new int[]{0, 0};
    getRange(root, range, 0);

    for (int i=range[0]; i<=range[1]; i++) {
      res.add(new LinkedList());
    }

    Queue<TreeNode> nodes = new LinkedList();
    nodes.offer(root);
    Queue<Integer> nums = new LinkedList();
    // we need right shift |range[0]| to make all list has >=0 index;
    nums.offer(-range[0]);

    while (!nodes.isEmpty()) {
      TreeNode node = nodes.poll();
      int index = nums.poll();
      res.get(index).add(node.val);
      if (node.left!=null) {
        nodes.offer(node.left);
        nums.offer(index-1);
      }
      if (node.right!=null) {
        nodes.offer(node.right);
        nums.offer(index+1);
      }
    }

    return res;
  }

  private void getRange(TreeNode root, int[] range, int index) {
    range[0]=Math.min(range[0], index);
    range[1]=Math.max(range[1], index);

    if (root.left!=null) getRange(root.left, range, index-1);
    if (root.right!=null) getRange(root.right, range, index+1);
  }
}
