package com.google.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 3/19/2017.
 */
public class LRU_DoubleLinkNode {
  // map
  private Map<Integer, CacheObject> map;
  private final int MAX_ENTRIES;
  private CacheObject head, tail;

  public LRU_DoubleLinkNode(int capacity) {
    map = new HashMap();
    MAX_ENTRIES = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      CacheObject node = map.get(key);
      if (head!=node)
        moveToTop(node);
      return node.value;
    }
    return -1;
  }

  private void moveToTop(CacheObject node) {
    node.prev.next = node.next;
    if (node.next!=null)
      node.next.prev = node.prev;
    else
      tail = node.prev;
    node.prev = null;
    node.next = head;
    head.prev = node;
    head = node;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      CacheObject node = map.get(key);
      node.value = value;
      if (head!=node)
        moveToTop(node);
    } else {
      CacheObject node = new CacheObject(key, value);
      if (head==null) {
        head = node;
        tail = node;
      } else {
        node.next = head;
        head.prev = node;
        head = node;
      }
      map.put(key, node);
      if (map.size()>MAX_ENTRIES) {
        CacheObject revNode = map.get(tail.key);
        map.remove(revNode.key);
        tail = revNode.prev;
        tail.next = null;
      }
    }
  }

  class CacheObject {
    int key, value;
    CacheObject prev, next;

    CacheObject(int k, int v) {
      key = k;
      value = v;
    }
  }
}