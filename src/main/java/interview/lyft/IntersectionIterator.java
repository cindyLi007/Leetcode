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

    public IntersectionIterator(Iterator<Integer> it1, Iterator<Integer> it2) {
        this.it1 = it1;
        this.it2 = it2;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        if (!it1.hasNext() || !it2.hasNext()) return null;
        int i1 = it1.next(), i2 = it2.next();
        while (i1 != i2) {
            if (i1 < i2) {
                if (it1.hasNext()) i1 = it1.next();
                else return null;
            } else {
                if (it2.hasNext()) i2 = it2.next();
                else return null;
            }
        }
        return i2;
    }

    private static List<Integer> commonElements(Iterator<Integer> it1, Iterator<Integer> it2) {
        IntersectionIterator interIter = new IntersectionIterator(it1, it2);
        List<Integer> list = new ArrayList<>();
        Integer i = interIter.next();
        while (i!=null) {
            list.add(i);
            i = interIter.next();
        }
        return list;
    }

    public static void main(String[] args) {
        Iterator<Integer> it1 = testIter(1, 2, 3);
        Iterator<Integer> it2 = testIter(1, 3);
        additionalTestCases();
        assertEquals(Arrays.asList(1, 3), commonElements(it1, it2));
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
