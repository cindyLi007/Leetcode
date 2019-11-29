package com.google.stack;

import java.util.Stack;

/**
 * Created by ychang on 12/8/2016.
 * '[' is an end point of times, a start point of new inner level String, so push old current String to StrStack
 * ']' is an end point of current level string, where need re-construct "current" String (repeat times of current string
 * and concat it to outer-level string, outer-level string is stored in strStack pop)
 * current String represent the current level string we are dealing with. When finish parsing s, we are in the most-outer
 * level, and the current string is the result
 * We must first add an empty string to strStack, so in the end of ths String, append the final string to the empty one
 */
public class DecodeString {
  public String decodeString(String s) {
    Stack<Integer> numStack = new Stack();
    Stack<StringBuilder> strStack = new Stack();
    StringBuilder current=new StringBuilder();
    int times=0;
    for (char c : s.toCharArray()) {
      if (c=='[') {
        numStack.push(times);
        strStack.push(current);
        current = new StringBuilder();
        times=0;
      } else if (c==']') {
        StringBuilder sb = new StringBuilder();
        for (int j=numStack.pop(); j>0;j--) {
          sb.append(current);
        }
        current = strStack.pop().append(sb);
      } else if (Character.isDigit(c)) {
        times=times*10 + (c-'0');
      } else {
        current.append(c);
      }
    }
    return current.toString();
  }

  int i=0, N;
  public String decodeString_recursive(String s) {
    StringBuilder sb = new StringBuilder();
    int num = 0, N = s.length();
    while (i<N && s.charAt(i)!=']') {
      char c = s.charAt(i++);
      if (c=='[') { // go to deeper
        String inner = decodeString_recursive(s);
        for (int t=0; t<num; t++) {
          sb.append(inner);
        }
        num = 0;
      } else if (Character.isLetter(c)) {
        sb.append(c);
      } else { // number
        num = num*10 + (c-'0');
      }
    }
    i++;
    return sb.toString();
  }

  public static void main(String[] main) {
    DecodeString instance = new DecodeString();
    String s = instance.decodeString_recursive("3[a]2[bc]");// return "aaabcbc".
    System.out.println(s + " " + s.equals("aaabcbc"));
    s = instance.decodeString("3[a2[c]]"); //return "accaccacc".
    System.out.println(s + " " + s.equals("accaccacc"));
    s = instance.decodeString("2[abc]3[cd]ef"); // return "abcabccdcdcdef".
    System.out.println(s + " " + s.equals("abcabccdcdcdef"));
  }
}
