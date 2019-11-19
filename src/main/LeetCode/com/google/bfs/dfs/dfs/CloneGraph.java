package com.google.bfs.dfs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by ychang on 2/22/2017.
 */
public class CloneGraph {
  // Time: O(V + E)
  public Node cloneGraph(Node node) {
    if (node == null) return null;
    Map<Integer, Node> map = new HashMap();
    return helper(node, map);
  }

  private Node helper(Node root, Map<Integer, Node> map) {
    if (map.containsKey(root.val)) return map.get(root.val);
    Node node = new Node(root.val, new ArrayList());
    map.put(root.val, node);
    for (Node n : root.neighbors) {
      node.neighbors.add(helper(n, map));
    }
    return node;
  }

  class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  /**
   * the key point is how to handle when clone the original node. We should do it when we first meetthe original node,
   */
  public Node cloneGraph_bfs(Node node) {
    if (node==null) return null;
    Map<Integer, Node> map = new HashMap();
    map.put(node.val, new Node(node.val, new ArrayList()));
    Queue<Node> queue = new LinkedList();
    queue.offer(node);

    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      for (Node neighbor : cur.neighbors) {
        if (!map.containsKey(neighbor.val)) {
          map.put(neighbor.val, new Node(neighbor.val, new ArrayList()));
          queue.offer(neighbor);
        }
        map.get(cur.val).neighbors.add(map.get(neighbor.val));
      }
    }

    return map.get(node.val);
  }
}