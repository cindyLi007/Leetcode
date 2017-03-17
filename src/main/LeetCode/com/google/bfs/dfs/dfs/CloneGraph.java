package com.google.bfs.dfs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ychang on 2/22/2017.
 */
public class CloneGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node==null)
      return null;
    Map<Integer, UndirectedGraphNode> map = new HashMap();
    return dfs(node, map);
  }

  private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
    if (!map.containsKey(node.label)) {
      UndirectedGraphNode ugn = new UndirectedGraphNode(node.label);
      // must have this to avoid stack overflow
      map.put(node.label, ugn);
      for (UndirectedGraphNode neighbor : node.neighbors) {
        ugn.neighbors.add(dfs(neighbor, map));
      }
    }
    return map.get(node.label);
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