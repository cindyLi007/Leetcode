package interview.snapchat;

/*
 * Logically maintain a list of numbers. The length of the list is fixed and given in the beginning. Each number can be
 * either a 0 or 1. Initially all numbers are zeros.
 * port 2 operations on the list:
 * (1) flip a number (0->1, 1->0) at a given position.
 * (2) count the sum of numbers within a given range.
 */
// O(N), Space O(N)
public class FixedLenSegList {

  private static class Node {
    int sum;
    int start, end;
    Node left, right;

    Node(int s, int e, int v) {
      start = s;
      end = e;
      sum = v;
    }
  }

  final int SIZE;
  Node root;

  public FixedLenSegList(int size) {
    SIZE = size;
    root = buildSegmentTree(root, 0, size - 1);
  }

  // O(2*N)
  private Node buildSegmentTree(Node node, int start, int end) {
    if (node == null) {
      node = new Node(start, end, 0);
    }
    if (start != end) {
      int mid = start + (end - start) / 2;
      node.left = buildSegmentTree(node.left, start, mid);
      node.right = buildSegmentTree(node.right, mid + 1, end);
    }
    return node;
  }

  // when we flip a pos, we set the num array, we update the sum array [pos, SIZE] for each entry, -1/+1 O(n)
  void flip(int pos) {
    flip(root, pos);
  }

  // O(lgN)
  void flip(Node node, int pos) {
    if (pos > node.end || pos < node.start) {
      return;
    }
    // base case
    if (node.start == node.end) {
      node.sum ^= 1;
    } else {
      int mid = node.start + (node.end - node.start) / 2;
      if (pos <= mid) flip(node.left, pos);
      else flip(node.right, pos);
      node.sum = node.left.sum + node.right.sum;
    }
  }

  // O(lgN)
  int sum(int low, int high) {
    return sum(root, low, high);
  }

  int sum(Node node, int low, int high) {
    int start = node.start, end = node.end;
    // base case
    if (low <= start && end <= high) {
      return node.sum;
    }
    int mid = start + (end - start) / 2;
    if (high <= mid) {
      return sum(node.left, low, high);
    }
    if (mid < low) {
      return sum(node.right, low, high);
    }
    return sum(node.left, low, high) + sum(node.right, low, high);
  }

  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    FixedLenSegList fl = new FixedLenSegList(5);
    System.out.println(fl.sum(0, 4));
    // 0, 0, 0, 1, 0
    fl.flip(3);
    System.out.println(fl.sum(0, 2));
    System.out.println(fl.sum(2, 4));
    fl.flip(2);
    System.out.println(fl.sum(2, 4));
    fl.flip(3);
    System.out.println(fl.sum(2, 4));
    fl.flip(2);
    System.out.println(fl.sum(2, 4));
  }
}
