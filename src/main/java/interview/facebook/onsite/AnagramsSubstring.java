package interview.facebook.onsite;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a HayStack and a needle, return whether the HayStack contains an anagram string of needle
 * For ex. HayStack "actor" needle: "car" -1; needle: "rot" return 2, needle "cat" return 0
 * Should use sliding window
 */
public class AnagramsSubstring {

  public static int findAnagramSubstring(String hayStack, String needle) {
    Map<Character, Integer> count = new HashMap();
    for (char c : needle.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }
    int counter = 0;
    for (int left = 0, right = 0; right < hayStack.length(); right++) {
      char c = hayStack.charAt(right);
      /*// case one, we need start over search from right + 1, set left = right+1, before that need recover map
      if (!count.containsKey(c)) {
        while (left < right) {
          char k = hayStack.charAt(left++);
          count.put(k, count.get(k) + 1);
          counter--;
        }
        left++;
        // case 2, we need start from the char just after the duplicated one, so we need find the 1st place which c appears after left,
        // set left = that place + 1
      } else if (count.get(c) == 0) {
        while (hayStack.charAt(left)!=c) {
          char k = hayStack.charAt(left++);
          count.put(k, count.get(k) + 1);
          counter--;
        }
        left++;*/
      if (!count.containsKey(c) || count.get(c) == 0) {
        while (left < right && hayStack.charAt(left) != c) {
          char k = hayStack.charAt(left++);
          count.put(k, count.get(k) + 1);
          counter--;
        }
        left++;
      } else {
        count.put(c, count.get(c) - 1);
        counter++;
        if (counter == needle.length()) return left;
      }
    }
    return -1;
  }

  public static void main(String... args) {
    System.out.println(findAnagramSubstring("babc", "bac")); // should be 1
    System.out.println(findAnagramSubstring("actor", "otc")); // should be 1
    System.out.println(findAnagramSubstring("actor", "tca")); // should be 0
    System.out.println(findAnagramSubstring("actor", "rot")); // should be 2
    System.out.println(findAnagramSubstring("actor", "roa")); // should be -1
  }

}
