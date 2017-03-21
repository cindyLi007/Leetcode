package com.google.design;

import org.junit.Test;

/**
 * Created by ychang on 3/19/2017.
 */
public class SerializeDeserializeBTTest {
  @Test
  public void serialize() throws Exception {
    // Given
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    root.left = node2;
    root.right=node3;
    node3.left=node4;
    node3.right = node5;
    SerializeDeserializeBT serializeDeserializeBT = new SerializeDeserializeBT();

    // When
    String serializeString = serializeDeserializeBT.serialize(root);

    System.out.println(serializeString);

    TreeNode deserializeNode = serializeDeserializeBT.deserialize(serializeString);

    System.out.println(deserializeNode.val);
  }

}