package com.google.bfs.dfs.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Maze {
    int M, N;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean hasPath_BFS(int[][] maze, int[] start, int[] destination) {
        M=maze.length; N=M==0 ? 0 : maze[0].length;
        if (Arrays.equals(start, destination)) return true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[][] visited=new boolean[M][N];
        visited[start[0]][start[1]]=true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x=cur[0], y=cur[1];
                // keep rolling in one direction until hit a wall
                while (x>=0 && y>=0 && x<M && y<N && maze[x][y]==0) {
                    x+=dir[0];
                    y+=dir[1];
                }
                x-=dir[0]; y-=dir[1];
                if (x==destination[0] && y==destination[1]) return true;
                if (!visited[x][y]) {
                    visited[x][y]=true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }

    public boolean hasPath_dfs(int[][] maze, int[] start, int[] destination) {
        M=maze.length;
        N=M==0? 0 : maze[0].length;
        boolean[][] visited = new boolean[M][N];
        visited[start[0]][start[1]] = true;
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] s, int[] t, boolean[][] visited) {
        if (Arrays.equals(s, t)) return true;
        for (int[] dir : dirs) {
            int x=s[0], y=s[1];
            while (x<M && y<N && x>=0 && y>=0 && maze[x][y]==0) {
                x+=dir[0];
                y+=dir[1];
            }
            x-=dir[0];
            y-=dir[1];
            if (!visited[x][y]) {
                visited[x][y]=true;
                if (dfs(maze, new int[]{x, y}, t, visited)) return true;
            }
        }
        return false;
    }
    
    public static void main(String... args) {
        Maze maze = new Maze();
        int[][] matrix = {{0,1,0,1,0,0,0,0,0,0,1},{0,1,0,1,1,1,0,1,1,0,0},{1,0,0,0,0,0,0,0,0,0,1},{0,0,0,1,1,1,0,1,0,0,1},
                {1,1,0,0,0,1,0,0,0,1,1},{0,1,0,0,0,0,0,1,0,1,0},{0,0,0,0,1,0,0,1,1,1,0}};
        boolean hasPath = maze.hasPath_dfs(matrix, new int[]{2, 1}, new int[]{1, 0});
    }
}
