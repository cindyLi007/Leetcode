package interview.amazon.online.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/23/2017.
 */
public class BaseBallTest {
  @Test
  public void calculateSum() throws Exception {
    // Given
    BaseBall baseBall = new BaseBall();

    // When
    int sum = baseBall.calculateSum(new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"});

    // Then
    assertThat(sum, is(27));
  }

}