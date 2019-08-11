package interview.amazon.onsite;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by ychang on 4/4/2017.
 * Find the last non Duplicated char in a string
 */
public class CharNonDuplicate {
  List<Character> list = new ArrayList<>();
  Map<Character, Integer> map = new HashMap<>();

  public Character latestNonDuplicated_noStream(String s) {
    for (char c : s.toCharArray()) {
      // for nonstream, map val store the count of the char
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = s.length() - 1; i >= 0; i--) {
      if (map.get(s.charAt(i)) == 1) return s.charAt(i);
    }
    return null;
  }

  public Character latestNonDuplicated() {
    if (list.isEmpty()) return null;
    return list.get(list.size()-1);
  }

  public static void main(String... main) {
    CharNonDuplicate duplicate = new CharNonDuplicate();
    Character nonDuplicated = duplicate.latestNonDuplicated_noStream("abcdcde");
    System.out.println(nonDuplicated);
  }

  public void input(Character c) {
    // for stream, map store the index of the char in the list
    if (map.containsKey(c) && map.get(c) >=0) {
      list.remove(map.get(c).intValue());
      map.put(c, -1);
    } else {
      map.put(c, list.size());
      list.add(c);
    }
  }
}
