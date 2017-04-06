package com.google.backtracking;

/**
 * Created by ychang on 4/2/2017.
 */
public class AndroidUnlockPatterns {
  public int numberOfPatterns(int m, int n) {
    int[][] pass = new int[10][10];
    pass[1][3]=pass[3][1]=2;
    pass[1][7]=pass[7][1]=4;
    pass[9][3]=pass[3][9]=6;
    pass[7][9]=pass[9][7]=8;
    pass[1][9]=pass[9][1]=pass[3][7]=pass[7][3]=pass[2][8]=pass[8][2]=pass[4][6]=pass[6][4]=5;

    int res=0;
    boolean[] visited = new boolean[10];

    for (int i=m; i<=n; i++) {
      res += dfs(pass, 1, i-1, visited)*4;
      res += dfs(pass, 2, i-1, visited)*4;
      res += dfs(pass, 5, i-1, visited);
    }

    return res;
  }

  int dfs(int[][] pass, int key, int remain, boolean[] visited) {
    if (remain==0) return 1;
    visited[key]=true;
    int res=0;
    for (int i=1; i<=9; i++) {
      if (!visited[i] && (pass[key][i]==0 || visited[pass[key][i]]))
        res+=dfs(pass, i, remain-1, visited);
    }
    visited[key]=false;
    return res;
  }
}
