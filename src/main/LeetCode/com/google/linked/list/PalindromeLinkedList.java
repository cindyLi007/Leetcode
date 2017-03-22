package com.google.linked.list;

import java.util.Stack;

/**
 * Created by ychang on 3/22/2017.
 */
public class PalindromeLinkedList {
  /**
   * this need extra space, can beat 14%
   */
  public boolean isPalindrome_stack(ListNode head) {
    if (head==null || head.next==null)
      return true;
    ListNode slow = head, fast = head;
    Stack<Integer> stack = new Stack();
    while (fast!=null && fast.next!=null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast!=null)
      slow = slow.next;
    while (slow!=null) {
      if (slow.val!=stack.pop())
        return false;
      slow = slow.next;
    }
    return true;
  }

  /**
   * this can beat 93%.
   */
  public boolean isPalindrome(ListNode head) {
    if (head==null || head.next==null) return true;
    ListNode slow=head, fast=head, rev=null, prev=rev;
    /**
     * first find the middle point, and reverse the first part.
     */
    while (fast!=null && fast.next!=null) {
      fast=fast.next.next;
      rev=slow;
      slow=slow.next;
      rev.next=prev;
      prev=rev;
    }
    /**
     * if fast!=null, means it is a odd-elements list, slow should go to next node
     */
    if (fast!=null) slow=slow.next;
    /**
     * compare first and second part
     */
    while (slow!=null) {
      if (slow.val!=rev.val) return false;
      slow=slow.next;
      rev=rev.next;
    }
    return true;
  }

  public boolean isPalindrome_recover(ListNode head) {
    if (head==null || head.next==null) return true;
    ListNode slow=head, fast=head, rev=null, prev=null;
    while (fast!=null && fast.next!=null) {
      fast=fast.next.next;
      rev=slow;
      slow=slow.next;
      rev.next=prev;
      prev=rev;
    }
    if (fast!=null) {
      fast=slow;
      slow=slow.next;
    } else {
      fast=slow;
    }
    boolean res=true;
    while (slow!=null) {
      if (slow.val!=rev.val) res=false;
      slow=slow.next;
      prev=rev.next;
      rev.next=fast;
      fast=rev;
      rev=prev;
    }
    return res;
  }
}
