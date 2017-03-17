package com.cgi.interfaceExtend.lambda;

import java.util.Arrays;

/**
 * Created by ychang on 7/27/2016.
 */
public interface AnalyzerTool {
  static void showResult(String[] strList01, String searchStr, StringAnalyzer stringAnalyzer) {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(strList01).forEach(s -> {
      if (stringAnalyzer.analyze(s, searchStr)) {
        sb.append(s + " ");
      }
    });
    System.out.println("Match: " + sb.toString().trim());
  }
}
