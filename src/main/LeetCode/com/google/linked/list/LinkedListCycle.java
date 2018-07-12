package com.google.linked.list;

/**
 * Created by ychang on 1/31/2017.
 *
 * O(N)
 * suppose there is K nodes from head to Start_of_Loop, when slow enters loop, it steps K, fast steps 2K, which means
 * fast enters loop K steps, so fast behind slow (loopSize-K) steps, it will take (loopSize-K) steps to catch slow
 * when fast and slow meet in line 18, slow enters loop (loopSize-K) step, which means slow need take K steps to reach Start_of_Loop
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
     * they must meet at Loop Start. k is the distance from head to cycle entry point
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
