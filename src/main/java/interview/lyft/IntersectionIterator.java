package interview.lyft;

/* Given two iterators that return SORTED integers, build an iterator with a `next` method that
    iterates over the intersection of it1 and it2, i.e. only the elements that appear in both.
    Example:
    Iterator<Integer> i1 = testIter(1, 2, 3, 4, 5, 6, 10)
    Iterator<Integer> i2 = testIter(2, 3, 10, 11)
    Output:
    IntersectionIterator iter = IntersectionIterator(i1, i2)
    iter.next() -> 2
    iter.next() -> 3
    iter.next() -> 10

    The official Java iterator documentation can be found here: https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
*/

import java.util.*;

import static org.junit.Assert.assertEquals;

public class IntersectionIterator implements Iterator<Integer> {

  private Iterator<Integer> it1;
  private Iterator<Integer> it2;
  private Integer next;

  public IntersectionIterator(Iterator<Integer> it1, Iterator<Integer> it2) {
    this.it1 = it1;
    this.it2 = it2;
  }

  @Override
  public boolean hasNext() {
    while (it1.hasNext() && it2.hasNext()) {
      Integer e1 = it1.next(), e2 = it2.next();
      while (!e1.equals(e2)) {
        if (e1.compareTo(e2) < 0) {
          if (!it1.hasNext()) return false;
          e1 = it1.next();
        } else {
          if (!it2.hasNext()) return false;
          e2 = it2.next();
        }
      }
      next = e1;
      return true;
    }
    return false;
  }

  @Override
  public Integer next() {
    return next;
  }

  private static List<Integer> commonElements(Iterator<Integer> it1, Iterator<Integer> it2) {
    IntersectionIterator interIter = new IntersectionIterator(it1, it2);
    List<Integer> list = new ArrayList<>();
    while (interIter.hasNext()) {
      Integer next = interIter.next();
      System.out.print(next + ", ");
      list.add(next);
    }
    System.out.println();
    return list;
  }

  public static void main(String[] args) {
    System.out.println(16 & (16 - 1));
    // return the int which is at most 1 which is the highest one bit in n
    int n = Integer.highestOneBit(15);
    System.out.println(n);
    int m = n << 1;
    System.out.println(m);
    Iterator<Integer> it1 = testIter(1, 2, 3);
    Iterator<Integer> it2 = testIter(1, 3);
    assertEquals(Arrays.asList(1, 3), commonElements(it1, it2));
    additionalTestCases();
  }

  public static Iterator<Integer> testIter(Integer... ints) {
    return Arrays.asList(ints).iterator();
  }

  public static void additionalTestCases() {
    Iterator<Integer> it1 = testIter(1, 2, 3, 4, 5, 6);
    Iterator<Integer> it2 = testIter(2, 3, 4, 10, 11);
    assertEquals(Arrays.asList(2, 3, 4), commonElements(it1, it2));

    it1 = testIter(1, 2);
    it2 = testIter(1, 2);
    assertEquals(Arrays.asList(1, 2), commonElements(it1, it2));

    it1 = testIter();
    it2 = testIter();
    assertEquals(Collections.emptyList(), commonElements(it1, it2));

    it1 = testIter(1);
    it2 = testIter(1);
    assertEquals(Arrays.asList(1), commonElements(it1, it2));
    System.out.println("Tests pass!");
  }
}
