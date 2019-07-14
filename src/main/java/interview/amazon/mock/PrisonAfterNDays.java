package interview.amazon.mock;

import java.util.HashMap;
import java.util.Map;

public class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int state = 0;
        for (int i=0; i<cells.length; i++) {
            if (cells[i]==1) state |= 1<<(7-i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (N>0) {
            if (map.containsKey(state)) {
                N %= map.get(state)-N;
            }
            map.put(state, N);
            if (N>0) {
                N--;
                state = nextDay(state);
            }
        }
        int[] res = new int[8];
        String s = Integer.toBinaryString(state);
        for (int i=1; i<7; i++) {
            res[i]= (state >> (7-i))&1;
        }
        return res;
    }

    private int nextDay(int state) {
        int res = 0;
        for (int i=1; i<7; i++) {
            if ((((state >> (8-i))&1) ^ ((state >> (8-2-i)) & 1)) == 0) {
                res |= 1 << (8-1-i);
            }
        }
        return res;
    }

    public static void main(String... args) {
        PrisonAfterNDays prisonAfterNDays = new PrisonAfterNDays();
        // should be 0, 0, 1, 1, 0, 0, 0, 0
//        int[] res = prisonAfterNDays.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
        // should be 0, 0, 1, 1, 1, 1, 1, 0,
        int[] res = prisonAfterNDays.prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
        for (int i : res) {
            System.out.print(i + ", ");
        }
    }
}
