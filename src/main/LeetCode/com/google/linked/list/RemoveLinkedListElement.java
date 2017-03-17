package com.google.linked.list;

/**
 * Created by ychang on 3/15/2017.
 */
public class RemoveLinkedListElement {
  public ListNode removeElements(ListNode head, int val) {
    if (head==null)
      return null;
    ListNode res = new ListNode(0), prev = res;
    while (head!=null) {
      if (head.val!=val) {
        prev.next = head;
        prev = prev.next;
      } else {
        prev.next = null;
      }
      head = head.next;
    }
    return res.next;
  }

  public ListNode removeElements_recursive(ListNode head, int val) {
    if (head==null) return head;
    head.next = removeElements(head.next, val);
    return head.val==val ? head.next : head;
  }
}
