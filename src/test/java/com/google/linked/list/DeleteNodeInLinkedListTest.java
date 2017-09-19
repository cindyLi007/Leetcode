package com.google.linked.list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by ychang on 8/24/2017.
 */
public class DeleteNodeInLinkedListTest {
  @Rule
  public ExpectedException exception = ExpectedException.none();

  /**
   * we can also use annotation to assert expected exception, but we could not verify the exception message
   */
  @Test/*(expected = IllegalArgumentException.class)*/
  public void delete_tailNode_shouldThrowException() {
    // Given
    DeleteNodeInLinkedList deleteNodeInLinkedList = new DeleteNodeInLinkedList();
    ListNode node = new ListNode(3);
    ListNode tail = new ListNode(4);
    node.next = tail;

    /**
     * must put Expected Exception before call the method which throw the exception
     */
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("We could not delete node since this is the tail of the list");

    // When
    deleteNodeInLinkedList.deleteNode(tail);
  }

  @Test
  public void delete_middleNode_shouldSucceed() {
    // Given
    DeleteNodeInLinkedList deleteNodeInLinkedList = new DeleteNodeInLinkedList();
    ListNode node = new ListNode(3);
    ListNode middle = new ListNode(5);
    ListNode tail = new ListNode(4);
    node.next = middle;
    middle.next = tail;

    // When
    deleteNodeInLinkedList.deleteNode(middle);

    // Then
    assertThat(node, is(notNullValue()));
    assertThat(node.next.val, is(4));
    assertThat(node.next.next, is(nullValue()));
  }

}