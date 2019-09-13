package com.google.dp;

import java.util.*;

public class ParallelCourse {
  int res = -1;

  // Time: O(V+E), Space: O(V+E)
  public int minimumSemesters(int N, int[][] relatinons) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    // build a graph, course, all prerequisite course of it
    for (int[] edge : relatinons) {
      if (!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<>());
      graph.get(edge[1]).add(edge[0]);
    }
    if (graph.size()==N) return -1;

    // for all there is no prerequisite courses, the max semester is 1
    int[] dp = new int[N+1];
    for (int i=1; i<=N; i++) {
      if (!graph.containsKey(i))
        dp[i] = 1;
    }

    // for each course, dfs it to check whether there is loop and it's depth
    for (Integer course : graph.keySet()) {
      dfs(dp, graph, course);
    }
    return res;
  }

  private int dfs(int[] dp, Map<Integer, List<Integer>> graph, int course) {
    if (dp[course]!=0) return dp[course];
    // we first set it to -1 means we are visiting it
    dp[course] = -1;
    // max is the course max semester
    int max = -1;
    for (Integer prev : graph.get(course)) {
      int temp = dfs(dp, graph, prev);
      if (temp < 0) return -1;
      max = Math.max(temp + 1, max);
    }
    dp[course] = max;
    res = Math.max(res, max);
    return max;
  }


  public static int minimumSemesters_BFS(int N, int[][] relations) {
    Map<Integer, List<Integer>> g = new HashMap<>(); // key: prerequisite, value: course list.
    int[] inDegree = new int[N + 1]; // inDegree[i]: number of prerequisites for i.
    for (int[] r : relations) {
      g.computeIfAbsent(r[0], l -> new ArrayList<>()).add(r[1]); // construct graph.
      ++inDegree[r[1]]; // count prerequisites for r[1].
    }
    Queue<Integer> q = new LinkedList<>(); // save current 0 in-degree vertices.
    for (int i = 1; i <= N; ++i)
      if (inDegree[i] == 0)
        q.offer(i);
    int semester = 0;

    // because if there exists a loop, no node has inDegree ==0, so q is empty
    while (!q.isEmpty()) { // BFS traverse all currently 0 in degree vertices.
      for (int sz = q.size(); sz > 0; --sz) { // sz is the search breadth.
        int c = q.poll();
        --N;
        if (!g.containsKey(c)) continue;
        for (int course : g.remove(c))
          if (--inDegree[course] == 0) // decrease the in-degree of course's neighbors.
            q.offer(course); // add current 0 in-degree vertex into Queue.
      }
      ++semester; // need one more semester.
    }
    return N == 0 ? semester : -1;
  }

  public static void main(String... args) {
    ParallelCourse parallelCourse = new ParallelCourse();
    System.out.println(parallelCourse.minimumSemesters(3, new int[][]{{1, 3}, {2, 3}})); // should be 2
    System.out.println(parallelCourse.minimumSemesters_BFS(3, new int[][]{{1, 2}, {2, 3}, {3, 1}})); // should be 2
  }
}
