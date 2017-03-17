package com.google.linked.list;

import org.junit.Test;

/**
 * Created by ychang on 3/12/2017.
 */
public class AddTwoNumbersIITest {
  @Test
  public void addTwoNumbers() throws Exception {
    // Given
    AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
    ListNode l1 = new ListNode(7), l3 = new ListNode(2), l4 = new ListNode(4);
    l1.next=l3;
    l3.next=l4;
    l4.next = new ListNode(3);
    ListNode l2 = new ListNode(5), l5 = new ListNode(6);
    l2.next=l5;
    l5.next=new ListNode(4);

    // When
    ListNode resNode = addTwoNumbersII.addTwoNumbers(l1, l2);

  }

}