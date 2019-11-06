package interview.google.prepare;

import java.util.LinkedList;
import java.util.Queue;

public class Go {
  int M, N;
  int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

  // Time: O(M*N), Space: O(M*N)
  public int capture_bfs(char[][] board, int r, int c) {
    M = board.length;
    N = M == 0 ? 0 : board[0].length;
    if (M == 0 || N == 0) return 0;
    if (!isValid(M, r, N, c) || board[r][c] != 'e') return 0;
    board[r][c] = 'b';
    Queue<int[]> queue = new LinkedList<>();
    int res = 0;
    for (int[] dir : dirs) {
      if (!isValid(M, r + dir[0], N, c + dir[1]))
        continue;
      queue.add(new int[]{r + dir[0], c + dir[1]});

      int count = 0;
      while (!queue.isEmpty()) {
        int[] curPoint = queue.poll();
        int x = curPoint[0], y = curPoint[1];
        if (board[x][y] == 'w') {
          count++;
          board[x][y]='b';
          for (int[] d : dirs) {
            int r1 = x + d[0];
            int c1 = y + d[1];
            if (isValid(M, r1, N, c1)) {
              queue.add(new int[]{r1, c1});
            }
          }
        } else if (board[x][y] == 'e') { // if a w can connect to a 'e', we could not capture it, terminate
          count = 0;
          break;
        }
      }
      res += count;
    }
    return res;
  }

  public int capture_dfs(char[][] board, int r, int c) {
    M = board.length;
    N = M == 0 ? 0 : board[0].length;
    if (M == 0 || N == 0 || !isValid(M, r, N, c) || board[r][c] != 'e') return 0;
    boolean[][] visited = new boolean[M][N];
    visited[r][c] = true;
    int count = 0;
    for (int[] dir : dirs) {
      int d = dfs(board, visited, r + dir[0], c + dir[1]);
      if (d > 0)
        count += d;
    }
    return count;
  }

  private int dfs(char[][] board, boolean[][] visited, int r, int c) {
    if (!isValid(M, r, N, c) || visited[r][c]) return 0;
    visited[r][c] = true;
    if (board[r][c] == 'e') return -1;
    if (board[r][c] == 'b') return 0;
    int count = 0;
    count++;
    for (int[] dir : dirs) {
      int t = dfs(board, visited, r + dir[0], c + dir[1]);
      if (t == -1) return -1;
      count += t;
    }
    return count;
  }

  private boolean isValid(int M, int r, int N, int c) {
    return r >= 0 && r < M && c >= 0 && c < N;
  }

  public static void main(String... args) {
    Go go = new Go();
    char[][] board_1 = new char[][]{"eebbbbb".toCharArray(),
                                    "eebwewb".toCharArray(),
                                    "eebbbeb".toCharArray(),
                                    "eeeeeee".toCharArray()};
    System.out.println(go.capture_dfs(board_1, 2, 5)); // 0
    System.out.println(go.capture_bfs(board_1, 2, 5));

    board_1 = new char[][]{ "eeeebbb".toCharArray(),
                            "eeeewwb".toCharArray(),
                            "eeeebeb".toCharArray(),
                            "eeeeeee".toCharArray()};
    System.out.println(go.capture_dfs(board_1, 2, 5)); // 0
    System.out.println(go.capture_bfs(board_1, 2, 5));

    board_1 = new char[][]{ "eeeebbb".toCharArray(),
                            "eeebwwb".toCharArray(),
                            "eeeebeb".toCharArray(),
                            "eeeeeee".toCharArray()};
    System.out.println(go.capture_dfs(board_1, 2, 5)); // 2
    System.out.println(go.capture_bfs(board_1, 2, 5));

    board_1 = new char[][]{ "eeeebbb".toCharArray(),
                            "eeeebwb".toCharArray(),
                            "eeeebeb".toCharArray(),
                            "eeeeeee".toCharArray()};
    System.out.println(go.capture_dfs(board_1, 2, 5)); // 1
    System.out.println(go.capture_bfs(board_1, 2, 5));
  }
}
