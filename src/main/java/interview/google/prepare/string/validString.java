package interview.google.prepare.string;

/**
 * Given a String, validate if it is a valid identifier. If any characters in a string are appearing more than 3 times
 * consecutively, the string is invalid else valid. Follow up to design a algorithm to find such valid identifiers and design a system.
 */
public class validString {

  // Time: O(N), Space: O(1)
  public boolean isValidString(String s) {
    // from the idx 0 to N-1, record cur char and compare it with prev
    if (s.length() <= 3) return true;
    char c = s.charAt(0);
    int count = 1;
    for (int i=1; i<s.length(); i++) {
      if (s.charAt(i)==c) {
        count++;
        if (count>3) return false;
      } else {
        c = s.charAt(i);
        count = 1;
      }
    }
    return true;
  }
}
