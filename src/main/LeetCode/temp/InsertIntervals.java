package temp;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        List<int[]> res = new ArrayList();
        int i=0;
        while (i<N && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        if (i<N) newInterval[0] = Math.min(newInterval[0], intervals[i++][0]);
        while (i<N && intervals[i][0] < newInterval[1]) {
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i<N) res.add(intervals[i++]);
        int size = res.size();
        int[][] r = new int[size][2];
        for (i=0; i<size; i++) r[i]=res.get(i);
        return r;
    }

    public static void main(String... args) {
        int[][] res = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }
}
