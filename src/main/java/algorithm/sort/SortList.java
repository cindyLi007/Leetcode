package algorithm.sort;

/**
 * Created by ychang on 1/23/2017.
 * Recursive merge sort, first need split a list to 2 separate list. Then sort each of them, finally merge them and return
 */
public class SortList {
  public ListNode sortList(ListNode head) {
    // base case
    if (head==null || head.next==null) {
      return head;
    }

    // split to 2 lists
    ListNode fast = head, slow = head, prev = null;
    while (fast!=null && fast.next!=null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;

    // now have 2 separate lists, head and slow, recursively sort them
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    // merge l1 and l2 together
    return merge(l1, l2);
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode first = new ListNode(0), prev = first;
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
    return first.next;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
