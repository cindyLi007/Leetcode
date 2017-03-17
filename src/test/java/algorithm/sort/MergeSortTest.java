package algorithm.sort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/22/2017.
 */
public class MergeSortTest {
  @Test
  public void mergeSort() throws Exception {
    // Given
    Integer[] array = new Integer[]{7, 10, 5, 3, 8, 4, 2, 9, 6};
    MergeSort mergeSort = new MergeSort();

    // When
    mergeSort.mergeSort(array);

    // Then
    assertThat(array, is(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10}));
  }

  @Test
  public void quickSort() throws Exception {
    // Given
    Integer[] array = new Integer[]{7, 10, 5, 3, 8, 4, 14, 2, 9, 6};
    QuickSort quickSort = new QuickSort();

    // When
    quickSort.quickSort(array);

    // Then
    assertThat(array, is(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 14}));
  }

}