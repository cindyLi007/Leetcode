package com.google.string;

/**
 * Created by ychang on 7/23/2017.
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 * NOTICE: Java is parse by value, which mean when we parse an array, we can only change the value of array[i], but if we set
 * array = a new array, outside the method, the array is still the original one. that is the reason we can only do it in-place
 * for example, if we create a new char[] with word-reversed-value, and we set it to s, outside the reverseWords method, the
 * value of s does not change.
 */
public class ReverseWordsII {
  public void reverseWords(char[] s) {
    int start = 0, end = s.length - 1;
    if (start>=end)
      return;
    // 1. reverse whole string, so all words are reversed
    reverse(s, start, end);
    // 2. reverse each word back
    for (int i = 0; i<=end; i++) {
      if (s[i]==' ') {
        reverse(s, start, i - 1);
        start = i + 1;
      }
    }
    // 3. handle the last word or there is only one word in the char array
    reverse(s, start, end);
  }

  private void reverse(char[] str, int s, int e) {
    while (s<e) {
      char temp = str[s];
      str[s++] = str[e];
      str[e--] = temp;
    }
  }

  /**
   * Given an input string, reverse the string word by word.
   * How about multiple spaces between two words?
   * Reduce them to a single space in the reversed string.
   * in Java, split by single space, use .split(" ") or .split("\\s")
   * Split by multiple space/whitespace, use .split("\\s+")
   */
  public String reverseWords(String s) {
    String[] words = s.split("\\s+"); // split by multiple space
    StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i>=0; i--) {
      sb.append(words[i]).append(" ");
    }
    return sb.toString().trim();
  }

  public String reverseWords_woSplit(String s) {
    // first clean up all extra space
    char[] str = s.toCharArray();
    s = clean(str, str.length);
    // reverse the whole s
    str = s.toCharArray();
    reverse(str, 0, str.length-1);
    // reverse each word
    int start=0;
    for (int i=0; i<str.length; i++) {
      if (str[i]==' ')  {
        reverse(str, start, i-1);
        start=i+1;
      }
    }
    reverse(str, start, str.length-1);
    return String.valueOf(str);
  }

  private String clean(char[] a, int n) {
    int i = 0, j = 0;

    while (j < n) {
      while (j < n && a[j] == ' ') j++;             // skip String leading spaces
      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep words
      while (j < n && a[j] == ' ') j++;             // skip spaces, jump to next word beginning
      if (j < n) a[i++] = ' ';                      // keep only one space
    }

    return new String(a).substring(0, i); // now i is the pos after one space
  }

}
