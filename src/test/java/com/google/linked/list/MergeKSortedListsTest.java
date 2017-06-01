package com.google.linked.list;

import org.junit.Test;

/**
 * Created by ychang on 5/5/2017.
 */
public class MergeKSortedListsTest {
  @Test
  public void mergeKLists() throws Exception {
    // Given
    MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
    ListNode[] lists = new ListNode[7];
    int[][] nodes = new int[][]{{-10,-9,-9,-3,-1,-1,0}, {-5}, {4}, {-8}, {},{-9,-6,-5,-4,-2,2,3},{-3,-3,-2,-1,0}};
    int i=0;
    for (int[] node : nodes) {
      lists[i++]=createNodeList(node);
    }

    // When
    ListNode res = mergeKSortedLists.mergeKLists(lists);

  }

  private ListNode createNodeList(int[] nodes) {
    ListNode res = new ListNode(0), prev=res;
    for (int i=0; i<nodes.length; i++) {
      ListNode node = new ListNode(nodes[i]);
      prev.next=node;
      prev=prev.next;
    }
    return res.next;
  }

}