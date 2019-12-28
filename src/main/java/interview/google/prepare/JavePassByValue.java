package interview.google.prepare;

import java.util.Iterator;
import java.util.LinkedList;

public class JavePassByValue {

  public void test() {
    LinkedList<Integer> A = new LinkedList<>();
    A.addLast(7);
    A.addLast(17);
    A.addLast(27);
    change(A);
    Iterator a = A.iterator();
    while (a.hasNext()) {
      System.out.println(a.next());
    }
  }

  private void change(LinkedList<Integer> A) {
    LinkedList<Integer> B = new LinkedList<>();
    A.addLast(10);
    B.addLast(20);
    B.addLast(30);
    A = B;
  }

  public static void main(String... args) {
    JavePassByValue javePassByValue = new JavePassByValue();
    javePassByValue.test();
  }
}
