package interview.amazon.online.test;

/**
 * Created by ychang on 1/16/2017.
 */
public class BstDistance {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static int bstDistance(int[] values, int n, int node1, int node2) {
    if (n<2)
      return 0;
    Node root = new Node(values[0]);
    for (int i = 1; i<n; i++) {
      add(root, values[i]);
    }
    return search(node1, node2, root);
  }

  private static int search(int v1, int v2, Node root) {
    if (root==null)
      return -1;
    int min = Math.min(v1, v2);
    int max = Math.max(v1, v2);
    if (max<root.value) {
      return search(v1, v2, root.left);
    } else if (min>root.value) {
      return search(v1, v2, root.right);
    } else {
      int d1 = dis(v1, root, 0);
      int d2 = dis(v2, root, 0);
      if (d1>=0 && d2>=0)
        return d1 + d2;
      else
        return -1;
    }
  }

  private static int dis(int v, Node root, int level) {
    if (root==null)
      return -1;
    if (v==root.value)
      return level;
    level++;
    if (v<root.value)
      return dis(v, root.left, level);
    else
      return dis(v, root.right, level);
  }

  private static Node add(Node node, int num) {
    if (node==null)
      return new Node(num);
    else {
      if (num<node.value)
        node.left = add(node.left, num);
      else
        node.right = add(node.right, num);
    }
    return node;
  }

  static class Node {
    Node left, right;
    int value;

    public Node(int v) {
      value = v;
    }
  }
}