package temp;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 8/12/2017.
 */
public class Sprial {
  public List<Integer> spiralOrder(int[][] matrix) {
    int M=matrix.length, N=M==0 ? 0 : matrix[0].length;
    List<Integer> res = new LinkedList();
    if (M==0 || N==0) return res;
    spiral(matrix, 0, M-1, 0, N-1, res);
    return res.subList(0, M*N);
  }
  public void spiral(int[][] matrix, int sr, int er, int sc, int ec, List<Integer> list) {
    if (sr>er || sc>ec) return;
    for (int i=sc; i<ec; i++) {
      list.add(matrix[sr][i]);
    }
    for (int i=sr; i<er; i++) {
      list.add(matrix[i][ec]);
    }
    for (int i=ec; i>sc; i--) {
      list.add(matrix[er][i]);
    }
    for (int i=er; i>sr; i--) {
      list.add(matrix[i][sc]);
    }
    spiral(matrix, sr+1, er-1, sc+1, ec-1, list);
  }

  public static void main(String[] args) {
    Sprial spiralOrder = new Sprial();
    int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> integers = spiralOrder.spiralOrder(array);
    integers.stream().forEach(System.out::println);
  }
}
