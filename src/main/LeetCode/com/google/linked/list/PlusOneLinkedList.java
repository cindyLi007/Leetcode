package com.google.linked.list;

/**
 * Created by ychang on 3/7/2017.
 * Since only plus one, we just need find the most-right leading 9 node, after it, all nodes should be 9, then make all
 * these nodes to be 0, and the node left the leading 9 value+1. Need create a dummy node, in case there is carry from
 * most significant digit, we have one new node to hold the carrying 1.
 */
public class PlusOneLinkedList {
  public ListNode plusOne(ListNode head) {
    ListNode res = new ListNode(0), prev=res;
    res.next=head;
    ListNode run = head;
    while (run!=null) {
      /**
       * prev is the left node of the most-right leading 9.
       */
      if (run.val!=9) prev=run;
      run=run.next;
    }
    if (prev.next==null) {
      prev.val+=1;
      return head;
    }
    prev.val+=1;
    ListNode cur = prev.next;
    while (cur!=null) {
      cur.val=0;
      cur=cur.next;
    }
    return res.val==0 ? head : res;
  }
}
