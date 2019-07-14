package com.google.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestKValues {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList();
        inorder(root, list);
        int idx = search(list, target);
        int i=idx-1, j=idx+1;
        List<Integer> res = new ArrayList();
        res.add(list.get(idx));
        while (res.size()<k) {
            if (i>=0 && j<list.size()) {
                double a1 = Math.abs(list.get(i) - target);
                double a2 = Math.abs(list.get(j) - target);
                if (a1<a2) {
                    res.add(list.get(i--));
                } else {
                    res.add(list.get(j++));
                }
            } else {
                if (i<0) {
                    while (res.size()<k) {
                        res.add(list.get(j++));
                    }
                } else {
                    while (res.size()<k) {
                        res.add(list.get(i--));
                    }
                }
            }
        }
        return res;
    }

    private int search(List<Integer> list, double target) {
        int l=0, h=list.size()-1;
        while (l<h) {
            int m=l+(h-l)/2;
            if (Math.abs(list.get(m) - target) < 0.5) return m;
            if (list.get(m)>target) h=m-1;
            else l=m+1;
        }
        return l;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root==null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static void main(String... args) {
        ClosestKValues kValues = new ClosestKValues();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left = left;
        List<Integer> set = kValues.closestKValues(root, 3.714268, 2);
        set.stream().forEach(o-> System.out.print(o + ", "));
    }
}
