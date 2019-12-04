package com.google.bfs.dfs.bfs;

import java.util.*;

// 这道题骨子里还是BFS，因为是从一种状态到另一种状态的转变的最小路径，而判断两钟状态之间是否可以转换的方法是看是否可以把0和它周围的数字替换
public class SlidingPuzzles {
    int N, M;
    public int slidingPuzzle(int[][] board) {
        N = board.length; M = N==0 ? 0 : board[0].length;

        if (N==0 || M==0) return -1;
        String t = "123450";

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                sb.append(board[i][j]);
            }
        }
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        visited.add(sb.toString());
        queue.add(sb.toString());
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String cur = queue.poll();
                if (cur.equals(t)) return cnt;
                int pos = cur.indexOf("0");
                int[] move = dirs[pos];
                for (int m : move) {
                    String next = swap(cur, pos, m);
                    if (visited.add(next)) {
                        queue.add(next);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] ch = s.toCharArray();
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
        List<int[]> list = new LinkedList<>();
        Integer integer = Integer.valueOf(i);

        return String.valueOf(ch);
    }

    public static void main(String... args) {
        SlidingPuzzles slidingPuzzles = new SlidingPuzzles();
        int res = slidingPuzzles.slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}});
        System.out.println(res);
    }
}
