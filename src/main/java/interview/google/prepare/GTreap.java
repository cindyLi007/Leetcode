package interview.google.prepare;

import java.util.Arrays;

/**
 * A binary tree has the binary search tree property (BST property) if, for every node, the keys in its left subtree are
 * smaller than its own key, and the keys in its right subtree are larger than its own key. It has the heap property if,
 * for every node, the keys of its children are all smaller than its own key. You are given a set of binary tree nodes
 * (i, j) where each node contains an integer i and an integer j. No two i values are equal and no two j values are equal.
 * We must assemble the nodes into a single binary tree where the i values obey the BST property and the j values obey
 * the heap property. If you pay attention only to the second key in each node, the tree looks like a heap, and if you pay
 * attention only to the first key in each node, it looks like a binary search tree.
 * https://leetcode.com/discuss/interview-question/363945/Google-or-Treap
 */
public class GTreap {

  public TreeNode buildTree(int[][] A) {
    Arrays.sort(A, (o1, o2) -> o2[1] - o1[1]);
    TreeNode root = new TreeNode(A[0][0], A[0][1]);
    // 但我们排完序以后 在Array里的nodes已经自然有了大的在前的属性 这时当我们insert one by one 的时候，自然就可以保证root 大于所有的children。
    for (int i = 1; i < A.length; i++) {
      insert(root, A[i][0], A[i][1]);
    }
    return root;
  }

  private void insert(TreeNode root, int i, int j) {
    if (i < root.i) {
      if (root.left == null) root.left = new TreeNode(i, j);
      else insert(root.left, i, j);
    } else { // i> root.i
      if (root.right == null) root.right = new TreeNode(i, j);
      else insert(root.right, i, j);
    }
  }

  public static void main(String... args) {
    int[][] A = {{1, 6}, {3, 7}, {2, 4}};
    GTreap gTreap = new GTreap();
    TreeNode node1 = gTreap.buildTree(A);
    TreeNode anotherBstHeap = gTreap.buildTree(new int[][]{{1, 4}, {8, 5}, {3, 6}, {10, -1}, {4, 7}});
    System.out.println();
  }

  class TreeNode {
    int i, j;
    TreeNode left, right;

    TreeNode(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}

