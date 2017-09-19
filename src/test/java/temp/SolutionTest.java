package temp;

import static java.util.Arrays.asList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import java.util.List;

import org.junit.Test;

public class SolutionTest {
  @Test
  public void verticalOrder() throws Exception {
    // Given
    Solution solution = new Solution();
    TreeNode root = new TreeNode(3);
    TreeNode right = new TreeNode(20);
    right.left = new TreeNode(15);
    right.right = new TreeNode(7);
    root.right = right;
    root.left = new TreeNode(9);

    // When
    List<List<Integer>> verticalOrder = solution.verticalOrder(root);

    // Then
    assertThat(verticalOrder, is(notNullValue()));
    // using hamcrest both can combine multiple condition check and hamcrest *contains* make the order matters
    assertThat(verticalOrder, both(hasSize(4)).and(contains(asList(9), asList(3, 15), asList(20), asList(7))));
  }

}