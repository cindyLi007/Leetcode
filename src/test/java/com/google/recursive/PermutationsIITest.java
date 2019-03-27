package com.google.recursive;

import com.google.Tree.PathSumII;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by grchan on 7/27/2018
 */
public class PermutationsIITest {

  @Test
  public void permuteUnique() {
    // Given
    PermutationsII permutationsII = new PermutationsII();
    int[] nums = new int[]{2, 2, 2, 3, 3};

    // Then
    List<List<Integer>> res = permutationsII.permuteUnique_recursive(nums);
  }
}