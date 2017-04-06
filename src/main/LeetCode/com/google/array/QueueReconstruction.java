package com.google.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 12/14/2016.
 */
public class QueueReconstruction {
  /*
    Need use list to array conversion.
    Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than them,
    each guy's index will be just as same as his k value. There is no way there are empty spots between tallest elements
    For 2nd tallest group (and the rest), insert each one of them into (S) by k value. Since now all elements in the list are
    taller than this 2nd tallest group, the k value is the index to insert.
    So on and so forth.
   */
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
      }
    });
    /* this is Java 8 implementation, slower than use comparator directly
    Arrays.sort(people, (a, b) -> a[0]==b[0] ? a[1] - b[1] : b[0] - a[0]);
    */
    List<int[]> list = new LinkedList();
    for (int[] p : people) {
      list.add(p[1], p);
    }
    return list.toArray(new int[people.length][]);
  }

  public static void main(String[] args) {
    QueueReconstruction qr = new QueueReconstruction();
    int[][] array = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    int[][] res = qr.reconstructQueue(array);
    Arrays.stream(array).forEach(ins -> {
      for (int i : ins) {
        System.out.print(i);
      }
      System.out.println();
    });
    System.out.println(Arrays.deepToString(res));
  }
}
