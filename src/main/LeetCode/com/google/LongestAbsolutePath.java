package com.google;

import java.util.Stack;

/**
 * Stack, anytime, keep the stack has a infrastructure of current path.
 */
public class LongestAbsolutePath {

  public static void main(String[] args) {
    System.out.println("max length is " + lengthLongestPath("a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
  }

  public static int lengthLongestPath(String input) {
    int maxLen = 0;
    Stack<Integer> stack = new Stack<>();
    for (String s : input.split("\n")) {
      int layer = s.lastIndexOf("\t") + 1;
      // pop out till this dir/file root dir, must be "while" instead of "if", stack should only store current dir/file parent dir
      while (layer < stack.size()) {
        stack.pop();
      }
      int length = stack.isEmpty() ? s.length() : stack.peek() + s.length() - layer + 1;
      if (s.contains(".")) {
        maxLen = Math.max(length, maxLen);
      } else {
        stack.push(length);
      }
    }
    return maxLen;
  }

  public static int lengthLongestPathArray(String input) {
    int maxLen = 0;
    String[] strings = input.split("\n");
    int[] stack = new int[strings.length];
    for (String s : strings) {
      int layer = s.lastIndexOf("\t") + 1;
      int len = s.substring(layer).length();
      int length = layer == 0 ? len : stack[layer-1] + len + 1;
      stack[layer] = length;
      if (s.contains(".")) {
        maxLen = Math.max(maxLen, length);
      }
    }
    return maxLen;
  }
}
