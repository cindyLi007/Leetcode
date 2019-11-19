package interview.google.prepare;

import java.util.PriorityQueue;

public class MatrixKeepRelativeOrder {

  // Time: O(N*lgN), Space: O(N)
  public void change(int[][] matrix) {
    PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
    int M = matrix.length, N = matrix[0].length;
    int[] col = new int[N], row = new int[M];
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        pq.offer(new Item(matrix[i][j], i, j));
      }
    }
    while(!pq.isEmpty()) {
      Item item = pq.poll();
      int x = item.row, y = item.col;
      int v = Math.max(col[y], row[x]) + 1;
      col[y]=v;
      row[x]=v;
      matrix[x][y] = v;
    }
  }

  class Item {
    int val, row, col;

    Item(int v, int r, int c) {
      val = v;
      row = r;
      col = c;
    }
  }

  public static void main(String... args) {
    int[][] matrix = new int[][]{{1, 5, 6}, {4, 3, 2}, {8, 7, 9}};
    MatrixKeepRelativeOrder matrixKeepRelativeOrder = new MatrixKeepRelativeOrder();
    matrixKeepRelativeOrder.change(matrix);
    for (int i=0; i<3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
