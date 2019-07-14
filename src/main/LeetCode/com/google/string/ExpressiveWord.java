package com.google.string;

public class ExpressiveWord {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            if (match(word, S)) res++;
        }
        return res;
    }

    private boolean match(String word, String s) {
        int N = s.length(), M=word.length();
        if (N<M) return false;
        if (s.equals(word)) return true;
        int i=0, j=0;
        while (i<N && j<M) {
            char c1 = s.charAt(i), c2 = word.charAt(j);
            if (c1!=c2) return false;
            int count1=1;
            while (i<N-1 && s.charAt(i)==s.charAt(i+1)) {
                count1++;
                i++;
            }
            int count2=1;
            while (j<M-1 && word.charAt(j)==word.charAt(j+1)) {
                count2++;
                j++;
            }
            i++; j++;
            if (count1<count2 || (count1>count2 && count1<3)) return false;
        }
        return i==N && j==M;
    }

    public static void main(String... args) {
        ExpressiveWord expressiveWord = new ExpressiveWord();
        int res = expressiveWord.expressiveWords("zzzzzyyyyy", new String[]{"zzyy","zy","zyy"});
        System.out.println(res);
    }
}
