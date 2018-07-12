package com.google.linked.list;

import java.util.PriorityQueue;

/**
 * Created by ychang on 3/6/2017.
 */
public class MergeKSortedLists {
  // this can beat 25%, Time: O(N*logK), N is number of total nodes, K is number of list, Space: O(K)
  public ListNode mergeKLists_priorityQueue(ListNode[] lists) {
    /**
     * IMPORTANT, must have <> when new PriorityQueue, because we use Lambda
     */
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (l1, l2) -> l1.val - l2.val);
    for (ListNode node : lists) {
      if (node!=null)
      /**
       * use offer/poll instead of add/remove, can significantly improve performance
       */
        pq.offer(node);
    }
    ListNode res = new ListNode(0), prev = res;
    while (!pq.isEmpty()) {
      ListNode cur = pq.poll();
      prev.next = cur;
      prev = prev.next;
      if (cur.next!=null)
        pq.offer(cur.next);
    }
    return res.next;
  }

  /**
   * this divide and conquer can beat 84%, Time: O(N*logK), Space: O(k) given recursive
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length==0) return null;
    return merge(lists, 0, lists.length-1);
  }

  private ListNode merge(ListNode[] list, int l, int h) {
    if (h-l>1) {
      int mid = l+(h-l)/2;
      return merge(merge(list, l, mid), merge(list, mid+1, h));
    } else if (h-l==1) {
      return merge(list[l], list[h]);
    } else return list[l];
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0), prev=res;
    while (l1!=null && l2!=null) {
      if (l1.val<l2.val) {
        prev.next=l1;
        l1=l1.next;
      } else {
        prev.next=l2;
        l2=l2.next;
      }
      prev=prev.next;
    }
    prev.next=(l1==null) ? l2 : l1;
    return res.next;
  }

}
