package com.google.linked.list;

import org.junit.Test;

/**
 * Created by ychang on 3/15/2017.
 */
public class RemoveLinkedListElementTest {
  @Test
  public void removeElements() throws Exception {
    // Given
    int[] array = new int[]{2, 6, 3, 4, 5, 6};
    ListNode head = new ListNode(1), prev=head;
    for (int i=0; i<array.length; i++) {
      ListNode node = new ListNode(array[i]);
      prev.next=node;
      prev=prev.next;
    }
    RemoveLinkedListElement removeLinkedListElement = new RemoveLinkedListElement();

    // When
    ListNode listNode = removeLinkedListElement.removeElements(head, 6);

    System.out.println();
  }

}