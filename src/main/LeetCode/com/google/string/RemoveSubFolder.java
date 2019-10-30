package com.google.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Leetcode 1233
public class RemoveSubFolder {

  // Time: O(N*lgN)
  public static List<String> removeSubfolders(String[] folder) {
    List<String> res = new ArrayList();
    // 我们sort 所有folders 这样parent folder自然就排到了sub folder的前面
    Arrays.sort(folder);
    String cur = folder[0];
    res.add(cur);

    for (int i=1; i<folder.length; i++) {
      String s = folder[i];
      int idx = s.indexOf(cur);

      if (idx!=0 || idx==0 && s.charAt(cur.length())!='/') {
        cur = s;
        res.add(cur);
      }
    }
    return res;
  }

  public static void main(String... args) {
    String[] folder = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
    List<String> res = removeSubfolders(folder);
    res.stream().forEach(o-> System.out.println(o)); // ["/a","/c/d","/c/f"]
    System.out.println("*********************");

    String[] folder1 = new String[]{"/a","/a/b/c","/a/b/d"};
    List<String> res1 = removeSubfolders(folder1);
    res1.stream().forEach(o-> System.out.println(o)); // ["/a"]
    System.out.println("*********************");

    String[] folder2 = new String[]{"/a/b/c/","/a/b/ca","/a/b/d"};
    List<String> res2 = removeSubfolders(folder2);
    res2.stream().forEach(o-> System.out.println(o)); // "/a/b/c","/a/b/ca","/a/b/d"
  }
}
