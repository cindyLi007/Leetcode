package com.google.linked.list;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * We are given head, the head node of a linked list containing unique integer values.
 * We are also given the list G, a subset of the values in the linked list.
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 */
public class LinkedListComponent {
    // Time: O(N + MlgM), N is length of list, M is length of G, Space: O(1)
    public int numComponents(ListNode head, int[] G) {
        Arrays.sort(G);
        ListNode run = head;
        int res = 0, found = 0;
        // NOTICE: we need not go through all nodes in list IF we already marked all nodes in G, we care about G, NOT list
        while (found < G.length) {
            res++;
            while (run != null && Arrays.binarySearch(G, run.val) < 0) {
                run = run.next;
            }
            while (run != null && Arrays.binarySearch(G, run.val) >= 0) {
                run = run.next;
                found++;
            }
        }
        return res;
    }

    // Time: O(N + M), Space: O(M), there is a disavandge if G is small and list is big, still need go through the list
    public int numComponents_usingSet(ListNode head, int[] G) {
        Set<Integer> set = Arrays.stream(G).boxed().collect(Collectors.toSet());

        ListNode run = head;
        int res = 1;

        while (run!=null) {
            // NOTICE 2nd condition is (run.next==null || ...), for ex. there is only one node in the list
            if (set.contains(run.val) && (run.next==null || !set.contains(run.next.val))) {
                res++;
            }
            run=run.next;
        }

        return res;
    }
}
