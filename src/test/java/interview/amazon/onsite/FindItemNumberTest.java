package interview.amazon.onsite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 4/4/2017.
 */
public class FindItemNumberTest {
  @Test
  public void findItemTimes() throws Exception {
    // Given
    FindItemNumber findItemNumber = new FindItemNumber();
    int[] nums = new int[]{1, 2, 3, 10, 10, 10, 20, 20, 50, 50};

    // when
    int times_40 = findItemNumber.findItemTimes(nums, 40);
    int times_50 = findItemNumber.findItemTimes(nums, 50);
    int times_10 = findItemNumber.findItemTimes(nums, 10);
    int times_2 = findItemNumber.findItemTimes(nums, 2);
    int times_1 = findItemNumber.findItemTimes(nums, 1);

    // Then
    assertThat(times_10, is(3));
    assertThat(times_2, is(1));
    assertThat(times_40, is(0));
    assertThat(times_50, is(2));
    assertThat(times_1, is(1));
  }

}