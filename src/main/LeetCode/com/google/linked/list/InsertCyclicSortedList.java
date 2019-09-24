package com.google.linked.list;

public class InsertCyclicSortedList {
    // Time: O(N), Space: O(1)
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal, null);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node run = head.next, prev = head;
        while (true) {
            // case 1: insertVal> max or insertVal < min, if prev > run that means prev is the max and run is the min
            if ((prev.val > run.val && (insertVal <= run.val || insertVal > prev.val))
                    // case 2 : find the middle insert point
                    || (prev.val <= insertVal && insertVal <= run.val)
                    // case 3: all nodes are same value in list
                    || run == head) {
                node.next = run;
                prev.next = node;
                return head;
            }
            prev = run;
            run = run.next;
        }
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
