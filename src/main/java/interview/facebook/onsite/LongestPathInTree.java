package interview.facebook.onsite;

// Given a Tree, find the longest path from leaf to leaf, similiar with LC 124
// 求tree里最长的leaf to leaf的path
public class LongestPathInTree {
  int path = 0;

  public int longestPath(TreeNode root) {
    helper(root);
    return path;
  }

  // return the longer path from root to left subtree leaf or right subtree leaf
  private int helper(TreeNode root) {
    if (root==null) return 0;
    int left = helper(root.left);
    int right = helper(root.right);
    path = Math.max(path, left + right + 1);
    return Math.max(left, right) + 1;
  }

  public static void main(String... args) {
    TreeNode node4 = new TreeNode(4, new TreeNode(10, new TreeNode(18, null, new TreeNode(12, null, null)), null), null);
    TreeNode root = new TreeNode(1, new TreeNode(2, node4,
        new TreeNode(5, null, new TreeNode(6, null, null))), null); //new TreeNode(3, null, new TreeNode(7, null, null)));
    LongestPathInTree longestPathInTree = new LongestPathInTree();
    System.out.println(longestPathInTree.longestPath(root));
  }
}
