package com.cgi.collection;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by ychang on 7/28/2016.
 */
public class MapExample {

  public static void main(String[] args) {
    Map<String, String> partList = new TreeMap<>();

    partList.put("s001", "Blue Polo Shirt");
    partList.put("s002", "Black Polo Shirt");
    partList.put("h001", "Duke Hat");

    partList.put("s002", "Black t-shirt");

    Set<String> keys = partList.keySet();

    System.out.println("---- Part List -----");
    for (String key : keys) {
      System.out.println("Part #" + key + " " + partList.get(key));
    }

  }
}
