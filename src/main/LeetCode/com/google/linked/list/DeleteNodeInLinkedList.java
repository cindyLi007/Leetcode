package com.google.linked.list;

/**
 * Created by ychang on 3/5/2017.
 */
public class DeleteNodeInLinkedList {
  public void deleteNode(ListNode node) {
    ListNode prev=null;
    while (node.next!=null) {
      node.val=node.next.val;
      prev=node;
      node=node.next;
    }
    prev.next=null;
  }
}
