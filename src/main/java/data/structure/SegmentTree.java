package data.structure;

import java.util.Arrays;

public class SegmentTree {

  private Node[] heap;
  private int[] array;
  private int size;

  public SegmentTree(int[] array) {
    int N = array.length;
    this.array = Arrays.copyOf(array, N);
    // The max size of this array is about 2 * 2 ^ log2(n) + 1
    // size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) N) / Math.log(2.0)) + 1)));
    int x = (int)Math.ceil(Math.log((double) N) / Math.log(2.0));
    size = 2 * (int)Math.pow(2.0, x) - 1;
    heap = new Node[size];
    build(0, 0, N - 1);
  }

  //Initialize the Nodes of the Segment tree
  private void build(int treeIdx, int from, int to) {
    heap[treeIdx] = new Node(from, to);

    // base case
    if (from == to) {
      heap[treeIdx].sum = array[from];
      heap[treeIdx].min = array[from];
    } else {
      //Build childrens
      int mid = from + (to - from) / 2;
      build(2 * treeIdx + 1, from, mid);
      build(2 * treeIdx + 2, mid + 1, to);

      // merge result from left to right
      heap[treeIdx].sum = heap[2 * treeIdx + 1].sum + heap[2 * treeIdx + 2].sum;
      heap[treeIdx].min = Math.min(heap[2 * treeIdx + 1].min, heap[2 * treeIdx + 2].min);
    }
  }

  // query range [from, to]
  public int querySumRange(int from, int to) {
    return rsq(0, from, to);
  }

  private int rsq(int treeIdx, int from, int to) {
    Node n = heap[treeIdx];

    // node is out of query range
    if (from > n.to || to < n.from) return 0;

    if (contains(from, to, n.from, n.to)) {  // the query range contains node's range
      return heap[treeIdx].sum;
    }

    int mid = n.from + (n.to - n.from) / 2; // left is in [n.from, mid], right is in [mid+1, n.to]
    if (to <= mid) return rsq(2 * treeIdx + 1, from, to);
    if (from > mid) return rsq(2 * treeIdx + 2, from, to);

    // if query range is not solely in left or right
    int left = rsq(2 * treeIdx + 1, from, to);
    int right = rsq(2 * treeIdx + 2, from, to);
    return left + right;
  }

  public int queryMinRange(int from, int to) {
    return rMinQ(0, from, to);
  }

  private int rMinQ(int treeIdx, int from, int to) {
    Node n = heap[treeIdx];

    // node is out of query range
    if (n.from > to || n.to < from) return Integer.MAX_VALUE;

    if (contains(from, to, n.from, n.to)) {
      return heap[treeIdx].min;
    }

    int mid = n.from + (n.to - n.from) / 2;
    if (from > mid) return rMinQ(2 * treeIdx + 2, from, to);
    if (to <= mid) return rMinQ(2 * treeIdx + 1, from, to);

    int leftMin = rMinQ(2 * treeIdx + 1, from, to);
    int rightMin = rMinQ(2 * treeIdx + 2, from, to);

    return Math.min(leftMin, rightMin);
  }

  public void update(int idx, int value) {
    update(0, idx, value);
  }

  private void update(int treeIdx, int idx, int value) {
    //The Node of the heap tree represents a range of the array with bounds: [n.from, n.to]
    Node n = heap[treeIdx];

    if (n.from == n.to) {
      n.sum = value;
      n.min = value;
    } else {
      int mid = n.from + (n.to - n.from) / 2;
      if (idx > mid) update(2 * treeIdx + 2, idx, value);
      if (idx <= mid) update(2 * treeIdx + 1, idx, value);

      n.sum = heap[2 * treeIdx + 1].sum + heap[2 * treeIdx + 2].sum;
      n.min = Math.min(heap[2 * treeIdx + 1].min, heap[2 * treeIdx + 2].min);
    }
  }

  //Test if the range1 contains range2
  private boolean contains(int from1, int to1, int from2, int to2) {
    return from1 <= from2 && to2 <= to1;
  }

  //The Node class represents a partition range of the array.
  class Node {
    int sum;
    int min;
    int from;
    int to;

    Node(int from, int to) {
      this.from = from;
      this.to = to;
    }
  }

  /**
   * Example:
   * init set 1 2 3 4 5 6
   */
  public static void main(String... args) {
    int[] array = new int[]{1, 2, 3, 4, 5, 6};
    SegmentTree st = new SegmentTree(array);
    System.out.println(st.querySumRange(0, 3)); // should be 10
    System.out.println(st.querySumRange(2, 4)); // should be 12
    System.out.println(st.queryMinRange(2, 4)); // should be 3
    System.out.println(st.queryMinRange(1, 2)); // should be 2
    st.update(3, 0); // 1, 2, 3, 0, 5, 6
    System.out.println(st.queryMinRange(1, 4)); // should be 0
    System.out.println(st.querySumRange(1, 4)); // should be 10
  }
}
