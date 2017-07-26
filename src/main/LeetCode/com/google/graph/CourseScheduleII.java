package com.google.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ychang on 6/2/2017.
 */
public class CourseScheduleII {
  /**
   * this can beat 78%. This dfs is from any point of graph, if there is no out-edge, put it in the bottom of the stack,
   * otherwise, first dfs all it's out-edge points, means push all depend-on-this-point points BEFORE this point to stack
   * so when pop points from stack, the top point must be the point which no points pointing to it. During this process,
   * also check whether there is a loop.
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList();
    for (int i = 0; i<numCourses; i++)
      graph.add(new LinkedList());
    for (int[] edge : prerequisites) {
      graph.get(edge[1]).add(edge[0]);
    }
    boolean[] visited = new boolean[numCourses], inStack = new boolean[numCourses];
    Stack<Integer> stack = new Stack();
    for (int i = 0; i<numCourses; i++) {
      if (!dfs(graph, i, stack, visited, inStack))
        return new int[0];
    }
    int[] res = new int[numCourses];
    int i = 0;
    while (!stack.isEmpty())
      res[i++] = stack.pop();
    return res;
  }

  private boolean dfs(List<List<Integer>> graph, int course, Stack<Integer> stack, boolean[] visited, boolean[] inStack) {
    if (inStack[course])
      return false;
    if (visited[course])
      return true;
    inStack[course] = true;
    visited[course] = true;
    for (Integer i : graph.get(course)) {
      if (!dfs(graph, i, stack, visited, inStack))
        return false;
    }
    stack.push(course);
    inStack[course] = false;
    return true;
  }

  /**
   * this can beat 71.43%
   */
  public int[] findOrder_BFS(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList();
    for (int i = 0; i<numCourses; i++)
      graph.add(new LinkedList());
    for (int[] edge : prerequisites) {
      inDegree[edge[0]]++;
      graph.get(edge[1]).add(edge[0]);
    }
    Queue<Integer> queue = new LinkedList();
    for (int i = 0; i<numCourses; i++) {
      if (inDegree[i]==0)
        queue.offer(i);
    }
    int i = 0;
    int[] res = new int[numCourses];
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      res[i++] = cur;
      for (int n : graph.get(cur)) {
        if (--inDegree[n]==0)
          queue.offer(n);
      }
    }
    return (i==numCourses) ? res : new int[0];
  }
}
