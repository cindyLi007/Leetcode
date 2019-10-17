package com.google.recursive;

import org.junit.Test;

import java.util.List;

/**
 * Created by grchan on 7/27/2018
 */
public class PermutationsIITest {

  @Test
  public void permuteUnique() {
    // Given
    PermutationsII permutationsII = new PermutationsII();
    int[] nums = new int[]{1, 1, 2, 3};

    // Then
    List<List<Integer>> res = permutationsII.permuteUnique_recursive(nums);
  }
}