package com.google.design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 3/22/2017.
 */
public class SerializeDeseriralizeBST {
  int idx;

  // Encodes a tree to a single string.
  // Time: O(N), Space: O(lgN) for recursive, pre-order
  public String serialize(TreeNode root) {
    if (root==null) return "";
    StringBuilder sb = new StringBuilder();
    return sb.append(root.val).append(",").append(
        serialize(root.left)).append(serialize(root.right)).toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length()==0) return null;
    idx=0;
    return helper(data.split(","), Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode helper(String[] data, int min, int max) {
    if (idx==data.length) return null;
    int v = Integer.parseInt(data[idx]);
    if (v<=min || v>=max) return null;
    idx++;
    TreeNode root = new TreeNode(v);
    root.left = helper(data, min, v);
    root.right = helper(data, v, max);
    return root;
  }

  private TreeNode buildTree(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie, Map<Integer, Integer> map) {
    if (ps>pe)
      return null;
    TreeNode root = new TreeNode(preOrder[ps]);
    int index = map.get(preOrder[ps]);
    int distance = index - is;
    root.left = buildTree(preOrder, ps + 1, ps + distance, inOrder, is, is + distance - 1, map);
    root.right = buildTree(preOrder, ps + distance + 1, pe, inOrder, is + distance + 1, ie, map);
    return root;
  }
}
