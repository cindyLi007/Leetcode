package algorithm.sort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/19/2017.
 */
public class SelectionSortTest {
  @Test
  public void selectionSort() throws Exception {
    // Given
    Integer[] array = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};

    // When
    SelectionSort.selectionSort(array);

    // Then
    assertThat(array, is(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10}));
  }

  @Test
  public void insertionSort() throws Exception {
    // Given
    Integer[] array = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};

    // When
    InsertionSort.insertionSort(array);

    // Then
    assertThat(array, is(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10}));
  }

  @Test
  public void shellSort() throws Exception {
    // Given
    Integer[] array = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};

    // When
    ShellSort.shellSort(array);

    // Then
    assertThat(array, is(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10}));
  }


}