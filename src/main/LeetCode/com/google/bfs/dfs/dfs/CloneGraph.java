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
  /**
   * this method can beat 69%
   */
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node==null)
      return null;
    return dfs(node, new HashMap());
  }

  private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    map.put(node.label, copy);
    for (UndirectedGraphNode neighbor : node.neighbors) {
      copy.neighbors.add(map.containsKey(neighbor.label) ? map.get(neighbor.label) : dfs(neighbor, map));
    }
    return copy;
  }

  /**
   * this method can beat 28%, the key point is how to handle when clone the original node. We should do it when we first meet
   * the original node, because when we poll node from queue, we need loop through all its neighbors, that is the last chance
   * we visit the node and its neighbors, here we need put all cloned-neighbors to the cloned node's neighbors.
   */
  public UndirectedGraphNode cloneGraph_bfs(UndirectedGraphNode node) {
    if (node==null) return null;
    Queue<UndirectedGraphNode> queue=new LinkedList();
    queue.offer(node);
    Map<Integer, UndirectedGraphNode> map = new HashMap();
    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    map.put(node.label, copy);
    while (!queue.isEmpty()) {
      UndirectedGraphNode cur = queue.poll();
      for (UndirectedGraphNode neighbor : cur.neighbors) {
        if (!map.containsKey(neighbor.label)) {
          map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
          queue.offer(neighbor);
        }
        map.get(cur.label).neighbors.add(map.get(neighbor.label));
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