package com.google.Tree;

import static java.util.Arrays.asList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 8/24/2017.
 */
public class BTVerticalOrderTest {

  @Test
  public void verticalOrder() throws Exception {
    // Given
    BTVerticalOrder solution = new BTVerticalOrder();
    TreeNode root = new TreeNode(3);
    TreeNode level1_left = new TreeNode(9);
    TreeNode level1_right = new TreeNode(8);
    TreeNode level2_left_left = new TreeNode(4);
    TreeNode level2_left_right = new TreeNode(0);
    TreeNode level2_right_left = new TreeNode(1);
    TreeNode level2_right_right = new TreeNode(7);
    root.left = level1_left;
    root.right = level1_right;
    level1_left.left = level2_left_left;
    level1_left.right = level2_left_right;
    level2_left_right.right = new TreeNode(2);
    level1_right.left = level2_right_left;
    level1_right.right = level2_right_right;
    level2_right_left.left = new TreeNode(5);

    /*TreeNode right = new TreeNode(20);
    right.left = new TreeNode(15);
    right.right = new TreeNode(7);
    root.right = right;
    root.left = new TreeNode(9);*/

    // When
    List<List<Integer>> verticalOrder = solution.verticalOrder(root);

    // Then
    assertThat(verticalOrder, is(notNullValue()));
    /**
     * using hamcrest both can combine multiple condition check and hamcrest *contains* make the order matters
     */
    assertThat(verticalOrder, both(hasSize(4)).and(contains(asList(9), asList(3, 15), asList(20), asList(7))));
  }

}