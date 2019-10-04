package com.google.recursive;

public class StrobogrammaticNumberIII {

    int count, L1, L2;
    char[][] pairs=new char[][]{{'0','0'}, {'1','1'}, {'8','8'}, {'6','9'}, {'9','6'}};

    // Time: O(N * 5^L) where N is the len diff between L1 and L2, L is the average Length
    public int strobogrammaticInRange_slower(String low, String high) {
        L1=low.length(); L2=high.length(); count=0;
        for (int i=L1; i<=L2; i++) {
            dfs("", i, low, high);
            dfs("1", i, low, high);
            dfs("0", i, low, high);
            dfs("8", i, low, high);
        }
        return count;
    }

    private void dfs(String s, int L, String low, String high) {
        if (s.length() > L || s.length() + 1 == L) return;
        if (s.length()==L) {
            if (compare(s, low)>=0 && compare(s, high)<=0 && (!s.startsWith("0") || L==1)) {
                count++;
            }
        } else {
            for (char[] p : pairs) {
                dfs(p[0]+s+p[1], L, low, high);
            }
        }
    }

    // Time: O(N * 5^L) where N is the len diff between L1 and L2, L is the average Length
    public int strobogrammaticInRange(String low, String high) {
        L1=low.length(); L2=high.length(); count=0;
        for (int i=L1; i<=L2; i++) {
            char[] c = new char[i];
            dfs(c, 0, i-1, low, high);
        }
        return count;
    }

    private void dfs(char[] c, int left, int right, String low, String high) {
        if (left>right) {
            String s = String.valueOf(c);
            if (compare(s, low)>=0 && compare(s, high)<=0 && (!s.startsWith("0") || c.length==1)) {
                count++;
            }
        } else {
            for (char[] p : pairs) {
                if (left==right && p[0]!=p[1]) continue;
                c[left]=p[0]; c[right]=p[1];
                dfs(c, left+1, right-1, low, high);
            }
        }
    }

    private int compare(String s1, String s2) {
        return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
    }

    public static void main(String... args) {
        StrobogrammaticNumberIII sb = new StrobogrammaticNumberIII();
        // int res = sb.strobogrammaticInRange("1", "1");
        int res = sb.strobogrammaticInRange("50", "100");
        System.out.println(res);
    }
}
