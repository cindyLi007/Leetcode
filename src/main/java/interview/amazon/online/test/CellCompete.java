package interview.amazon.online.test;

import java.util.*;

/**
 * Eight houses, represented as cells, are arragned in a straight line. Each day every cell cometes with its adjacent cells
 * (neighbors). An int value of 1 means active cell and a value of 0 means an inactive cell. If the neighbors on both sides of
 * a cell are either active or inactive, the cell becomes inactive on the next day, otherwise the cell becomes active.
 * The 2 cells on each end have a single adjacent cell, so assume that the unoccupied sapce on teh opposite side is an inactive cell
 * Even after updating the cell state, consider its previous state when updatign the state of other cells. The state information
 * of all cells should be updated simultaneously.
 * Write an algorithm to output the state of the cells after the given number of days
 */
public class CellCompete {

    public List<Integer> cellCompete(int[] states, int day) {
        Map<Integer, Integer> map = new HashMap<>();
        int N=states.length;
        int temp = convert(states);

        for (int d=0; d<day; d++) {
            if (map.containsKey(temp)) {
                temp = map.get(temp);
            } else {
                int cur = 0;
                for (int i=0; i<N; i++) {
                    int left = i==N-1 ? 0 : (temp >>(i+1))&1;
                    int right = i==0 ? 0 : (temp >> (i-1))&1;
                    cur |= (left ^ right) << i;
                }
                map.put(temp, cur);
                temp = cur;
            }
            /*for (int i=0; i<N; i++) {
                if (i==0 || i==N-1) {
                    if (i==0)
                        temp[i]=(states[1] ^ 0);
                    if (i==N-1)
                        temp[i]=(states[N-2] ^ 0);
                } else {
                    temp[i]=states[i-1] ^ states[i+1];
                }
            }
            states = Arrays.copyOf(temp, N);*/
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<N; i++) {
            res.add((temp >> (N - 1 - i)) & 1);
        }
        /*for (int n : states) {
            res.add(n);
        }*/
        return res;
    }

    private Integer convert(int[] states) {
        int res = 0;
        for (int i=0; i<states.length; i++) {
            res |= states[i]<<(states.length-i-1);
        }
        return res;
    }

    public static void main(String... args) {
        CellCompete cellCompete = new CellCompete();

        //nt[] arr = {1, 0, 0, 0, 0, 1, 0, 0};
        int[] arr = {1, 1, 1, 0, 1, 1, 1, 1};

        Integer convertNum = cellCompete.convert(arr);

        System.out.println(convertNum);
        cellCompete.cellCompete(arr, 2);
    }
}
