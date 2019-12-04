package temp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {
  int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return max;
    inorder(root);
    return max;
  }

  private int inorder(TreeNode root) {
    if (root.left == null && root.right == null) return 0;
    int LP = root.left != null ? inorder(root.left) : -1;
    int RP = root.right != null ? inorder(root.right) : -1;
    max = Math.max(max, LP + RP + 2);
    return Math.max(LP, RP) + 1;
  }

  public static int lengthOfLIS(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && stack.peek() >= nums[i]) {
        stack.pop();
      }
      stack.push(nums[i]);
      res = Math.max(stack.size(), res);
    }
    return res;
  }

  public static void main(String... args) {
    System.out.println(lengthOfLIS(new /**/int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    String[] expand = expand("{a,b}c{d,e}f");
    System.out.println(removeDuplicates("abbaca"));
  }

  public static String[] expand(String S) {
    List<Set<String>> list = new ArrayList();
    int N = S.length();
    for (int i=0; i<N; ) {
      Set<String> set = new HashSet();
      if (S.charAt(i)=='{') {
        int end = S.indexOf("}", i);
        String sub = S.substring(i+1, end);
        String[] tokens = sub.split(",");
        for (String t : tokens) set.add(t);
        i = end+1;
      } else {
        int end = S.indexOf("{", i);
        if (end==-1) end = N;
        set.add(S.substring(i, end));
        i = end;
      }
      list.add(set);
    }
    List<String> res = new ArrayList();
    dfs(list, 0, res, "");
    String[] array = new String[res.size()];
    int i=0;
    for (String s : res) array[i++] = s;
    return array;
  }

  private static void dfs(List<Set<String>> list, int idx, List<String> res, String prefix) {
    if (idx == list.size()) {
      res.add(prefix);
    } else {
      Set<String> set = list.get(idx);
      for (String c : set) {
        dfs(list, idx+1, res, prefix + c);
      }
    }
  }

  public static String removeDuplicates(String S) {
    int L = S.length();
    if (L<=1) return S;
    do {
      L = S.length();
      StringBuilder sb = new StringBuilder();
      int i=0;
      for (; i<L-1; i++) {
        if (S.charAt(i) == S.charAt(i+1)) i++;
        else sb.append(S.charAt(i));
      }
      if (i==L-1) sb.append(S.charAt(i));
      S = sb.toString();
    } while (L > S.length());
    return S;
  }
}
