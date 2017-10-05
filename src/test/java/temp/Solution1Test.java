package temp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 10/3/2017.
 */
public class Solution1Test {
  @Test
  public void maxSumOfThreeSubarrays() throws Exception {
    // Given
    Solution1 solution1 = new Solution1();

    // When
    int[] res = solution1.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2);

    // Then
    assertThat(res, is(new int[]{0, 3, 5}));
  }

}