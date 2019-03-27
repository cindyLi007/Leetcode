package com.google.binary.search.tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MinDiffInBSTTest {

    @Test
    public void minDiffInBST() {
        // Given
        MinDiffInBST minDiffInBST = new MinDiffInBST();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        // When
        int diffInBST = minDiffInBST.minDiffInBST(root);

        // Then
        assertThat(diffInBST, is(1));
    }
}