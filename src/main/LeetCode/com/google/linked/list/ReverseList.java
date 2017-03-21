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

  public ListNode reverseList_recursive(ListNode head) {
    if (head==null) return null;
    return reverse(head)[0];
  }

  /**
   * return 2 nodes (head and tail), head is used for final head, tail is used to connect next element (should be prev
   * node in original linked list
   */
  private ListNode[] reverse(ListNode head) {
    if (head.next==null) return new ListNode[]{head, head};
    ListNode[] res = reverse(head.next);
    res[1].next=head;
    head.next=null;
    return new ListNode[]{res[0], head};
  }
}
