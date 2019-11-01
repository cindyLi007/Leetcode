package com.google;

import java.util.Stack;

/**
 * Stack, anytime, keep the stack has a infrastructure of current path.
 */
public class LongestAbsolutePath {

  public static void main(String[] args) {
    System.out.println("max length is " + lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    System.out.println("max length is " + lengthLongestPathArray("a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
  }

  public static int lengthLongestPath(String input) {
    int maxLen = 0;
    Stack<Integer> stack = new Stack<>();
    String[] split = input.split("\n");
    for (String s : split) {
      /**
       * must use lastIndexOf to find the last \t, that is indicate layer
       */
      int layer = s.lastIndexOf("\t") + 1;
      // pop out till this dir/file root dir, must be "while" instead of "if", stack should only store current dir/file parent dir
      while (layer<stack.size()) {
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
      int length = layer==0 ? s.length() : stack[layer - 1] + s.length() - layer + 1; // this +1 is to add "/" for path
      // 我们总是在现在处理的path上，so it does not matter to erase previously some layer path length, because we are done for that path
      stack[layer] = length;
      if (s.contains(".")) {
        maxLen = Math.max(maxLen, length);
      }
    }
    return maxLen;
  }
}
