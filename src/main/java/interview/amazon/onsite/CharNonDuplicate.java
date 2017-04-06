package interview.amazon.onsite;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ychang on 4/4/2017.
 */
public class CharNonDuplicate {
  Deque<Character> list = new LinkedList();
  int[] hash = new int[256];

  public void input(Character c) {
    if (hash[c]==0) {
      list.add(c);
      hash[c]=1;
    } else {
      if (list.contains(c)) list.remove(new Character(c));
    }
  }

  public Character latestNonDuplicated(){
    if (list.isEmpty()) return null;
    return list.peekLast();
  }
}
