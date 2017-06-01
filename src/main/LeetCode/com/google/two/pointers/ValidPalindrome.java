package com.google.two.pointers;

/**
 * Created by ychang on 5/6/2017.
 */
public class ValidPalindrome {
  /**
   * this can beat 13%
   */
  public boolean isPalindrome(String s) {
    if (s==null || s.length()<=1)
      return true;
    /**
     * MUST use replaceAll instead of replace, because replace method does not take regEx.
     */
    char[] ss = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase().toCharArray();
    int i = 0, j = ss.length - 1;
    while (i<j) {
      if (ss[i++]!=ss[j--])
        return false;
    }
    return true;
  }

  /**
   * this can beat 75%, use some Character API to handle pre-processing
   */
  public boolean isPalindrome_faster(String s) {
    char[] ss = s.toCharArray();
    int i = 0, j = ss.length - 1;
    while (i<j) {
      char c1 = ss[i], c2 = ss[j];
      if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) {
        if (Character.toLowerCase(c1)!=Character.toLowerCase(c2))
          return false;
        i++;
        j--;
      } else {
        if (Character.isLetterOrDigit(c1))
          j--;
        else
          i++;
      }
    }
    return true;
  }
}
