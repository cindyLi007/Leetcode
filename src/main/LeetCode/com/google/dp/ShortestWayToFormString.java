package com.google.dp;

public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        return helper(source,  target, 0);
    }

    private int helper(String source, String target, int idx) {
        int N = target.length();

        int start=idx;
        for (int i=0; i<source.length() && idx<N; i++) {
            if (source.charAt(i)==target.charAt(idx)) idx++;
        }
        if (idx==N) return 1;
        if (start==idx) return -1;
        int v = helper(source, target, idx);
        return v==-1 ? -1 : v+1;
    }

    public static void main(String... args) {
        ShortestWayToFormString shortestWayToFormString = new ShortestWayToFormString();
        int shortestWay = shortestWayToFormString.shortestWay("aaaaa", "aaaaaaaaaaaaa");
        System.out.println(shortestWay);
    }
}
