package interview.facebook;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 2019 Nov. 8th phone interview
// Given a Graph (connected or not connected), right code to clone the whole graph
public class GraphClone {

  // for connected graph
  public GraphNode cloneGraph(GraphNode root) { // connected
    if (root==null) return null;
    Map<Integer, GraphNode> map = new HashMap();
    return helper(root, map);
  }

  private GraphNode helper(GraphNode root, Map<Integer, GraphNode> map) {
    // we already visit it
    if (map.containsKey(root.label)) return map.get(root.label);
    GraphNode node = new GraphNode(root.label);
    map.put(root.label, node);
    for (GraphNode neighbor : root.neighbors) {
      node.neighbors.add(helper(neighbor, map));
    }
    return node;
  }

  class GraphNode {
    int label;
    List<GraphNode> neighbors;

    GraphNode(int val) {
      label = val;
      neighbors = new LinkedList();
    }
  }

  public List<GraphNode> cloneGraph(List<GraphNode> G) {
    if (G.size()==0) return Collections.emptyList();
    Map<Integer, GraphNode> map = new HashMap<>();
    for (GraphNode node : G) {
      helper(node, map);
    }
    return map.values().stream().collect(Collectors.toList());
  }

}
