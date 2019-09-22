package com.google.design;

/**
 * Created by ychang on 3/19/2017.
 * The key point of this problem is for each node even it is null, we need have val for it
 */
public class SerializeDeserializeBT {
  int idx;

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    if (root==null) return "#";
    sb.append(String.valueOf(root.val));
    String left = serialize(root.left);
    String right = serialize(root.right);
    sb.append(",").append(left).append(",").append(right);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length()==0 || data.equals("#")) return null;
    String[] n = data.split(",");
    idx = 0;
    return helper(n);
  }

  private TreeNode helper(String[] nodes) {
    if (idx==nodes.length || nodes[idx].equals("#")) {
      idx++; return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(nodes[idx++]));
    root.left = helper(nodes);
    root.right = helper(nodes);
    return root;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
