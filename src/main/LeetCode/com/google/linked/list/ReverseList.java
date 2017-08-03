package com.google.linked.list;

/**
 * Created by ychang on 3/6/2017. The thought is insert next node to head of current list
 */
public class ReverseList {

  public ListNode reverseList_iterative(ListNode head) {
    ListNode res = null;
    while (head!=null) {
      ListNode temp = head.next;
      head.next = res;
      res = head;
      head = temp;
    }
    return res;
  }

  public ListNode reverse(ListNode head) {
    return reverse(head, null);
  }

  /**
   * First reverse, then pass to next call
   */
  private ListNode reverse(ListNode cur, ListNode prev) {
    if (cur==null) return prev;
    ListNode next = cur.next;
    cur.next = prev;
    return reverse(next, cur);
  }
}
