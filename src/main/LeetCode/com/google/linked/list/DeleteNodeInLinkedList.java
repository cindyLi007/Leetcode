package com.google.linked.list;

import com.google.common.base.Preconditions;

/**
 * Created by ychang on 3/5/2017.
 */
public class DeleteNodeInLinkedList {
  public synchronized void deleteNode(ListNode node) {
    if (node==null)
      return;
    Preconditions.checkArgument(node.next!=null, "We could not delete node since this is the tail of the list");
    int v = node.next.val;
    node.next = node.next.next;
    node.val = v;
  }
}
