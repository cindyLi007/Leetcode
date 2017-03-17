package algorithm.sort;

/**
 * Created by ychang on 1/19/2017.
 * O(N^2). Each i iteration, insert the ith element to right position.
 */
public class InsertionSort {

  public static void insertionSort(Comparable[] array) {
    for (int i = 0; i<array.length; i++) {
      for (int j = i; j>0; j--) {
        if (array[j].compareTo(array[j - 1])>=0)
          break;
        swap(j - 1, j, array);
      }
    }
  }

  private static void swap(int i, int j, Comparable[] array) {
    Comparable temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
