package com.google.stack;

import java.util.Stack;

/**
 * Created by ychang on 6/22/2017.
 */
public class TagValidation {
  public boolean isValid(String code) {
    Stack<String> stack = new Stack();
    int i = 0, len = code.length();
    while (i<len) {
      if (i!=0 && stack.isEmpty())
        return false; // all TAG_CONTENT must be in a root_tag, stack.isEmpty() means now there is not root tag
      if (code.charAt(i)=='<') {
        if (i + 1==len || code.indexOf('>', i + 1)==-1)
          return false; // must have a '>' after '<'
        char next = code.charAt(i + 1);
        if (next!='/' && next!='!') {
          // begin a next tag
          String tag = code.substring(i + 1, code.indexOf('>', i + 1));
          if (!validTag(tag))
            return false;
          stack.push(tag);
        } else if (next=='/') {
          // end a tag
          String tag = code.substring(i + 2, code.indexOf('>', i + 2));
          if (stack.isEmpty() || !tag.equals(stack.pop()))
            return false; // Tag is not matched
        } else { // CDATA_CONTENT
          if (i + 9>=len || code.indexOf("<![CDATA[", i)==-1 || code.indexOf("]]>", i + 9)==-1)
            return false; // CDATA_CONTENT tag is not matched
          i = code.indexOf("]]>", i + 9) + 3;
          continue;
        }
        i = code.indexOf('>', i + 1) + 1;
      } else {
        i++;
      }
    }
    return stack.isEmpty();
  }

  private boolean validTag(String tag) {
    int len = tag.length();
    if (len<=0 || len>9)
      return false;
    for (char c : tag.toCharArray()) {
      if (c<'A' || c>'Z')
        return false;
    }
    return true;
  }
}
