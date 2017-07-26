package com.google.linked.list;

import org.junit.Test;

/**
 * Created by ychang on 6/2/2017.
 */
public class ReverseNodesInKGroupTest {
  @Test
  public void reverseKGroup_temp() throws Exception {
    // Given
    ListNode l1=new ListNode(1);
    ListNode l2=new ListNode(2);
    l1.next = l2;
    ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();

    // When
    ListNode listNode = reverseNodesInKGroup.reverseKGroup(l1, 2);
  }

}