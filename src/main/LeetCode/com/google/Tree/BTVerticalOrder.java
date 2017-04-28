package com.google.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by ychang on 4/26/2017.
 */
public class BTVerticalOrder {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList();
    if (root==null) return res;
    Queue<TreeNode> queue = new LinkedList();
    Queue<Integer> number = new LinkedList();
    queue.offer(root);
    number.offer(0);
    /**
     * Do not use TreeMap, slow performance
     */
    Map<Integer, List<Integer>> map = new HashMap();
    int min=0, max=0;

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
        number.offer(key-1);
        min=Math.min(min, key-1);
      }
      if (node.right!=null) {
        queue.offer(node.right);
        number.offer(key+1);
        max=Math.max(max, key+1);
      }
    }

    /**
     * record min and max, min is the most left, max is the most right
     */
    for (int i=min; i<=max; i++) {
      res.add(map.get(i));
    }
    return res;
  }
}
