package com.google.backtracking;

import org.junit.Test;

public class SubsetIITest {

    @Test
    public void subsetsWithDup_dup() {
        // Given
        SubsetII subsetII = new SubsetII();

        // When
        subsetII.subsetsWithDup_noRecursive(new int[]{1, 2, 2});
    }
}