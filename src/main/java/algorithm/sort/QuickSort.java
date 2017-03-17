package algorithm.sort;

/**
 * Created by ychang on 1/22/2017.
 * 3-way Partitioning, from lo to lt-1 is less-than-v part, from lt to gt is equals-to-v part, from gt+1 to hi part is
 * greater-than-v part. After one round sort, all elements less than v is in v's left, and all elements greater than v
 * is in v's right
 */
public class QuickSort {
  public void quickSort(Comparable[] array) {
    sort(array, 0, array.length - 1);
  }

  private void sort(Comparable[] array, int lo, int hi) {
    if (lo>=hi)
      return;
    Comparable v = array[lo];
    int i = lo, lt=lo, gt=hi;
    while (i<=gt) {
      int comp = v.compareTo(array[i]);
      if (comp<0) { // current value > v
        exchange(array, i, gt--);
      } else if (comp>0) {
        exchange(array, i++, lt++);
      } else {
        i++;
      }
    }
    sort(array, lo, lt-1);
    sort(array, gt + 1, hi);
  }

  private void exchange(Comparable[] array, int i, int j) {
    Comparable temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
