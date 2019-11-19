package com.google.design;

import org.junit.Test;

/**
 * Created by ychang on 3/17/2017.
 */
public class LFUCacheTest {
  @Test
  public void get() throws Exception {
    // Given
    LFU lfuCache = new LFU(2);

    // when
    lfuCache.put(1, 1);
    lfuCache.put(2, 2);
    System.out.println("should be 1 * " + lfuCache.get(1));
    System.out.println("should be 1 * " + lfuCache.get(2));
    System.out.println("should be 1 * " + lfuCache.get(2));
    lfuCache.put(3, 3);
    System.out.println("should be -1 * " + lfuCache.get(2));
    System.out.println("should be 3 * " + lfuCache.get(3));
    lfuCache.put(4, 4);
    System.out.println("should be -1 * " + lfuCache.get(1));
    System.out.println("should be 3 * " + lfuCache.get(3));
    System.out.println("should be 4 * " + lfuCache.get(4));
  }

}