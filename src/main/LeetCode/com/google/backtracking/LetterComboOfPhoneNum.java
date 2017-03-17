package com.google.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/13/2017.
 */
public class LetterComboOfPhoneNum {
  public List<String> letterCombinations(String digits) {
    List<String> res = new LinkedList();
    String[] array = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    if (digits.length()==0)
      return res;
    res.add("");
    for (char c : digits.toCharArray()) {
      char[] cur = array[c - '0'].toCharArray();
      int size = res.size();
      for (int i = 0; i<size; i++) {
        // every time remove the first string
        String s = res.remove(0);
        for (char ch : cur) {
          // String can directly append a char
          res.add(s + ch);
        }
      }
    }
    return res;
  }
}
