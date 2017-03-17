package com.google.hash.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 2/8/2017.
 */
public class CopyListWithRandomPointer {
  /**
   * this beats 53%, it is better than next&random both use map. (https://discuss.leetcode.com/topic/18086/java-o-n-solution)
   */
  public RandomListNode copyRandomList(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap();
    RandomListNode run = head, prev=new RandomListNode(0);
    while (run!=null) {
      RandomListNode node = new RandomListNode(run.label);
      map.put(run, node);
      run=run.next;
      prev.next=node;
      prev=prev.next;
    }
    run=head;
    prev=map.get(run);
    while (run!=null) {
      prev.random = map.get(run.random);
      run=run.next;
      prev=prev.next;
    }
    return map.get(head);
  }

  /**
   * this beats 72%, the idea is first combine 2 lists, then extract them
   */
  public RandomListNode copyRandomList_woHashMap(RandomListNode head) {
    // first loop, create new node and put it in org.next
    RandomListNode run = head;
    while (run!=null) {
      RandomListNode node = new RandomListNode(run.label);
      node.next = run.next;
      run.next = node;
      run = node.next;
    }

    // second loop, link random in new created nodes
    run = head;
    while (run!=null) {
      run.next.random = run.random==null ? null : run.random.next;
      run = run.next.next;
    }

    // third loop, break new-created list with org list
    run = head;
    RandomListNode res = run==null ? null : run.next, prev = res;
    while (run!=null) {
      run.next = prev.next;
      prev.next = run.next==null ? null : run.next.next;
      run = run.next;
      prev = prev.next;
    }
    return res;
  }

  class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }
  }
}
