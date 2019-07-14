package temp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution2 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return max;
        inorder(root);
        return max;
    }

    private int inorder(TreeNode root) {
        if (root.left==null && root.right==null) return 0;
        int LP = root.left!=null ? inorder(root.left) : -1;
        int RP = root.right!=null ? inorder(root.right) : -1;
        max = Math.max(max, LP + RP + 2);
        return Math.max(LP, RP) + 1;
    }
}