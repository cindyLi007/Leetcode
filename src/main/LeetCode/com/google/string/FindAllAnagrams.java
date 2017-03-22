package com.google.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychang on 3/14/2017. This is also a template for all (String, substring) problem, check comments below
 */
public class FindAllAnagrams {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s==null || s.length()==0 || p==null || p.length()==0)
      return list;

    /**
     * create a char hash map for all char, [char, times of appearance in target string], record each character in p to hash
     */
    int[] hash = new int[26];
    for (char c : p.toCharArray()) {
      hash[c-'a']++;
    }

    /** two points, left and right edge of sliding window initialize count to p's length
     */
    int left = 0, right = 0, count = p.length();

    while (right<s.length()) {
      /** if the character's hash entry must > 0, that means it existing in p and have not achieve the number in p, so we can
       * count it in target string, decrease the count
      */
      if (hash[s.charAt(right)-'a']>0) {
        count--;
      }
      /**
       * we need decrease a char number in hash map even it does not exist in p, it will introduce this char entry to
       * negative, but this is fine, we will increment back in line 57.
       */
      hash[s.charAt(right)-'a']--;
      right++;

      /** when the count is down to 0, means we found the right anagram, then add window's left to result list, because
        * anytime we only keep a p.length() window, the count can always change between p.length() to 0
       */
      if (count==0) {
        list.add(left);
      }

      /** if we find the window's size equals to p, then we have to shift window left to find the new match windows
       * any entry in the hash which value >=0 means this char in p, so if we find the left (we will shift out) 's hash
       * value is >=0, we need count++ since in line 31 to 33, we decrease count. Reset the hash[left] because we kicked
       * out the left, the hash[c] >= 0 indicate it was original in the hash, cuz it won't go below 0
       */
      if (right - left==p.length()) {
        if (hash[s.charAt(left)-'a']>=0) {
          count++;
        }
        hash[s.charAt(left)-'a']++;
        left++;
      }
    }

    return list;
  }
}
