package interview.weWork;

// 2019-08-29 WeWork
// Given a string which char can be present by 1 byte or 2 bytes, if a char is present by 1 byte, it begins with 0,
// if a char is present by 2 bytes, it begins with 1, given a position which is a beginning of a char in the middle of
// the string, how to find it previous char's beginning position?

public class FindPrevChar {

  // Time: O(n) n is the string length
  public static int findPrevChar(String s, int pos) {
    int countOfOne = 0;
    int b1 = move1Byte(s, pos), b2 = move1Byte(s, b1);
    int run = b2;
    // if the previous byte is 0 we can stop, because we know it could NOT be a beginning of a two-byte char,
    // otherwise we need move backward till the start of the string or find a 0-beginning byte
    while (run >=0 && testFirstBit(s, run) == 1) {
      countOfOne++;
      run = move1Byte(s, run);
    }
    return countOfOne % 2 == 1 ? b2 : b1;
  }


  // this is a provided helper method to move to previous byte
  private static int move1Byte(String s, int pos) {
    return pos-8;
  }

  // this is a provided helper method to test first bit is 0 or 1
  private static int testFirstBit(String s, int pos) {
    return s.charAt(pos)-'0';
  }

  public static void main(String... args) {
    StringBuilder sb = new StringBuilder();
    String oneChar = "01010101", twoChar = "1101010111010101";
    sb.append(oneChar).append(twoChar).append(twoChar).append(twoChar).append(twoChar).append(twoChar);
    int prevChar = findPrevChar(sb.toString(), sb.length() - 16);
    System.out.println(sb.toString().length());
    System.out.println(prevChar);
  }
}
