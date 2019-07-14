package com.google.string;

public class RepeatedStringMatch {
    /**
     * suppose q is the least number for which len(B) <= len(A * q). We only need to check whether B is a substring of A * q or A * (q+1).
     * When k = q+1, A * k is already big enough to try all positions for B; namely, A[i:i+len(B)] == B for i = 0, 1, ..., len(A) - 1.
     * because when i==len(A)-1, A[i:i+len(B)] is still in string range. for ex.
     * A = "ABCD", B="DABCDABC", the string "ABCDABCDABCD", from idx 3 DABCDABCD must can check all pos in A
     */
    public int repeatedStringMatch(String A, String B) {
        int count=1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.indexOf(B)>=0) return count;
        if (sb.append(A).indexOf(B)>=0) return count+1;
        return -1;
    }
}
