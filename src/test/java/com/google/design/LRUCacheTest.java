package com.google.design;

import org.junit.Test;

/**
 * Created by ychang on 3/16/2017.
 */
public class LRUCacheTest {
  @Test
  public void get() throws Exception {
    // Given
    LRUCache lruCache = new LRUCache(2);

    // When
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println("first get 1 " + lruCache.get(1));
    lruCache.put(3, 3);
    System.out.println("2nd get 2 " + lruCache.get(2));
    lruCache.put(4, 4);
    System.out.println("3rd get 1 " + lruCache.get(1));
    System.out.println("3rd get 3 " + lruCache.get(3));
    System.out.println("3rd get 4 " + lruCache.get(4));
  }

}