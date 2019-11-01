package com.google.string;

public class AddBoldTag {
  public static String addBoldTag(String s, String[] dict) {
    int N = s.length();
    boolean[] mark = new boolean[N];
    // Time: O(L*L*N)
    for (int i=0; i<N; i++) {
      for (String w : dict) {
        if (s.startsWith(w, i)) {
          for (int j=i; j<i+w.length(); j++) mark[j]=true;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<N; i++) {
      if (mark[i] && (i==0 || !mark[i-1])) sb.append("<b>");
      sb.append(s.charAt(i));
      if (mark[i] && (i==N-1 || !mark[i+1])) sb.append("</b>");
    }
    return sb.toString();
  }

  public static void main(String... args) {
    System.out.println(addBoldTag("abcxyz123", new String[]{"abc", "123"}));
  }
}
