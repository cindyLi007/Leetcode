package algorithm.sort;

/**
 * Created by ychang on 1/19/2017.
 * Insertion sort, making stride as h.
 */
public class ShellSort {
  public static void shellSort(Comparable[] array) {
    int N= array.length;
    int h=1;
    while (h<N/3) h=h*3+1;
    while(h>=1) {
      for (int i=h; i<N; i++) {
        for (int j=i; j>=h; j-=h) {
          if (array[j].compareTo(array[j-h])>=0) break;
          swap(array, j, j-h);
        }
      }
      h=h/3;
    }
  }

  private static void swap(Comparable[] array, int j, int i) {
    Comparable temp = array[j];
    array[j] = array[i];
    array[i] = temp;
  }
}
