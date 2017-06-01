package com.google.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/13/2017.
 * Assuming the average number of letters on every number is m(4), the length of digits string is n, time complexity is
 * O(m^n), for example (4^n)
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

  String[] array = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  public List<String> letterCombinations_dfs(String digits) {
    List<String> res = new ArrayList();
    if (digits==null || digits.length()==0) return res;
    dfs(digits.toCharArray(), 0, "", res);
    return res;
  }
  private void dfs(char[] digits, int index, String prefix, List<String> res) {
    if (digits.length==index) res.add(prefix);
    else {
      int i = digits[index]-'0';
      char[] letters = array[i].toCharArray();
      for (char ch : letters) {
        dfs(digits, index+1, prefix+ch, res);
      }
    }
  }
}
