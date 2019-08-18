package data.structure;

import java.util.Comparator;

// Key must be extends Comparable which means Key is also an interface, if use implements, that means Key is a class, but
// we did not define a class of Key
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        private Node left, right;
        private Key key;
        private Value value;
        private int count;

        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            count = 1;
        }
    }

    private Node root;

    void del(Key k) {
        root = del(root, k);
    }

    Node del(Node node, Key k) {
        if (node==null) return node; // search miss
        int c = k.compareTo(node.key);
        if (c==0) { // search hit
            // no children or one children
            if (node.left==null) return node.right;
            if (node.right==null) return node.left;

            // 2 children
            Node t = node;
            node = min(t.right); // find node's successor
            node.right = delMin(t.right);
            node.left = t.left;
        } else {
            if (c<0)  node.left = del(node.left, k);
            else node.right = del(node.right, k);
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    private int size(Node node) {
        if (node==null) return 0;
        return node.count;
    }

    private Node min(Node node) {
        while (node.left!=null) {
            node = node.left;
        }
        return node;
    }

    void  delMax() {
        root = delMax(root);
    }

    Node delMax(Node node) {
        if (node.right==null) return node.left;
        node.right = delMax(node.right);
        node.count = size(node.right) + size(node.left) + 1;
        return node;
    }


    Value get(Key k) {
        Node n = root;
        while (n!=null) {
            int c = k.compareTo(n.key);
            if (c==0) return n.value;
            if (c>0) n=n.right;
            else n=n.left;
        }
        return null;
    }

    void put(Key k, Value v) {
        root = put(root, k, v);
    }

    Node put(Node node, Key k, Value v) {
        if (node == null) {
            return new Node(k, v);
        }
        int c = k.compareTo(node.key);
        if (c==0) node.value = v;
        else if (c>0) node.right = put(node.right, k, v);
        else node.left = put(node.left, k, v);
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    void delMin() {
        root = delMin(root);
    }

    Node delMin(Node n) {
        if (n.left == null) return n.right;
        n.left = delMin(n.left);
        n.count = 1 + size(n.left) + size(n.right);
        return n;
    }

    Key floor(Key key) {
        Node n = floor(root, key);
        return n==null ? null : n.key;
    }

    Node floor(Node node, Key key) {
        if (node==null) return null;
        int c = key.compareTo(node.key);
        if (c==0) return node;
        if (c<0) {
            return floor(node.left, key);
        } else {
            Node res = floor(node.right, key);
            if (res==null) return node;
            return res;
        }
    }

    int rank(Key key) {
        return rank(root, key);
    }

    // When call rank, no matter the key is in or not in the BST, we always return the pos which it should be or already is
    // in. This is useful when do the BST binary search.
    // O(lgN)
    int rank(Node node, Key key) {
        if (node==null) return 0;
        int c = key.compareTo(node.key);
        if (c==0) return size(node.left);
        if (c<0) return rank(node.left, key);
        return size(node.left) + 1 + rank(node.right, key);
    }
}
