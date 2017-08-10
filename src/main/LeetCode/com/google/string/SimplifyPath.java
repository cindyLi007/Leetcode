package com.google.string;

import java.util.Stack;

/**
 * Created by ychang on 5/10/2017.
 */
public class SimplifyPath {
  public String simplifyPath_woStack(String path) {
    if (path==null || path.length()==0)
      return path;
    String[] paths = path.split("/");
    String[] res = new String[paths.length];
    int index = 0;
    for (int i = 0; i<paths.length; i++) {
      switch (paths[i]) {
        case ".":
        case "":
          continue;
        case "..":
          if (index>0)
            index--;
          break;
        default:
          res[index++] = paths[i];
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i<index; i++) {
      sb.append("/").append(res[i]);
    }
    return sb.length()==0 ? "/" : sb.toString();
  }

  public String simplifyPath(String path) {
    Stack<String> stack = new Stack();
    String[] paths = path.split("/");
    for (String s : paths) {
      if (s.equals("..") && !stack.isEmpty()) stack.pop();
      else if (!s.equals(".")) stack.push(s);
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append("/").append(stack.pop());
    }
    return sb.length()==0 ? "/" : sb.toString();
  }
}


