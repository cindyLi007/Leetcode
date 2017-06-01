package interview.amazon.online.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/16/2017.
 */
public class BstDistanceTest {
  @Test
  public void bstDistance() throws Exception {
    // Given
    int[] values = new int[]{5, 6, 3, 1, 2, 4};
    BstDistance solution = new BstDistance();

    // When
    int res = solution.bstDistance(values, 6, 2, 4);

    // Then
    assertThat(res, is(3));
  }

}