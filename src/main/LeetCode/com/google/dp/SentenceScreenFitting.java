package com.google.dp;

public class SentenceScreenFitting {
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int L = s.length();
        int start = 0;
        // process by every line
        for (int i=0; i<rows; i++) {
            // start is index of sentence, each round it pointing the char which is the 1st letter of
            // the word in the begining of the row
            // (start + cols) means with one row, from this idx, it can go to where of the sentence
            // because it can be rotate to the begining of the string, so we need use start%L
            start+=cols;
            // start % L should be the 1st letter of next row, if it is a space, we need not reserve it
            // just move forward the start
            if (s.charAt(start%L)==' ') start++;
            else {
                //if hit a letter, need backtrack to the last previous space to keep the word non-breaking
                while (start>=0 && s.charAt(start%L)!=' ') start--;
                start++;
            }
            /* we can use this inside loop, same effect as above code
                start+=cols;
                while (start>=0 && s.charAt(start%L)!=' ') start--;
                start++;
             */
        }
        return start/L;
    }



    public static void main(String... args) {
        int res = wordsTyping(new String[]{"apple"}, 2, 1);
    }
}
