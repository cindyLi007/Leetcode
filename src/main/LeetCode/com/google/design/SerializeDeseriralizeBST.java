package com.google.design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 3/22/2017.
 */
public class SerializeDeseriralizeBST {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildTree(root, sb);
    return sb.toString();
  }

  private void buildTree(TreeNode root, StringBuilder sb) {
    if (root==null)
      return;
    sb.append(root.val).append(",");
    buildTree(root.left, sb);
    buildTree(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    int[] preOrder = Arrays.stream(data.split(",")).mapToInt(Integer::valueOf).toArray();
    int[] inOrder = Arrays.copyOf(preOrder, preOrder.length);
    Arrays.sort(inOrder);
    Map<Integer, Integer> map = new HashMap();
    for (int i = 0; i<inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
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
