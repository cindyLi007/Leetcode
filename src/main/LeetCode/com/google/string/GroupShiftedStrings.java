package com.google.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strings) {
      map.computeIfAbsent(renderCode(s), o->new ArrayList<String>()).add(s);
    }
    return new ArrayList<>(map.values());
  }

  private String renderCode(String s) {
    int offset = s.charAt(0) - 'a';
    int N = s.length();
    char[] ch = s.toCharArray();
    for (int i=0; i<N; i++) {
      ch[i] = (char)(ch[i]- offset);
      if (ch[i] < 'a') ch[i]+=26;
    }
    return String.valueOf(ch);
  }

  public static void main(String... args) {
    GroupShiftedStrings groupShiftedStrings = new GroupShiftedStrings();
    List<List<String>> lists = groupShiftedStrings.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "ac", "ba", "a", "z"});
    for (List<String> list : lists) {
      list.stream().forEach(o -> System.out.print(o + ", "));
      System.out.println();
    }
  }
}
