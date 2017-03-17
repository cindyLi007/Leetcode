package com.google.linked.list;

import java.util.Stack;

/**
 * Created by ychang on 3/12/2017.
 */
public class AddTwoNumbersII {
  /**
   * this can beat 69%.
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
   * this can beat 17%, first calculate the diff of 2 linked list, recursively calculate the sum, use an offset to mark
   * whether 2 lists intersect
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int len1=len(l1), len2=len(l2);
    ListNode res =  len1<len2 ? helper(l2, l1, len2-len1) : helper(l1, l2, len1-len2);
    if (res.val<10) return res;
    ListNode node = new ListNode(1);
    res.val%=10;
    node.next=res;
    return node;
  }

  private ListNode helper(ListNode l1, ListNode l2, int offset) {
    if (l1==null) return null;
    int sum = offset==0 ? l1.val+l2.val : l1.val;
    ListNode next = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset-1);
    if (next!=null && next.val>9) {
      next.val%=10;
      sum++;
    }
    ListNode node = new ListNode(sum);
    node.next=next;
    return node;
  }

  private int len(ListNode node) {
    int count=0;
    while(node!=null) {
      count++;
      node=node.next;
    }
    return count;
  }
}
