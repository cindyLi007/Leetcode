package com.google.two.pointers;

public class BackspaceCompare {
    // Time:O(M+N)
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1, j = T.length()-1;
        // must be "or" instead of "and" because even one is run out and the other does not, they still can be same
        while (i>=0 || j>=0) {
            // make i and j stop in the first "useful" char which will show in final string
            i = process(S, i);
            j = process(T, j);
            if (i>=0 && j>=0 && S.charAt(i)!=T.charAt(j)) return false;
            if ((i>=0) != (j>=0)) return false;
            i--; j--;
        }
        return true;
    }

    private int process(String s, int i) {
        int back = 0;
        while (i>=0) {
            if (s.charAt(i)=='#') back++;
            else {
                if (back>0) back--;
                else return i;
            }
            i--;
        }
        return i;
    }

    public static void main(String... args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        boolean res = backspaceCompare.backspaceCompare("bbbextm", "bbb#extm");
        System.out.println(res);
    }
}
