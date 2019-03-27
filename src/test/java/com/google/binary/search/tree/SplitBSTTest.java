package com.google.binary.search.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SplitBSTTest {

    @Test
    public void splitBST() {
        // Given
        // [4,2,6,1,3,5,7]
        SplitBST splitBST = new SplitBST();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(5);
        right.right = new TreeNode(7);

        // When
        TreeNode[] treeNodes = splitBST.splitBST(root, 2);

        // Then
        assertThat(treeNodes[0].val, is(2));
        assertThat(treeNodes[1].val, is(4));
    }
}