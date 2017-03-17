package algorithm.sort;

/**
 * Created by ychang on 1/19/2017.
 * Selection sort is O(N^2), which is each i iteration, select the smallest element from the remaining part of the array,
 * swap it with i.
 */
public class SelectionSort {
  public static void selectionSort(Comparable[] array) {
    for (int i=0; i<array.length; i++) {
      int min = i;
      for (int j=i+1; j<array.length; j++) {
        if (array[min].compareTo(array[j])>0)
          min=j;
      }
      swap(min, i, array);
    }
  }

  private static void swap(int m, int n, Comparable[] array) {
    Comparable temp = array[m];
    array[m]=array[n];
    array[n]=temp;
  }
}
