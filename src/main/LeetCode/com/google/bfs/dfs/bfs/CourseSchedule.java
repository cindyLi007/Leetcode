package com.google.bfs.dfs.bfs;

import java.util.*;

/**
 * Created by ychang on 3/1/2017.
 */
public class CourseSchedule {
  /**
   * each level is current zero-indegree nodes, if initialize queue is empty, that means there is a cycle for all nodes
   * each step is 1) remove all edges from current level nodes,
   * 2) find all nodes which can only be reached from current level nodes, and put them to queue.
   * 3) count_bruteForce all zero-indegree nodes,
   * if after queue is empty, there are some nodes which indegree are still not zero, that means there is a cycle.
   */
  public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = (List<Integer>[])new List[numCourses];
    for (int i=0; i<numCourses; i++) graph[i]=new ArrayList();
    int[] inDegree = new int[numCourses];

    for (int[] p : prerequisites) {
      int v1=p[1], v2=p[0];
      inDegree[v2]++;
      graph[v1].add(v2);
    }

    Deque<Integer> queue = new ArrayDeque<>();
    for (int i=0; i<numCourses; i++) {
      if (inDegree[i]==0) queue.offer(i);
    }

    while (!queue.isEmpty()) {
      numCourses--;
      int cur = queue.poll();
      for (int i : graph[cur]) {
        inDegree[i]--;
        if (inDegree[i]==0) queue.offer(i);
      }
    }
    return numCourses==0;
  }

  /**
   * this can beat 90%
   */
  public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
    boolean[] inStack = new boolean[numCourses];
    /**
     *  we must have a marked array to record already-visited course, because we use dfs, it can avoid TLE
     */
    boolean[] marked = new boolean[numCourses];
    // build a set of all preliminary course, it is a (pre-course -> bag of all its dependent courses) map
    List<List<Integer>> graph = new ArrayList();
    for (int i = 0; i<numCourses; i++)
      graph.add(new LinkedList());
    for (int[] edge : prerequisites)
      graph.get(edge[1]).add(edge[0]);
    for (int i = 0; i<numCourses; i++) {
      if (!dfs(i, graph, marked, inStack))
        return false;
    }
    return true;
  }

  private boolean dfs(int course, List<List<Integer>> graph, boolean[] visited, boolean[] inStack) {
    if (inStack[course])
      return false;
    if (visited[course])
      return true;
    visited[course] = true;
    inStack[course] = true;
    for (Integer i : graph.get(course)) {
      if (!dfs(i, graph, visited, inStack))
        return false;
    }
    inStack[course] = false;
    return true;
  }
}
