package interview.Airbnb;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Build a queue class with the enqueue and dequeue methods. The queue can store an *UNLIMITED* number of elements.
 * However, the language you are using has a bug which does not allow arrays to store more than 5 elements, how would you build that?
 * Q: If you use a normal Linkedlist, does it meet our requirements?
 * Yes
 * Q: does a normal linkedlist use any arrays that store more than 5 elements?
 * No, use node to store element
 * Q: can you build a queue class that
 * - that stores an unlimited number of elements
 * - DOES use arrays (But each array does not store more than 5)
 * Q: pros/cons of list of arrays vs normal linkedlist for a queue.
 * - pros: no overhead to keep next node's pointer, save space.
 * - cros: no resize the datastruce when it overflow
 * <p>
 * To execute Java, please define "static void main" on a class named Solution.
 * <p>
 * If you need more classes, simply define them inline.
 */

public class AirbnbQueue {
    int SIZE = 5;
    List<int[]> list;
    int hidx, tidx;

    public AirbnbQueue() {
        list = new LinkedList<>();
        list.add(new int[SIZE]);
        hidx = 0;
        tidx = 0;
    }

    public void enqueue(int v) {
        int[] cur = list.get(list.size() - 1);
        cur[tidx++] = v;
        if (tidx == SIZE) {
            list.add(new int[SIZE]);
            tidx = 0;
        }
    }

    public int dequeue() throws Exception {
        if (list.isEmpty() || (list.size() == 1 && hidx == tidx)) {
            list.remove(0);
            throw new NoSuchElementException("empty is empty");
        }
        int[] res = list.get(0);
        int r = res[hidx++];
        if (hidx == SIZE) {
            list.remove(0);
            hidx = 0;
        }
        return r;
    }

    public static void main(String... args) throws Exception {
        AirbnbQueue qu = new AirbnbQueue();

        for (int i = 0; i < 16; i++) {
            qu.enqueue(i);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(qu.dequeue());
        }
        System.out.println();
        for (int i = 16; i < 40; i++) {
            qu.enqueue(i);
        }
        for (int i = 0; i < 40; i++) {
            System.out.println(qu.dequeue());
        }
    }

}
