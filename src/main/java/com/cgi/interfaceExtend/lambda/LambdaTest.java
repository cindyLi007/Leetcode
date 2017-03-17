package com.cgi.interfaceExtend.lambda;

/**
 * Created by ychang on 7/27/2016.
 */
public class LambdaTest {

  public static void main(String[] args) {
    String[] strList01 = {"tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"};
    String searchStr = "to";

    System.out.println("Searching for " + searchStr);

    System.out.println("=====Contains=====");
    AnalyzerTool.showResult(strList01, searchStr, (t, s) -> t.contains(s));

    System.out.println("=====Starts With=====");
    AnalyzerTool.showResult(strList01, searchStr, (t, s) -> t.startsWith(s));

    System.out.println("=====Equals=====");
    AnalyzerTool.showResult(strList01, searchStr, (t, s) -> t.equals(s));

    System.out.println("=====Ends With=====");
    AnalyzerTool.showResult(strList01, searchStr, (t, s) -> t.endsWith(s));

    System.out.println("=====Less than 5=====");
    AnalyzerTool.showResult(strList01, searchStr, (t, s) -> t.contains(s) && t.length() < 5);

    System.out.println("=====Greater than 5=====");
    AnalyzerTool.showResult(strList01, searchStr, (t, s) -> t.contains(s) && t.length() > 5);
  }
}
