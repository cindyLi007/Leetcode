package com.google.linked.list;

import java.util.Stack;

/**
 * Created by ychang on 3/12/2017.
 */
public class AddTwoNumbersII {
  /**
   * Time: O(N+M), Space: O(N+M)
   */
  public ListNode addTwoNumbers_stack(ListNode l1, ListNode l2) {
    Stack<ListNode> s1 = new Stack();
    Stack<ListNode> s2 = new Stack();
    ListNode res = new ListNode(0);

    while (l1!=null) {
      s1.push(l1);
      l1=l1.next;
    }
    while (l2!=null) {
      s2.push(l2);
      l2=l2.next;
    }
    /**
     * notice use || instead of &&
     */
    while (!s1.isEmpty() || !s2.isEmpty()){
      int v1=s1.isEmpty() ? 0 : s1.pop().val;
      int v2=s2.isEmpty() ? 0 : s2.pop().val;
      int sum=res.val+v1+v2;
      ListNode node = new ListNode(sum%10);
      res.val=sum/10;
      node.next=res.next;
      res.next=node;
    }
    return res.val==0 ? res.next : res;
  }

  /**
   * first calculate the diff of 2 linked list, recursively calculate the sum, use an offset to mark whether 2 lists intersect
   * Time: O(N+M), Space: O(max(N, M)) for call stack
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int len1 = length(l1), len2 = length(l2);
    ListNode res=len1 > len2 ? helper(l1, l2, len1-len2) : helper(l2, l1, len2-len1);
    if (res.val>9) {
      ListNode l = new ListNode(1);
      l.next = res;
      res.val %= 10;
      return l;
    }
    return res;
  }

  private ListNode helper(ListNode longer, ListNode shorter, int offset) {
    if (longer==null) return null;
    ListNode next = helper(longer.next, offset==0 ? shorter.next : shorter,
        offset==0 ? 0 : offset-1);
    int sum = longer.val + (offset==0 ? shorter.val : 0);
    if (next !=null && next.val>9) {
      next.val %= 10;
      sum += 1;
    }
    ListNode node = new ListNode(sum);
    node.next = next;
    return node;
  }

  private int length(ListNode l) {
    int count = 0;
    while (l!=null) {
      count++;
      l=l.next;
    }
    return count;
  }

}
