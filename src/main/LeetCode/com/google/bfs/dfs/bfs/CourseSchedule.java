package com.google.bfs.dfs.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by ychang on 3/1/2017.
 */
public class CourseSchedule {
  /**
   * each level is current zero-indegree nodes, if initialize queue is empty, that means there is a cycle for all nodes
   * each step is 1) remove all edges from current level nodes,
   * 2) find all nodes which can only be reached from current level nodes, and put them to queue.
   * 3) count all zero-indegree nodes,
   * if after queue is empty, there are some nodes which indegree are still not zero, that means there is a cycle.
   */
  public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    Map<Integer, List<Integer>> map = new HashMap();
    for (int[] pre : prerequisites) {
      indegree[pre[0]]++;
      map.computeIfAbsent(pre[1], k->new LinkedList()).add(pre[0]);
    }
    // init queue with all zero-indegree nodes
    Queue<Integer> queue = new LinkedList();
    for (int i=0; i<numCourses; i++) {
      if (indegree[i]==0) queue.offer(i);
    }
    int count=queue.size();
    while(!queue.isEmpty()) {
      int size=queue.size();
      for (int i=0; i<size; i++) {
        List<Integer> course = map.get(queue.poll());
        if (course==null || course.size()==0) continue;
        for (Integer c : course) {
          indegree[c]--;
          if (indegree[c]==0) {
            queue.offer(c);
            count++;
          }
        }
      }
    }
    return count==numCourses;
  }


  public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
    boolean[] inStack = new boolean[numCourses];
    /**
     *  we must have a marked array to record already-visited course, because we use dfs, it can avoid TLE
     */
    boolean[] marked = new boolean[numCourses];
    // build a set of all preliminary course, it is a (pre-course -> bag of all its dependent courses) map
    Map<Integer, List<Integer>> map = new HashMap();
    for (int[] pre : prerequisites) {
      map.computeIfAbsent(pre[1], k->new LinkedList()).add(pre[0]);
    }
    for (Integer key : map.keySet()) {
      if (!marked[key] && !dfs(key, map, inStack, marked)) return false;
    }
    return true;
  }

  private boolean dfs(int course, Map<Integer, List<Integer>> map, boolean[] inStack, boolean[] marked) {
    marked[course]=true;
    inStack[course]=true;
    List<Integer> depCourse = map.get(course);
    while (depCourse!=null && !depCourse.isEmpty()) {
      /**
       * we should remove this edge after using it to avoid TLE, because it is DFS
       */
      int c = depCourse.remove(0);
      if (inStack[c]) return false;
      if (!marked[c] && !dfs(c, map, inStack, marked)) return false;
    }
    inStack[course]=false;
    return true;
  }
}
