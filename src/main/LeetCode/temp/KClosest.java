package temp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingDouble(a -> Math.sqrt(a[0] * a[0] + a[1] * a[1])));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size()>K)
                pq.remove();
        }
        int[][] res = new int[K][2];
        int i=0;
        while (!pq.isEmpty()) {
            res[i++] = pq.remove();
        }
        return res;
    }

    class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }

        public int compareTo(Point p) {
            return x*x+y*y - (p.x*p.x + p.y*p.y);
        }
    }

    public static void main(String... args) {
        KClosest kClosest = new KClosest();
        int[][] res = kClosest.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);

    }
}
