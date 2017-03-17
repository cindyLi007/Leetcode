package com.google.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 12/15/2016.
 * The key point to encode is to include length of the String in the front of the String, so when decode we can skip
 * the content of the String. To differentiate the number belongs to String and the length number we added,
 * for example, String is "3abc", 3 is part of the String, without '/', it will be 43abc
 * we need add a '/' after the length. so the format is "length number" + '/' + String, such as 4/3abc
 * we need not worry about any '/' in the middle of the string, since we will skip it
 */
public class EncodeAndDecode {
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s.length()).append('/').append(s);
    }
    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List<String> list = new LinkedList();
    int i=0;
    while(i<s.length()) {
      int start = s.indexOf('/', i);
      int len = Integer.parseInt(s.substring(i, start));
      list.add(s.substring(start+1, start+1+len));
      i=start+1+len;
    }
    return list;
  }

  public static void main(String[] args) {
    EncodeAndDecode ead = new EncodeAndDecode();
    List<String> list = Arrays.asList(new String[]{"63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "});
    String encodeString = ead.encode(list);
    List<String> decodeList = ead.decode(encodeString);
    decodeList.forEach(System.out::println);
  }
}
