package com.google.linked.list;

import org.junit.Test;

/**
 * Created by ychang on 3/6/2017.
 */
public class ReverseListTest {

  @Test
  public void reverseList() throws Exception {
    // Given
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    ReverseList reverseList = new ReverseList();

    // When
    ListNode resNode = reverseList.reverseList_iterative(head);

    while(resNode!=null) {
      System.out.println(resNode.val);
      resNode=resNode.next;
    }

  }

}