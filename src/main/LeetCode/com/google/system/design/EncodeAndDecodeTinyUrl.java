package com.google.system.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 9/18/2017.
 */
public class EncodeAndDecodeTinyUrl {
  Map<Integer, String> stol;
  Map<String, Integer> ltos;
  static int counter;
  final String ELEMENTS;

  public EncodeAndDecodeTinyUrl() {
    stol = new HashMap();
    ltos = new HashMap();
    counter = 1;
    ELEMENTS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  }

  private String base10To62(int n) {
    StringBuilder sb = new StringBuilder();
    while (n!=0) {
      sb.insert(0, ELEMENTS.charAt(n%62));
      n/=62;
    }
    while (sb.length()<7) sb.insert(0, '0');
    return sb.toString();
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String shortUrl = base10To62(counter);
    stol.put(counter, longUrl);
    ltos.put(longUrl, counter);
    counter++;
    return "http://tinyurl.com/" + shortUrl;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    shortUrl = shortUrl.substring("http://tinyurl.com/".length());
    int id = base62To10(shortUrl);
    return stol.get(id);
  }

  private int base62To10(String s) {
    int n=0;
    for (int i=0; i<s.length(); i++) {
      n = n*62 + convert(s.charAt(i));
    }
    return n;
  }

  private int convert(char c) {
    if (c<='9' && c>='0') return c-'0';
    else if (c<='z' && c>='a') return c-'a'+10;
    else if (c<='Z' && c>='A') return c-'A'+36;
    return -1;
  }

}
