package com.google.linked.list;

import org.junit.Test;

/**
 * Created by ychang on 3/22/2017.
 */
public class PalindromeLinkedListTest {
  @Test
  public void isPalindrome_recover() throws Exception {
    // Given
    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
    ListNode head = new ListNode(1);
    ListNode node2 = new ListNode(2); head.next=node2;
    ListNode node3 = new ListNode(2); node2.next=node3;
    ListNode node4 = new ListNode(1); node3.next=node4;

    // When
    palindromeLinkedList.isPalindrome(head);

    // Then
    while (head!=null) {
      System.out.print(head.val + ", ");
      head=head.next;
    }
  }

}