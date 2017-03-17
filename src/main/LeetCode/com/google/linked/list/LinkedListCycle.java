package com.google.linked.list;

/**
 * Created by ychang on 1/31/2017.
 */
public class LinkedListCycle {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    /** Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
    while (fast!=null && fast.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow==fast) { // Collision
        break;
      }
    }

    /** Error check - no meeting point, and therefore no loop
     *  Do not check slow!=fast, because, if there is only one node in the list, slow == fast, but no loop
     */
    if (fast==null || fast.next==null) {
      return null;
    }

    /** Move slow to Head. Keep fast at Meeting Point. Each are k steps from the Loop Start. If they move at the same pace,
     * they must meet at Loop Start. k is the distance from start start to cycle entry point
     */
    slow = head;
    while (slow!=fast) {
      slow = slow.next;
      fast = fast.next;
    }

    /** Both now point to the start of the loop. */
    return fast;
  }
}
