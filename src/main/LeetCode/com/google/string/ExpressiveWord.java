package com.google.string;

public class ExpressiveWord {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            if (valid(word, S)) res++;
        }
        return res;
    }

    private boolean valid(String s, String w) {
        int M = s.length(), N = w.length(), i=0, j=0;
        // outer loop make sure each time s[i]==w[j]; it is a new char group start point
        while (i<M && j<N) {
            if (s.charAt(i)!=w.charAt(j)) return false;
            int i1=i, j1=j;
            char c = s.charAt(i);
            // inner loop to count of char c
            while (i1<M && s.charAt(i1)==c) i1++;
            while (j1<N && w.charAt(j1)==c) j1++;
            int count1 = i1-i, count2 = j1-j;
            if (count1<count2 || count1>count2 && count1<3) return false;
            i=i1; j=j1;
        }
        return i==M && j==N;
    }

    public static void main(String... args) {
        ExpressiveWord expressiveWord = new ExpressiveWord();
        int res = expressiveWord.expressiveWords("zzzzzyyyyy", new String[]{"zzyy","zy","zyy"});
        System.out.println(res);
    }
}
