package com.google.system.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 9/18/2017.
 */
public class TinyURL {
  Map<Integer, String> stol; // read
  Map<String, Integer> ltos;  // write
  static int counter;
  final String ELEMENTS;

  public TinyURL() {
    stol = new HashMap();
    ltos = new HashMap();
    counter = 1;
    ELEMENTS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  }

  // insert a new URL, notice now the shortUrl (alias) is unrelated to url, it is a sequential id rendered from counter
  public synchronized String longToShort(String url) {
    String shortUrl = base10To62(counter); // from counter to a 7-length string
    stol.put(counter, url);
    ltos.put(url, counter);
    counter++;
    return "http://tiny.url/" + shortUrl;
  }

  // pass counter to this method, that is because Java is pass by value, we will not change counter's value outside this method
  private String base10To62(int n) {
    StringBuilder sb = new StringBuilder();
    while (n!=0) {
      sb.insert(0, ELEMENTS.charAt(n%62));
      n /= 62;
    }
    while (sb.length()<7)
      sb.insert(0, '0');
    return sb.toString();
  }

  private int base62to10(String url) {
    int res = 0;
    for (int i = 0; i<url.length(); i++) {
      char c = url.charAt(i);
      res = res*62 + convert(c);
    }
    return res;
  }

  private int convert(char c) {
    if (c<='9' && c>='0') {
      return c - '0';
    } else if (c<='z' && c>='a') {
      return c - 'a' + 10;
    } else if (c<='Z' && c>='A') {
      return c - 'A' + 36;
    }
    return -1;
  }

  public String shortToLong(String url) {
    url = url.substring("http://tiny.url/".length());
    int id = base62to10(url);
    return stol.get(id);
  }
}