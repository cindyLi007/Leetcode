package com.google.recursive;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AllPossibleFBTTest {

    @Test
    public void allPossibleFBT() {
        // Given
        AllPossibleFBT possibleFBT = new AllPossibleFBT();

        // When
        List<TreeNode> treeNodes = possibleFBT.allPossibleFBT(3);

        // Then
        assertThat(treeNodes.size(), is(1));
    }
}