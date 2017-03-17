package algorithm.sort;

/**
 * Created by ychang on 1/22/2017.
 */
public class MergeSort {
  public void mergeSort(Comparable[] array) {
    if (array.length<=1) return;
    sort(array, 0, array.length - 1);
  }

  private void sort(Comparable[] array, int l, int h) {
    if (l>=h) return;
    int m = (h+l)/2;
    sort(array, l, m);
    sort(array, m+1, h);
    merge(array, l, m, h);
  }

  private void merge(Comparable[] array, int l, int m, int h) {
    Comparable[] aux = new Comparable[h - l + 1];
    int j = m + 1, i=l;
    for (int k = 0; k<(h - l + 1); k++) {
      if (j>h)
        aux[k] = array[i++];
      else if (i>m)
        aux[k] = array[j++];
      else if (array[j].compareTo(array[i])>=0)
        aux[k] = array[i++];
      else
        aux[k] = array[j++];
    }
    for (i=l; i<=h; i++) {
      array[i]=aux[i-l];
    }
  }
}
