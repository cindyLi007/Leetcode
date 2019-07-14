package com.google.string;

public class ReverseStringII {
    public static String reverseStr(String s, int k) {
        int N=s.length(), i=0;
        StringBuilder sb = new StringBuilder();
        while (i<N) {
            int end = Math.min(N, i+k);
            StringBuilder sb1 = new StringBuilder(s.substring(i, end));
            sb.append(sb1.reverse());
            if (end < N) {
                int end1 = Math.min(end+k, N);
                sb.append(s.substring(end, end1));
            }
            i+=2*k;
        }
        return sb.toString();
    }

    public static void main(String... args) {
        String res = reverseStr("abcdefg", 2);
        System.out.println(res);
    }
}
