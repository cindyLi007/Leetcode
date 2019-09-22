package com.google.design;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeNaryTree {
  int idx;

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    if (root==null) return "";
    sb.append(root.val);
    for (Node node : root.children) {
      sb.append("#").append(serialize(node));
    }
    // "," means return to parent level
    sb.append("#,");
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data.length()==0) return null;
    String[] nodes = data.split("#");
    idx=0;
    return helper(nodes);
  }

  private Node helper(String[] nodes) {
    if (idx==nodes.length) return null;
    String cur = nodes[idx++];
    Node root = new Node(Integer.parseInt(cur), new ArrayList<>());
    // must use equals to compare ",", directly use == could not compare
    while (idx<nodes.length && !nodes[idx].equals(",")) {
      root.children.add(helper(nodes));
    }
    // whenever we encounter a ",", that means we end current node "root", should return to its parent
    idx++;
    return root;
  }

  static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public static void main(String... args) {
    Node root = new Node(1, new ArrayList<>());
    Node left = new Node(3, new ArrayList<>());
    Node middle = new Node(2, new ArrayList<>());
    Node right = new Node(4, new ArrayList<>());
    Node lower_1 = new Node(5, new ArrayList<>());
    Node lower_2 = new Node(6, new ArrayList<>());
    left.children.add(lower_1);
    left.children.add(lower_2);
    root.children.add(left);
    root.children.add(middle);
    root.children.add(right);
    SerializeDeserializeNaryTree serializeDeserializeNaryTree = new SerializeDeserializeNaryTree();
    String serializeString = serializeDeserializeNaryTree.serialize(root);
    System.out.println(serializeString);
    serializeDeserializeNaryTree.deserialize(serializeString);
  }
}
