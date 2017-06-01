package com.google.bfs.dfs.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ychang on 5/3/2017.
 * From the original string, remove every single "(" or ")", see whether can make a valid one, put it in queue.
 * BFS can guarantee the first found in queue is minimum number removal
 * can beat 26%
 */
public class RemoveInvalidParentheses {
  public List<String> removeInvalidParentheses(String s) {
    List<String> res = new ArrayList();
    Queue<String> queue = new LinkedList();
    Set<String> visited = new HashSet();
    queue.offer(s);
    visited.add(s);
    boolean found=false;

    while (!queue.isEmpty()) {
      String cur = queue.poll();
      if (isValid(cur)) {
        res.add(cur);
        found=true;
      }
      if (found) continue;
      for (int i=0; i<cur.length(); i++) {
        if (cur.charAt(i)=='(' || cur.charAt(i)==')') {
          String revised = cur.substring(0, i) + cur.substring(i+1);
          if (!visited.contains(revised)) {
            visited.add(revised);
            queue.offer(revised);
          }
        }
      }
    }
    return res;
  }

  private boolean isValid(String s) {
    int count=0;
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i)=='(') count++;
      if (s.charAt(i)==')') count--;
      if (count<0) return false;
    }
    return count==0;
  }
}
