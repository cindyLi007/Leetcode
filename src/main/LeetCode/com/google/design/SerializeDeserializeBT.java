package com.google.design;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ychang on 3/19/2017.
 */
public class SerializeDeserializeBT {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildTree(root, sb);
    return sb.toString();
  }

  private void buildTree(TreeNode root, StringBuilder sb) {
    if (root==null) {
      sb.append('X').append(",");
    } else {
      sb.append(root.val).append(",");
      buildTree(root.left, sb);
      buildTree(root.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Deque<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(",")));
    return buildTree(nodes);
  }

  private TreeNode buildTree(Deque<String> list) {
    String curNode = list.remove();
    if (curNode.equals("X")) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.valueOf(curNode));
    node.left=buildTree(list);
    node.right=buildTree(list);
    return node;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
