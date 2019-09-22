package com.google.design;

/**
 * Created by ychang on 3/22/2017.
 */
public class SerializeDeseriralizeBST {
  int idx;

  // Encodes a tree to a single string.
  // Time: O(N), Space: O(lgN) for recursive, pre-order
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    if (root==null) return sb.toString();
    sb.append(root.val);
    String left = serialize(root.left);
    String right = serialize(root.right);
    if (left.length()>0) sb.append("#").append(left);
    if (right.length()>0) sb.append("#").append(right);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length()==0) return null;
    String[] n = data.split("#");
    int[] nodes = new int[n.length];
    for (int i=0; i<n.length; i++)
      nodes[i] = Integer.parseInt(n[i]);
    idx=0;
    return helper(Integer.MAX_VALUE, Integer.MIN_VALUE, nodes);
  }

  private TreeNode helper(int max, int min, int[] nodes) {
    if (idx==nodes.length || nodes[idx] > max || nodes[idx] < min) return null;
    TreeNode root = new TreeNode(nodes[idx++]);
    root.left = helper(root.val, min, nodes);
    root.right = helper(max, root.val, nodes);
    return root;
  }
}
