package com.google;

/**
 * Created by ychang on 11/23/2016.
 */
public class SentenceScreenFitting {
  public static void main(String[] args) {
//    int result = wordsTyping(new String[]{"Hello", "World"}, 2, 8);
//    int result = wordsTyping(new String[]{"Hello", "leetcode"}, 1, 10);
//    int result = wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6);
    int result = wordsTyping(new String[]{"I", "had", "apple", "pie"}, 4, 5);
    System.out.println(result);
  }

  public static int wordsTyping(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + " ";
    int current = 0, len = s.length();
    for (int i = 0; i < rows; i++) {
      current += cols;
      char c = s.charAt(current%len);
      if (c == ' ') current++;
      else {
        // Here must be current-1 instead of current, because if current is the 1st char of a word, we need NOT current--
        while (current > 0 && s.charAt((current - 1)%len) != ' ')
          current--;
      }
    }
    return current/len;
  }

  public static int wordsTypeDp(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + " ";
    int current = 0, len = s.length();
    int[] map = new int[len];
    /*
      For any index i for sentence string s, the map[i] defined here is the distance from char s[i] to the initial
      position of current word, where going forward is positive distance and backward is negative distance.
      For example, let s = "abc df gherg gerg fd", then map[9] = -2 since we need to go backward 2 positions from s[9]='e'
      to the initial position of current word "gherg". Also, it always defines the current word for a white space is the
      word right next to it, so for s[3] = ' ', map[3] = 1 since the initial position of current word "df" is one
      position right next to s[3].
      The purpose for this map array is simply to decide how a word's position on screen should be adjusted when the word
      would have to be broken into two lines if had printed sequentially.
    */
    for (int i = 1; i < len; i++) {
      map[i] = s.charAt(i) == ' ' ? 1 : map[i - 1] - 1;
    }
    for (int i = 0; i < rows; i++) {
      current += cols; // jump to next line first char
      current += map[current%len];
    }
    return current/len;
  }
}
