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
  public List<String> removeInvalidParentheses_BFS(String s) {
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

  // Time: O(2^N)
  public List<String> removeInvalidParentheses_DFS(String s) {
    // 非常巧妙的先求出最小remove的左括号和右括号
    int leftShouldRemove = 0, rightShouldRemove = 0;
    for (char c : s.toCharArray()) {
      if (c=='(') leftShouldRemove++;
      if (c==')') {
        if (leftShouldRemove>0) leftShouldRemove--;
        else rightShouldRemove++;
      }
    }
    Set<String> set = new HashSet();
    dfs(s, 0, "", set, leftShouldRemove, rightShouldRemove, 0);
    return new ArrayList(set);
  }

  /**
   * @param left how many left parentheses should be removed
   * @param right how many right parenthese should be removed
   * @param open how many opened parenthese(left) in prefix open should always >=0, 这是因为任何时候都要保证左括号>=右括号
   */
  private void dfs(String s, int idx, String prefix, Set<String> set, int left, int right, int open) {
    if (idx==s.length()) {
      if (left==0 && right==0 && open==0) set.add(prefix);
    } else {
      char c = s.charAt(idx);
      if (c=='(') {
        dfs(s, idx+1, prefix+c, set, left, right, open+1);
        if (left>0) dfs(s, idx+1, prefix, set, left-1, right, open);
      } else if (c==')') {
        if (open>0) dfs(s, idx+1, prefix+c, set, left, right, open-1);
        if (right>0) dfs(s, idx+1, prefix, set, left, right-1, open);
      } else {
        dfs(s, idx+1, prefix+c, set, left, right, open);
      }
    }
  }
}