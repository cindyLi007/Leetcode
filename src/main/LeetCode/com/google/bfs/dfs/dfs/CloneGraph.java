package com.google.bfs.dfs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by ychang on 2/22/2017.
 */
public class CloneGraph {
  /**
   * this method can beat 70%
   */
  public Node cloneGraph(Node node) {
    if (node==null) return null;
    Map<Integer, Node> map = new HashMap<>();
    return dfs(node, map);
  }

  private Node dfs(Node node, Map<Integer, Node> map) {
    map.put(node.val, new Node(node.val, new ArrayList()));
    for (Node n : node.neighbors) {
      map.get(node.val).neighbors.add(map.get(n.val)!=null ?
              map.get(n.val) : dfs(n, map));
    }
    return map.get(node.val);
  }

  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  };


  private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    map.put(node.label, copy);
    copy.neighbors.addAll(node.neighbors.stream().map(neighbor -> map.containsKey(neighbor.label) ?
        map.get(neighbor.label) : dfs(neighbor, map)).collect(Collectors.toList()));
    return copy;
  }

  /**
   * this method can beat 29%, the key point is how to handle when clone the original node. We should do it when we first meet
   * the original node, because when we poll node from queue, we need loop through all its neighbors, that is the last chance
   * we visit the node and its neighbors, here we need put all cloned-neighbors to the cloned node's neighbors.
   */
  public UndirectedGraphNode cloneGraph_bfs(UndirectedGraphNode node) {
    if (node==null)
      return null;
    Queue<UndirectedGraphNode> queue = new LinkedList();
    Map<Integer, UndirectedGraphNode> map = new HashMap();
    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    map.put(node.label, copy);
    queue.offer(node);

    while (!queue.isEmpty()) {
      UndirectedGraphNode cur = queue.poll();
      List<UndirectedGraphNode> list = map.get(cur.label).neighbors;
      for (UndirectedGraphNode n : cur.neighbors) {
        /**
         * if n is not in map, that means we never encountered this node, we can put it in queue
         */
        if (!map.containsKey(n.label)) {
          map.put(n.label, new UndirectedGraphNode(n.label));
          queue.offer(n);
        }
        list.add(map.get(n.label));
      }
    }

    return copy;
  }
}

class UndirectedGraphNode {
  int label;
  List<UndirectedGraphNode> neighbors;

  UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<UndirectedGraphNode>();
  }
};