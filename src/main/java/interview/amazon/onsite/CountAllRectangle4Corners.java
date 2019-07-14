package interview.amazon.onsite;

import java.util.*;

// given a binary matrix, find the count_bruteForce of rectangels which all 4 corners are 1
public class CountAllRectangle4Corners {

    // this way can only check whethere there are rectangle which all 4 corners are 1 exists or not, but could not count
    // correct the number. O(M*N^2)
    public static int count_HashMap(int[][] matrix) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int M=matrix.length, N=matrix[0].length, count=0;
        for (int i = 0; i < N; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (matrix[i][j]==1) {
                    for (int k = j + 1; k < N; k++) {
                        if (matrix[i][k] == 1) {
                            if (map.get(j).contains(k))
                                count++;
                            else map.get(j).add(k);
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int Com(Integer x) {
        int i = mul(x);
        int y = mul(x-2);
        return i/(y*2);
    }

    private static int mul(int x) {
        int res = 1;
        for (int i=x; i>=2; i--) {
            res *=i;
        }
        return res;
    }


    // Time: O(M^2*N^2)
    public static int count_bruteForce(int[][] matrix) {
        int M=matrix.length, N=matrix[0].length;
        int res = 0;
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (matrix[i][j]==1) {
                    for (int x=i+1; x<M; x++) {
                        if (matrix[x][j]==1) {
                            for (int y=j+1; y<N; y++) {
                                if (matrix[x][y]==1) {
                                    res += matrix[i][y]==1 ? 1 : 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String... args) {
        int[][] matrix = {  {1, 0, 1, 1, 0},
                            {0, 0, 1, 1, 1},
                            {0, 0, 1, 1, 0},
                            {1, 0, 1, 0, 1}};
        int count_bruteForce = count_bruteForce(matrix);
        int count_hashMap = count_HashMap(matrix);
        System.out.println("count from brute Force " + count_bruteForce);
        System.out.println("count from Hash Map " + count_hashMap);
    }
}
