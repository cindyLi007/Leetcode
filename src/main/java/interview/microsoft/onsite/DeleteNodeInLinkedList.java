package interview.microsoft.onsite;

import com.google.common.base.Preconditions;

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

class ListNode {
  int val;
  ListNode next;
}
