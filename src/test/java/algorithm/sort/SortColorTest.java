package algorithm.sort;

import org.junit.Test;

/**
 * Created by ychang on 10/4/2017.
 */
public class SortColorTest {
  @Test
  public void sortColors() throws Exception {
    // Given
    SortColor sortColor = new SortColor();

    // When
    sortColor.sortColors(new int[]{0, 2, 1, 0, 2, 1, 0, 1});
  }

}