package com.google.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 3/19/2017.
 */
public class LRU_DoubleLinkNode {
  CacheNode head, tail; // head is for insert, tail is for remove
  Map<Integer, CacheNode> map;
  final int SIZE;

  public LRU_DoubleLinkNode(int capacity) {
    SIZE = capacity;
    map = new HashMap();
  }

  public int get(int key) {
    if (!map.containsKey(key))
      return -1;
    CacheNode node = map.get(key);
    if (node!=head)
      moveToTop(node);
    return node.val;
  }

  private void moveToTop(CacheNode node) {
    if (node==tail) {
      node.prev.next = null;
      tail = node.prev;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    node.next = head;
    head.prev = node;
    head = node;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      CacheNode node = map.get(key);
      node.val = value;
      if (node!=head)
        moveToTop(node);
    } else {
      CacheNode node = new CacheNode(key, value);
      if (head==null) {
        head = node;
        tail = node;
      } else {
        node.next = head;
        head.prev = node;
        head = node;
      }
      map.put(key, node);
      if (map.size()>SIZE) {
        removeEldest();
      }
    }
  }

  private void removeEldest() {
    CacheNode node = tail;
    map.remove(node.key);
    tail.prev.next = null;
    tail = tail.prev;
  }

  class CacheNode {
    CacheNode prev, next;
    int key, val;

    CacheNode(int k, int v) {
      key = k;
      val = v;
    }
  }
}