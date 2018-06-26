package com.google.string;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 *  whitespace and initial word order.

    Example 1:
    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

    Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordIII {

  public String reverseWords(String s) {
    String[] str = s.split("\\s");
    StringBuilder sb = new StringBuilder();
    for (String ss : str) {
      sb.append(reverse(ss)).append(" ");
    }
    return sb.toString().trim();
  }

  private String reverse(String s) {
    StringBuilder sb = new StringBuilder(s);
    return sb.reverse().toString();
  }

}
