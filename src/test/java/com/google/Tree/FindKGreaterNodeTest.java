package com.google.Tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by grchan on 7/30/2018
 */
public class FindKGreaterNodeTest {

  @Test
  public void findKGreaterNode() {
    // Given
    TreeNode root_50 = new TreeNode(50);
    TreeNode left_30 = new TreeNode(30);
    TreeNode right_60 = new TreeNode(60);
    root_50.left = left_30;
    root_50.right = right_60;
    TreeNode child_10 = new TreeNode(10);
    TreeNode child_35 = new TreeNode(35);
    TreeNode child_55 = new TreeNode(55);
    TreeNode child_80 = new TreeNode(80);
    left_30.left = child_10; left_30.right = child_35;
    right_60.left = child_55; right_60.right = child_80;
    TreeNode right_40 = new TreeNode(40);
    child_35.right = right_40;
    right_40.left = new TreeNode(36);
    right_40.right = new TreeNode(45);
    FindKGreaterNode findKGreaterNode = new FindKGreaterNode();

    // When
    List<Integer> kGreaterNode = findKGreaterNode.findKGreaterNodeRecursive(root_50, 10, 4);

    kGreaterNode.stream().forEach(System.out::println);
  }
}