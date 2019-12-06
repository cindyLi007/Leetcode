package com.google;

/**
 * Created by ychang on 11/23/2016.
 */
public class SentenceScreenFitting {
  public static void main(String[] args) {
    int result = wordsTypeDp(new String[]{"Hello", "World"}, 2, 8); // 1
    System.out.println(result);
    result = wordsTyping_TLE(new String[]{"Hello", "leetcode"}, 1, 10); // 0
    System.out.println(result);
    result = wordsTyping_TLE(new String[]{"a", "bcd", "e"}, 3, 6); // 2
    System.out.println(result);
    result = wordsTyping_TLE(new String[]{"I", "had", "apple", "pie"}, 4, 5); // 1
    System.out.println(result);
    result = wordsTyping_TLE(new String[]{"f", "p", "a"}, 8, 7); // 10
    System.out.println(result);
  }

  public int wordsTyping(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + " ";
    int L = s.length();
    int curIdx = 0;
    // process by every line
    for (int i=0; i<rows; i++) {
      // curIdx is index of sentence, each round it points to the index of s which will be put in the 1st position in next row
      // (curIdx + cols) means with one row, from this idx, it can go to where of the sentence
      // because (curIdx + cols) can be exceeds the length of the string, so we need use curIdx % L for correct idx
      curIdx+=cols;
      // if the letter put in the beginning of next row is a space, we need not reserve it
      // just move forward the curIdx
      if (s.charAt(curIdx%L)==' ') curIdx++;
      else {
        //if hit a letter, need backtrack to the last previous space to keep the word non-breaking
        while (curIdx>0 && s.charAt(curIdx%L)!=' ') curIdx--;
        curIdx++;
      }
    }
    return curIdx/L;
  }

  public static int wordsTypeDp(String[] sentence, int rows, int cols) {
    // NOTICE: need put a space after join, because String.join only put delimiter between strings INSIDE the connected strings.
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

  // This is a wrong way to solve this problem, although it can pass the OJ. We should not pass words in sentence one by one
  // Remember it could fit in one row for the whole sentence. Or one row can contains multiple sentences.
  // so we should parse for one ROW each time
  public static int wordsTyping_TLE(String[] sentence, int rows, int cols) {
    int i=0, res=0, j=0;
    while (i<rows) {
      for (int k=0; i<rows && k<sentence.length; k++) {
        String s = sentence[k];
        int len = s.length();
        if (cols-j < len) {
          i++; j=0;
          k--;
        } else {
          j += len + 1;
        }
      }
      if (i<rows) res++;
    }
    return res;
  }

}
