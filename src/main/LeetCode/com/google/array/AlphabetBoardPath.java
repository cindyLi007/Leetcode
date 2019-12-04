package com.google.array;

public class AlphabetBoardPath {
  public String alphabetBoardPath(String target) {
    StringBuilder sb = new StringBuilder();
    int prevX = 0, prevY = 0;
    for (char c : target.toCharArray()) {
      int idx = c-'a';
      int curX = idx/5, curY = idx%5;
      sb.append(helper(prevX, prevY, curX, curY));
      prevX = curX; prevY = curY;
    }
    return sb.toString();
  }

  private String helper(int prevX, int prevY, int curX, int curY) {
    StringBuilder sb = new StringBuilder();
    while (prevX > curX) { sb.append('U'); prevX--; }
    while (prevX < curX) { sb.append('D'); prevX++; }
    while (prevY > curY) { sb.append('L'); prevY--; }
    while (prevY < curY) { sb.append('R'); prevY++; }
    sb.append('!');
    return sb.toString();
  }

  public static void main(String... args) {
    AlphabetBoardPath alphabetBoardPath = new AlphabetBoardPath();
    String s = alphabetBoardPath.alphabetBoardPath("leet");
    System.out.println(s); // "DDR!UURRR!!DDD!"

  }
}
