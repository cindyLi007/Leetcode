package com.google.linked.list;

/**
 * Created by ychang on 3/6/2017.
 */
public class MergeTwoSoredLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0), prev=res;
    while (l1!=null && l2!=null) {
      if (l1.val<l2.val) {
        prev.next=l1;
        l1=l1.next;
      } else {
        prev.next=l2;
        l2=l2.next;
      }
      /**
       * do NOT forget move forward prev
       */
      prev=prev.next;
    }
    if (l1==null) prev.next=l2;
    else prev.next=l1;
    return res.next;
  }
}
