package com.google.linked.list;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ychang on 3/6/2017.
 */
public class ReverseNodesInKGroup {
  // only can beat 7%
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head==null || head.next==null || k==1)
      return head;
    Stack<ListNode> stack = new Stack();
    ListNode run = head;
    while (stack.size()<k && run!=null) {
      stack.push(run);
      run = run.next;
    }
    if (stack.size()<k)
      return head;
    ListNode next = reverseKGroup(run, k);
    ListNode node = stack.pop(), cur = node;
    while (!stack.isEmpty()) {
      cur.next = stack.pop();
      cur = cur.next;
    }
    cur.next = next;
    return node;
  }

  // this can beat 57%
  public ListNode reverseKGroup_withoutStack(ListNode head, int k) {
    if (head==null || head.next==null || k==1)
      return head;
    int i = 0;
    ListNode run = head;
    while (i<k && run!=null) {
      i++;
      run = run.next;
    }
    if (i<k)
      return head;
    ListNode nextGroup = reverseKGroup_withoutStack(run, k);
    // below just reverse a list algorithm.
    i = 0;
    ListNode dummy = null, h = head;
    while (i<k) {
      ListNode temp = head.next;
      head.next = dummy;
      dummy = head;
      head = temp;
      i++;
    }
    h.next = nextGroup;
    return dummy;
  }

  public void setZeroes(int[][] matrix) {
    int m=matrix.length, n=m==0 ? 0 : matrix[0].length;
    if (m==0 || n==0) return;
    Set<Integer> row = new HashSet(), col = new HashSet();
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (matrix[i][j]==0) {
          row.add(i);
          col.add(j);
        }
      }
    }
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (row.contains(i) || col.contains(j))
          matrix[i][j]=0;
      }
    }
  }
}
