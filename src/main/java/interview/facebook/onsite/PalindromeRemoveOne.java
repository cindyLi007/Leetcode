package interview.facebook.onsite;

/**
 * Given a string, return whether we can make it as a Palindrome by removing only one char
 * For ex. "racecar, we can make by removing "e", or "acecar" we can remove last r, or "abab" we can remove the first a
 * or last b.
 * A palindrome can still be a palindrome by removing one char
 */

public class PalindromeRemoveOne {

  // O(N)
  public static boolean remove(String s) {
    int N = s.length();
    if (N <= 2) return true; // remove 1 char can make it Palindrome
    int c1 = s.charAt(0), c2 = s.charAt(N - 1);
    if (c1 != c2) {
      // if c1 != c2, we must remove one of them, so we only need to check whether [c1, c2-1] or [c1+1, c2} is palindrome
      return isPalindrome(s.substring(1)) || isPalindrome(s.substring(0, N - 1));
    } else {
      // if c1 == c2, we does not care c1 and c2, because we need not remove them, so we check substring[c1+1, c2-1]
      return remove(s.substring(1, N - 1));
    }
  }

  // O(N)
  private static boolean isPalindrome(String substring) {
    int i=0, j=substring.length()-1;
    while (i<j) {
      if (substring.charAt(i++)!=substring.charAt(j--)) return false;
    }
    return true;
  }

  public static void main(String... args) {
    System.out.println(remove("racecar")); // true;
    System.out.println(remove("dad")); // true
    System.out.println(remove("abace")); // false
    System.out.println(remove("acecar")); // true
  }



}
