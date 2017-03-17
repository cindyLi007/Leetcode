package com.google.bfs.dfs.bfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/2/2017.
 */
public class FindMHTs {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    /**
     * Returns an immutable list containing only the specified object, also has singletonMap, singleton(return a set)
     */
    if (n==1)
      return Collections.singletonList(0);

    // build graph
    List<Integer>[] graph = (List<Integer>[]) new List[n];
    for (int i = 0; i<n; i++)
      graph[i] = new LinkedList();
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    // init queue with all leaves nodes
    LinkedList<Integer> queue = new LinkedList();
    for (int i = 0; i<n; i++) {
      if (graph[i].size()==1)
        queue.offer(i);
    }

    /**
     * How many MHTs can a graph have at most? At most 2. So we just need one level by one level remove leave nodes
     * finally get 1 or 2 nodes which are root nodes. If we got 2, that means these 2 root nodes connected each other
    */
    while (n>2) {
      int size = queue.size();
      n -= size;
      for (int i = 0; i<size; i++) {
        int leave = queue.poll();
        int otherEnd = graph[leave].get(0);
        List<Integer> list = graph[otherEnd];
        // must use Object Integer, that means we remove the object, if we use leave, since it is an int, list will treat it as index
        list.remove(new Integer(leave));
        if (list.size()==1)
          queue.offer(otherEnd);
      }
    }
    return queue;
  }
}
