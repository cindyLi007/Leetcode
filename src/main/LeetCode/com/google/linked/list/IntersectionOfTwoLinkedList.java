package com.google.linked.list;

/**
 * Created by ychang on 3/6/2017.
 * If 2 lists have same len, the distance to the intersection node are same, so we can step 1 each time for both of them
 * otherwise, only need move the longer list's head to the node which has same distance to the shorter list's head.
 */
public class IntersectionOfTwoLinkedList {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA==null || headB==null)
      return null;
    ListNode la = headA, lb = headB;
    int len_a = getLen(la), len_b = getLen(lb);
    if (len_a!=len_b) {
      int diff = Math.abs(len_a - len_b);
      /**
       * move the longer list head, make 2 lists has same length
       */
      ListNode node = len_a>len_b ? la : lb;
      for (int i = 0; i<diff; i++)
        node = node.next;
      if (len_a>len_b)
        la = node;
      else
        lb = node;
    }
    while (la!=lb) {
      la = la.next;
      lb = lb.next;
    }
    return la;
  }

  private int getLen(ListNode node) {
    int len=0;
    while (node!=null) {
      node=node.next;
      len++;
    }
    return len;
  }

  /**
   * we need NOT first calculate the len of 2 Linked Lists. Work on it like a cycle, when one hit to end, jump to another
   * list's head. So when they meet, both of them traverse len_a_before_intersection + len_b_before_intersection + one
   * intersection length. If the two linked lists have no intersection at all, then the meeting pointer in second iteration
   * must be the tail node of both lists, which is null
   */
  public ListNode getIntersectionNode_best(ListNode headA, ListNode headB) {
    if (headA==null || headB==null) return null;
    ListNode pa = headA, pb = headB;
    while (pa!=pb) {
      // please notice, must check pa==null instead of pa.next == null, otherwise, TLE, cause we never hit null for 2
      // non intersection list.
      pa = pa==null ? headB : pa.next;
      pb = pb==null ? headA : pb.next;
    }
    return pa;
  }
}
