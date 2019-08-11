package com.google.segment.tree;

public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length==0) return 0;
        Node root = build(nums, 0, nums.length-1);
        int res = (int)query(root, lower, upper);
        return res;
    }

    private long query(Node node, int low, int high) {
        if (node.start == node.end) {
            if (low <= node.sum && node.sum <= high) return 1;
            return 0;
        }
        int res = 0;
        if (low <= node.sum && node.sum <= high) res++;
        res += query(node.left, low, high) + query(node.right, low, high);
        return res;
    }

    private Node build(int[] A, int low, int high) {
        if (low==high) return new Node(low, high, (long)A[low]);
        int mid = low + (high-low)/2;
        Node root = new Node(low, high, 0);
        root.left = build(A, low, mid);
        root.right = build(A, mid+1, high);
        root.sum = (long)root.left.sum + (long)root.right.sum;
        return root;
    }

    private static class Node {
        int start, end;
        long sum;
        Node left, right;

        Node(int s, int e, long v) {
            start = s;
            end = e;
            sum = v;
        }
    }

    public static void main(String... args) {
        CountRangeSum countRangeSum = new CountRangeSum();
        int count = countRangeSum.countRangeSum(new int[]{0, -3, -3, 1, 1, 2}, 3, 5);
        System.out.println(count);
    }
}
