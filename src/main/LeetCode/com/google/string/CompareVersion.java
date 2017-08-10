package com.google.string;

/**
 * Created by ychang on 8/9/2017.
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering: 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersion {
  public int compareVersion(String version1, String version2) {
    /**
     * IMPORTANT: must use \\. to identify . instead of only ".", because that is for any char
     */
    String[] v1=version1.split("\\.");
    String[] v2=version2.split("\\.");
    int i=0;
    for (; i<v1.length || i<v2.length; i++) {
      int n1 = i>=v1.length ? 0 : Integer.parseInt(v1[i]);
      int n2 = i>=v2.length ? 0 : Integer.parseInt(v2[i]);
      if (n1==n2) continue;
      return n1>n2 ? 1 : -1;
    }
    return 0;
  }
}
