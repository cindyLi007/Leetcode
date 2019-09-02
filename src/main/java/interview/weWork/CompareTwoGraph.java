package interview.weWork;

import java.util.List;

public class CompareTwoGraph {

  // Given 2 graph start node, suppose they are identical peer in the graph, check whether the whole graph is same
  public boolean isIdentical(Node node1, Node node2) {
    return true;

  }

  class Node {
    List<Node> neighbors;
    int v;
  }
}
