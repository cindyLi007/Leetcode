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
 *  2
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

  public int maxCommonDiff(TreeNode root) {
    max = 0;
    if (root == null) return max;
    helper(root);
    return max;
  }

  // return an array has 2 Paths, from left and from right. IF it is a root, return an empty array
  private Path[] helper(TreeNode root) {
    if (root.left == null && root.right == null) {
      return new Path[0];
    }

    int maxLenLeft = 0;
    Path leftPath = new Path(0, 0);
    if (root.left != null) {
      Path[] childPath = helper(root.left);
      maxLenLeft = f(root.left, root.val, childPath, leftPath);
    }

    int maxLenRight = 0;
    Path rightPath = new Path(0, 0);
    if (root.right != null) {
      Path[] childPath = helper(root.right);
      maxLenRight = f(root.right, root.val, childPath, rightPath);
    }

    max = Math.max(maxLenLeft, maxLenRight);
    Path[] res = new Path[]{leftPath, rightPath};
    return res;
  }

  private int f(TreeNode node, int rootVal, Path[] childPath, Path path) {
    int maxLen = 0;
    int diff = rootVal - node.val;
    if (childPath.length > 0) {
      if (childPath[0] != null && childPath[0].diff == diff)maxLen = Math.max(maxLen, childPath[0].len + 1);
      if (childPath[1] != null && childPath[1].diff == diff) maxLen = Math.max(maxLen, childPath[1].len + 1);
    } else {
      path.len = 1; path.diff = diff;
    }
    if (maxLen > 0) {
      path.len = maxLen; path.diff = diff;
    }
    return maxLen;
  }

  public static void main(String... args) {
    TreeNode root = new TreeNode(-2, null, null);
    TreeNode left = new TreeNode(0, null, null);
    root.left = left;
    TreeNode bottom = new TreeNode(4, new TreeNode(5, null, new TreeNode(6, null, null)), new TreeNode(6, null, null));
    TreeNode middle = new TreeNode(2, bottom, null);
    left.left = middle;
    BTcommonDiff bTcommonDiff = new BTcommonDiff();
    System.out.println(bTcommonDiff.maxCommonDiff(root));
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

class Path {
  int diff, len;

  Path(int l, int d) {
    diff = d;
    len = l;
  }
}

