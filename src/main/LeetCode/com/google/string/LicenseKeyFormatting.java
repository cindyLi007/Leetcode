package com.google.string;

/**
 * Created by ychang on 3/31/2017.
 */
public class LicenseKeyFormatting {
  public String licenseKeyFormatting(String S, int K) {
    String[] strs = S.split("-");
    if (strs.length==0)
      return "";
    StringBuilder sb = new StringBuilder();
    for (String str : strs)
    /**
     * put toUpperCase here is faster than put in the return
     */
      sb.append(str.toUpperCase());
    int end = sb.length()%K;
    if (end==0)
      end += K;
    StringBuilder res = new StringBuilder();
    while (end<=sb.length()) {
      res.append(sb.substring(Math.max(0, end - K), end)).append("-");
      end += K;
    }
    return res.substring(0, res.length() - 1);
  }

}
