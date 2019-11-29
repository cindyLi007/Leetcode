package interview.facebook;

import java.util.ArrayList;
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
    if (root == null) return null;
    Map<Object, GraphNode> map = new HashMap();
    return helper(root, map);
  }

  private GraphNode helper(GraphNode root, Map<Object, GraphNode> map) {
    // we already visit it
    if (map.containsKey(root.label)) return map.get(root.label);
    GraphNode node = new GraphNode(root.label);
    map.put(root.label, node);
    List<GraphNode> neighbors = root.neighbors;
    for (GraphNode neighbor : neighbors) {
      node.neighbors.add(helper(neighbor, map));
    }
    return node;
  }

  public List<GraphNode> cloneGraph(List<GraphNode> Graph) {
    if (Graph.size() == 0) return Collections.emptyList();
    Map<Object, GraphNode> map = new HashMap<>();
    for (GraphNode node : Graph) {
      helper(node, map);
    }
    return map.values().stream().collect(Collectors.toList());
  }

  public static void main(String... args) {
    List<GraphNode> Graph = new ArrayList<>();
    GraphNode node1 = new GraphNode(1);
    GraphNode node2 = new GraphNode(2);
    GraphNode node3 = new GraphNode(3);
    GraphNode node4 = new GraphNode(4);
    node1.neighbors.add(node2);
    node1.neighbors.add(node4);
    node3.neighbors.add(node2);
    node3.neighbors.add(node4);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node4.neighbors.add(node1);
    node4.neighbors.add(node3);
    Graph.add(node1);
    Graph.add(node2);
    Graph.add(node3);
    Graph.add(node4);
    Graph.add(new GraphNode(5));
    GraphNode node6 = new GraphNode(6);
    GraphNode node7 = new GraphNode(7);
    node6.neighbors.add(node7);
    node7.neighbors.add(node6);
    Graph.add(node6);
    Graph.add(node7);
    GraphClone graphClone = new GraphClone();
    List<GraphNode> newGraph = graphClone.cloneGraph(Graph);
    for (GraphNode node : newGraph) {
      System.out.println(node.toString());
    }
  }
}

class GraphNode<T> {
  T label;
  List<GraphNode<T>> neighbors;

  GraphNode(T val) {
    label = val;
    neighbors = new LinkedList();
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    System.out.print("node is " + label + " neighbors are : ");
    for (GraphNode neighbor : neighbors) {
      stringBuilder.append(neighbor.label + ", ");
    }
    return stringBuilder.toString();
  }
}

