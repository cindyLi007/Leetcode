package interview.google.prepare;

/**
 * 给一个二叉树，找出其所包含的最长的等差数列(common diff可以>0 / =0 / <0)的长度（注意只能从上往下找），我用了dfs。
 * <p>
 * 比如：
 * 2
 * 4       5
 * 6   3   2   1
 * 8  7 9 8 6 1 6  7
 * 输出 4(2->4->6->8).
 * 再比如：
 * 2
 * 4 5
 * 6 3 2 1
 * 7 7 9 8 6 1 6 7
 * 输出 3(2->4->6).
 * <p>
 * Follow up: 如果也可以bottom up，‍‌‌‌‌‌‍‍‌‌‍‌‌‍‌‌‌‍‌‌怎么做。我说的是可以把左边和右边的序列长度存下来，然后加上中间的。
 * <p>
 * 比如：
 * 4
 * 2  6
 * 输出3（2->4->6）
 * for each node, 需要保留两条路的信息 左边的和右边的 不能只保留最长的 这是因为较短的那条有可能在parent中被扩展
 *  -2
 * /
 * 0
 * /
 * 2
 * /
 * 4
 * / \
 * 5   6
 * \
 * 6
 */
public class BTcommonDiff {
  int max;

  public int maxComDiff(TreeNode root) {
    max = 0;
    if (root==null) return max;
    dfs(root.left, 1, null,  root.val);
    dfs(root.right, 1, null,  root.val);
    return max;
  }

  private void dfs(TreeNode root, int len, Integer diff, int parentVal) {
    if (root==null) return;
    else {
      int length = (diff==null || parentVal - root.val == diff.intValue()) ? len+1 : 1;
      max = Math.max(max, length);
      Integer d = new Integer(parentVal - root.val);
      dfs(root.left, length, d, root.val);
      dfs(root.right, length, d, root.val);
    }
  }

  public static void main(String... args) {
    BTcommonDiff bTcommonDiff = new BTcommonDiff();
    TreeNode root = new TreeNode(-2, null, null);
    TreeNode left = new TreeNode(0, null, null);
    root.left = left;
    TreeNode bottom = new TreeNode(4, new TreeNode(5, null, new TreeNode(6, null, null)), new TreeNode(6, null, null));
    TreeNode middle = new TreeNode(2, bottom, null);
    left.left = middle;
    System.out.println(bTcommonDiff.maxComDiff(root)); // should be 5
    TreeNode root1 = new TreeNode(2, null, null);
    TreeNode left_1 = new TreeNode(4, null, null); root1.left = left_1;
    TreeNode right = new TreeNode(5, null, null); root1.right = right;
    left_1.left = new TreeNode(6, new TreeNode(8, null, null), new TreeNode(7, null, null));
    left_1.right = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(8, null, null));
    right.left = new TreeNode(2, new TreeNode(6, null, null), new TreeNode(1, null, null));
    right.right = new TreeNode(1, new TreeNode(6, null, null), new TreeNode(7, null, null));
    System.out.println(bTcommonDiff.maxComDiff(root1)); // should be 4

  }
}

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int v, TreeNode l, TreeNode r) {
    val = v;
    left = l;
    right = r;
  }
}
