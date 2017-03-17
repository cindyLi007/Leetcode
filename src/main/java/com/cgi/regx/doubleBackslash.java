package com.cgi.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ychang on 9/26/2016.
 */
public class doubleBackslash {

  public static void main(String[] args) throws java.lang.Exception {
    String str = "\\u005c";
    Matcher m = Pattern.compile("(?i)\\\\u([\\da-f]{4})").matcher(str);
    if (m.find()) {
      String a = String.valueOf((char) Integer.parseInt(m.group(1), 16));
      System.out.printf("Unicode String is: [%s]%n", a);
      System.out.printf("%s", a);
    }
  }
}
