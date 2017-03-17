package com.google.union.find;

import java.util.Arrays;

/**
 * Created by ychang on 1/15/2017.
 * Use a virtual node as boundary 'O' node, go through all nodes, find whether it union to this virtual node, if Yes,
 * keep it as 'O', otherwise change it to 'X'
 */
public class SurroundedRegion {
  private int size;
  int[] uf;
  int[] sz;

  public void solve(char[][] board) {
    if (board==null || board.length<3 || board[0].length<3)
      return;

    // Initialize UnionFind data structure
    int m = board.length, n = board[0].length;
    size = m*n + 1;
    uf = new int[size];
    sz = new int[size];
    Arrays.fill(sz, 1);
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if ((i==m - 1 || i==0 || j==0 || j==n - 1) && board[i][j]=='O') {
          uf[i*n + j] = m*n;
          sz[m*n]++;
        } else
          uf[i*n + j] = i*n + j;
      }
    }
    uf[m*n] = m*n;

    //
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if (board[i][j]=='O') {
          /** we only need union left and upper, no need to union right and lower, because later this node's right node
           and lower node will union this node */
          union(i, j, i - 1, j, m, n, board);
          union(i, j, i, j - 1, m, n, board);
        }
      }
    }
    change(m, n, board);
  }

  // Weighted Quick-Union
  void union(int i, int j, int x, int y, int m, int n, char[][] board) {
    if (x<0 || x>=m || y<0 || y>=n || board[x][y]!='O')
      return;
    int p = find(i*n + j);
    int q = find(x*n + y);
    if (sz[p]>sz[q]) {
      uf[q] = p;
      sz[p] += sz[q];
    } else {
      uf[p] = q;
      sz[q] += sz[p];
    }
  }

  int find(int node) {
    while (uf[node]!=node) {
      // compression path
      uf[node] = uf[uf[node]];
      node = uf[node];
    }
    return node;
  }

  private void change(int m, int n, char[][] board) {
    for (int i = 0; i<m; i++) {
      for (int j = 0; j<n; j++) {
        if (board[i][j]=='O' && !isConnect(i*n + j, m*n))
          board[i][j] = 'X';
      }
    }
  }

  private boolean isConnect(int p, int q) {
    return find(p)==find(q);
  }

  class UnionFind {
    private int size;
    int[] uf;
    int[] sz;

    UnionFind(int m, int n, char[][] board) {
      size = m*n + 1;
      uf = new int[size];
      sz = new int[size];
      Arrays.fill(sz, 1);
      for (int i = 0; i<m; i++) {
        for (int j = 0; j<n; j++) {
          if ((i==m - 1 || i==0 || j==0 || j==n - 1) && board[i][j]=='O') {
            uf[i*n + j] = m*n;
            sz[m*n]++;
          } else
            uf[i*n + j] = i*n + j;
        }
      }
      uf[m*n] = m*n;
    }

    // Weighted Quick-Union
    void connect(int i, int j, int x, int y, int m, int n, char[][] board) {
      if (x<0 || x>=m || y<0 || y>=n || board[x][y]!='O')
        return;
      int p = find(i*n + j);
      int q = find(x*n + y);
      if (sz[p]>sz[q]) {
        uf[q] = p;
        sz[p] += sz[q];
      } else {
        uf[p] = q;
        sz[q] += sz[p];
      }
    }

    int find(int node) {
      while (uf[node]!=node) {
        uf[node] = uf[uf[node]];
        node = uf[node];
      }
      return node;
    }

    public void change(int m, int n, char[][] board) {
      for (int i = 0; i<m; i++) {
        for (int j = 0; j<n; j++) {
          if (board[i][j]=='O' && !isConnect(i*n + j, m*n))
            board[i][j] = 'X';
        }
      }
    }

    private boolean isConnect(int p, int q) {
      return find(p)==find(q);
    }
  }
}
