package com.google.string;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 6/4/2017.
 */
public class TextJustification {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new LinkedList();
    for (int i = 0, w; i<words.length; i = w) {
      int len = -1; // set to -1 to netural the last word space
      for (w = i; w<words.length && words[w].length() + 1 + len<=maxWidth; w++) {
        len += words[w].length() + 1;
      }
      int diff = maxWidth - len, m = 1, n = 0;
      if (w - 1!=i && w!=words.length) { // there is more than one word in the line and it is NOT the last line
        m = diff/(w - 1 - i) + 1;
        n = diff%(w - 1 - i);
      }
      StringBuilder sb = new StringBuilder(words[i]);
      // append space and next word, if there is only one word, skip this step, if it is the last line, only instert one space
      for (int j = i + 1; j<w; j++) {
        for (int s = 0; s<m; s++)
          sb.append(' ');
        if (n-->0)
          sb.append(' ');
        sb.append(words[j]);
      }
      diff = maxWidth - sb.length();
      while (diff-->0)
        sb.append(' ');
      res.add(sb.toString());
    }
    return res;
  }
}
