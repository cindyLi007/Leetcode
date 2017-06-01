package com.google.linked.list;

import java.util.PriorityQueue;

/**
 * Created by ychang on 3/6/2017.
 */
public class MergeKSortedLists {
  // this can beat 4%
  public ListNode mergeKLists_priorityQueue(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
    for (ListNode node : lists) {
      if (node!=null)
        pq.add(node);
    }
    ListNode res = new ListNode(0), prev = res;
    while (!pq.isEmpty()) {
      ListNode cur = pq.remove();
      prev.next = cur;
      prev = prev.next;
      if (cur.next!=null)
        pq.add(cur.next);
    }
    return res.next;
  }

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

  // this can beat 88% divide and conquer
  /*public ListNode mergeKLists_fastest(ListNode[] lists) {
    return mergeKLists(lists, 0, lists.length - 1);
  }

  private ListNode mergeKLists(ListNode[] lists, int start, int end) {
    if (start>end)
      return null;
    if (start==end)
      return lists[start];
    if (start + 1==end)
      return mergeTwoList(lists[start], lists[end]);
    int mid = start + (end - start)/2;
    return mergeTwoList(mergeKLists(lists, start, mid - 1), mergeKLists(lists, mid, end));
  }

  private ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0), prev = res;
    while (l1!=null && l2!=null) {
      if (l1.val<l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }
    prev.next = l1==null ? l2 : l1;
    return res.next;
  }*/
}
