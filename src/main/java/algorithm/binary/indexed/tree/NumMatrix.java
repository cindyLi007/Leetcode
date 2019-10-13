package algorithm.binary.indexed.tree;

// Leetcode 327
// 其实2-D indexed binary tree 和1-D indexed binary tree 并没有太大的区别，我们只要把matrix当成一系列的1-D indexed binary tree
// 就可以了 这些1-D indexed binary tree 不光是横着看，也要竖着看，比如第二行，并不是自己这一行的1-D indexed binary tree，
// 它是第一行和第二行的叠加，而每一个pos又是自己这一行的1-D indexed binary tree
public class NumMatrix {
  int[][] nums;
  int[][] tree;
  int m, n;

  // Time: O(m*n*logM*logN)
  public NumMatrix(int[][] matrix) {
    m = matrix.length;
    n = matrix[0].length;
    tree = new int[m + 1][n + 1];
    nums = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        update(i, j, matrix[i][j]);
      }
    }
  }

  // Time: O(logM*logN)
  public void update(int row, int col, int val) {
    int diff = val - nums[row][col];
    nums[row][col] = val;
    row++;
    col++;
    for (int i = row; i <= m; i += i & (-i)) {
      for (int j = col; j <= n; j += j & (-j)) {
        tree[i][j] += diff;
      }
    }
  }

  // Time: O(m*n*logM*logN)
  private int sum(int row, int col) {
    int sum = 0;
    for (int i = row; i > 0; i -= i & (-i)) {
      for (int j = col; j > 0; j -= j & (-j)) {
        sum += tree[i][j];
      }
    }
    return sum;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    row2++;
    col2++;
    return sum(row2, col2) + sum(row1, col1) - sum(row1, col2) - sum(row2, col1);
  }

  public static void main(String... args) {

    int[][] nums = new int[][]{
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}};
    NumMatrix numMatrix = new NumMatrix(nums);
    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    numMatrix.update(3, 2, 2);
    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
  }
}
