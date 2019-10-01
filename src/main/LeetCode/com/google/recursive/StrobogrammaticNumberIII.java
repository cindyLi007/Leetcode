package com.google.recursive;

public class StrobogrammaticNumberIII {
    static int res = 0, len1=0, len2=0;
    public static int strobogrammaticInRange(String low, String high) {
        len1=low.length(); len2=high.length();
        for (int i=len1; i<=len2; i++) {
            helper("", i, low, high);
            helper("1", i, low, high);
            helper("0", i, low, high);
            helper("8", i, low, high);
        }
        return res;
    }

    private static void helper(String s, int targetLen, String low, String high) {
        int len = s.length();
        if (len > targetLen) return;

        if (len == targetLen) {
            if (len==len2 && s.compareTo(high) > 0 || len==len1 && s.compareTo(low) < 0 || len!=1 && s.charAt(0)=='0') {
                return;
            } else {
                res++;
            }
        } else {
            helper("0" + s + "0", targetLen, low, high);
            helper("1" + s + "1", targetLen, low, high);
            helper("8" + s + "8", targetLen, low, high);
            helper("6" + s + "9", targetLen, low, high);
            helper("9" + s + "6", targetLen, low, high);
        }
    }

    public static void main(String... args) {
        StrobogrammaticNumberIII sb = new StrobogrammaticNumberIII();
        int res = sb.strobogrammaticInRange("1", "1");
//        int res = sb.strobogrammaticInRange("50", "100");
        System.out.println(res);
    }
}
