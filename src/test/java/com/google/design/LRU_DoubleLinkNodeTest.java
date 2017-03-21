package com.google.design;

import org.junit.Test;

/**
 * Created by ychang on 3/19/2017.
 */
public class LRU_DoubleLinkNodeTest {
  @Test
  public void get() throws Exception {
    // Given
    LRU_DoubleLinkNode lru = new LRU_DoubleLinkNode(2);

    // When ["LRUCache","get","put","get","put","put","get","get"]
//    [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    System.out.println("get 2 " + lru.get(2));
    lru.put(2, 6);
    System.out.println("get 1 " + lru.get(1));
    lru.put(1, 5);
    lru.put(1, 2);
    System.out.println("get 1 " + lru.get(1));
    System.out.println("get 2 " + lru.get(2));
  }

}