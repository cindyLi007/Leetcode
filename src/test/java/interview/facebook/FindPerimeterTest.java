package interview.facebook;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/16/2017.
 */
public class FindPerimeterTest {
  @Test
  public void findPerimeter() throws Exception {
    // Given
    FindPerimeter findPerimeter = new FindPerimeter();
    int[][] grid = new int[][]{{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}};

    // When
    int perimeter = findPerimeter.findPerimeter(grid, 2, 2);

    // Then
    assertThat(perimeter, is(12));
  }

}