package com.google.design;

/**
 * Created by ychang on 3/19/2017.
 * The key point of this problem is for each node even it is null, we need have val for it
 */
/**
 * Compass phone interview, 10/8/2019
 * Notes:
 * First thing is to ask what is the value in TreeNode, so we can use a char which will not appear in node value as delimiter to
 * separate the nodes, for ex. Escape in encoding URL
 * Second thing, think about test case, if that is part of valid tree
 *         1
 *       /  \
 *      2    4
 *       \
 *        5
 * Should be 1, 2, #, 5, #, #, 4, #, #, but if we get 1, 2, #, 5, #, #, 4, #, #, #, #, how to validate it (use idx == length)
 */
public class SerializeDeserializeBT {
  // IMPORTANT: the reason we put a variable OUTSIDE method is because Java "pass by value",
  // so in deserialize method, even we put the idx as parameter and increase it, it will not change the value outside it
  int idx;

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    if (root==null) return "#";
    sb.append(root.val);
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
    if (idx==nodes.length) {
      throw new IllegalArgumentException("could not build a valid tree");
    }
    String n = nodes[idx++];

    if (n.equals("#")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(nodes[idx]));
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
