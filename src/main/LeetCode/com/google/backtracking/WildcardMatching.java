package com.google.backtracking;

/**
 * Created by ychang on 5/12/2017.
 * this can beat 97%
 */
public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    int sp = 0, pp = 0, lastStar = -1, firstBack = 0;
    while (sp<s.length()) {
      if (pp<p.length() && (s.charAt(sp)==p.charAt(pp) || p.charAt(pp)=='?')) {
        sp++;
        pp++;
      } else if (pp<p.length() && p.charAt(pp)=='*') {
        /** we need absorb as much as possible char in P, so first skip "*", but record its index for later backtrack;
         * if there are multiple "*", we only need the last one
        */
        lastStar = pp++;
        // firstBack is the index in S when later mismatch, backtrack from its next char
        firstBack = sp;
      } else if (lastStar!=-1) { // we can backtrack since we encounter a "*" before
        /** if mismatch happens, we need go back to last "*" in P and the char which first compare with the "*" in S.
         * We try to make "*" match as little as possible. So set pp to the next char to "*", and sp to next char
         * to 1st-char-compare-to-"*"
        */
        pp = lastStar + 1;
        sp = ++firstBack;
      } else
        return false;
    }
    while (pp<p.length() && p.charAt(pp)=='*')
      pp++;
    return pp==p.length();
  }
}
