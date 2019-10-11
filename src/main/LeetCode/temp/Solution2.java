package temp;

import java.util.ArrayDeque;
import java.util.Deque;
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

    public static int lengthOfLIS(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
            res = Math.max(stack.size(), res);
        }
        return res;
    }

    public static void main(String... args) {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}