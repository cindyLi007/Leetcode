package com.google.linked.list;

/**
 * Created by ychang on 3/5/2017.
 */
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0), prev=res;
    int car=0, dig;
    /**
     * please notice for l1=[5], l2=[5], we must include car!=0 in while(), otherwise we get [0]
     */
    while(l1!=null || l2!=null || car!=0) {
      int v1 = l1==null ? 0 : l1.val;
      int v2 = l2==null ? 0 : l2.val;
      int sum = v1 + v2 + car;
      dig = sum%10;
      car = sum/10;
      ListNode node = new ListNode(dig);
      prev.next=node;
      prev=node;
      l1 = l1==null ? null : l1.next;
      l2 = l2==null ? null : l2.next;
    }
    return res.next;
  }
}
