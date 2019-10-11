package algorithm.binary.indexed.tree;

public class NumMatrix {
  int[][] num;
  int[][] tree;
  int m, n;

  public NumMatrix(int[][] matrix) {
    m=matrix.length;
    n=matrix[0].length;
    tree = new int[m+1][n+1];
    num = new int[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        update(i, j, matrix[i][j]);
      }
    }
  }

  public void update(int row, int col, int val) {
    /*int diff = val - num[row][col];
    num[row][col] = val;
    row++; col++;
    while (row <= m) {
      while (col <= n) {
        tree[row][col] += diff;
        col += col & (-col);
      }
      row += row & (-row);
    }*/
    if (m == 0 || n == 0) return;
    int delta = val - num[row][col];
    num[row][col] = val;
    for (int i = row + 1; i <= m; i += i & (-i)) {
      for (int j = col + 1; j <= n; j += j & (-j)) {
        tree[i][j] += delta;
      }
    }
  }

  private int sum(int row, int col) {
    int sum = 0;
    while (row > 0) {
      while (col > 0) {
        sum += tree[row][col];
        col -= col & (-col);
      }
      row -= row & (-row);
    }
    return sum;

    /*int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;*/
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    /*row1++; col1++; row2++; col2++;
    return sum(row2, col2) + sum(row1-1, col1-1) - sum(row1-1, col2) - sum(row2, col1-1);*/
    if (m == 0 || n == 0) return 0;
    return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
  }

  public static void main(String... args) {

    int[][] nums = new int[][]{{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};
    NumMatrix numMatrix = new NumMatrix(nums);
    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
  }
}
