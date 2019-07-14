package interview.amazon.online.test;

import java.util.*;

/**
 * Amazon OA 5-18-2019
 * Each device should be assigned 2 applications at once, one foreground application and one background application. Devices
 * have limited amounts of memory and can not execute applications that require more memory than the available memroy. The goal
 * of the system is to maximize the total utilization of the memory of a given device. A foreground/background applicatio pair
 * is considered to be optimal if there does not exist another pair that uses more memory than this pair, and alos has a total less
 * than or eequal to this total memory of the device. For ex. if the device has 10MB memory, a foreground/background pair
 * useing a sum total of 9MB memory would be optimal if there does not exist a pair that uses a sum total of 10MB, but would not be
 * optimal if such a pair did exist.
 * <p>
 * Write an algorithm to help James find the sets of foreground and background application paris that optimally utilize the
 * given device for a given list of foreground applications and a given list of backgournd applications.
 * Input
 * The input to the functino/method consists of 3 arguments:
 * deviceCapacity, an integer representing the maximum capacity of the given device;
 * foregoundAppList, a list of pair of integers where the first integer represents the unique ID of a foreground application
 * and the second interger represents the amount of memory required by the application;
 * backgroundAppList, a list of pair of integers where the first integer represents the unique ID of a foreground application
 * and the second interger represents the amount of memory required by the application;
 * Output
 * Return a list of paris of integers representing the paris of IDs of foreground an background applications that optimally
 * utilize the given device. If no pair is possible, return an empty list
 * <p>
 * Examples
 * Ex.1:
 * Input deviceCapacity = 7
 * foregroundAppList = [[1, 2], [2, 4], [3, 6]]
 * backgroundAppList = [[1, 2]]
 * Output [[1, 2]]
 * Explanation: There are only 3 combinations [1, 1], [2, 1], [3, 1], which use a total of 4, 6 and 8 MB memory, respectively.
 * Since 6 is the largest use that does not  exceed 7, [2, 1] is the only optimal pair
 * <p>
 * Ex. 2
 * Input:
 * deviceCapacity = 10
 * foregroundAppList = [[1, 3], [2, 5], [3, 7], [4, 10]]
 * backgroundAppList = [[1, 2], [2, 3], [3, 4], [4, 5]]
 * Output [3, 2], [2, 4]
 */
public class DevicePair {
    // Time: O(M+N), Space: O(1)
    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList) {
        List<List<Integer>> res = new ArrayList<>();
        Collections.sort(foregroundAppList, (Comparator.comparingInt(o -> o.get(1))));
        Collections.sort(backgroundAppList, (Comparator.comparingInt(o -> o.get(1))));
        int i = 0, j = backgroundAppList.size() - 1, curMax=0;
        while (i<foregroundAppList.size() && j>=0) {
            int curSum = foregroundAppList.get(i).get(1) + backgroundAppList.get(j).get(1);
            if (curSum > deviceCapacity) {
                j--;
            } else if (curSum < curMax) {
                i++;
            } else { // curSum <= deviceCapacity && curSum >= curMax
                if (curSum > curMax) {
                    res.clear();
                    curMax = curSum;
                }
                res.add(Arrays.asList(foregroundAppList.get(i).get(0), backgroundAppList.get(j).get(0)));
                if (curSum >= deviceCapacity) {
                    j--;
                }
                i++;
            }
        }
        return res;
    }

    public static void main(String... args) {
        DevicePair devicePair = new DevicePair();
        List<List<Integer>> f1 = new ArrayList<>();
        f1.add(Arrays.asList(3, 6));
        f1.add(Arrays.asList(1, 2));
        f1.add(Arrays.asList(2, 4));
        List<List<Integer>> b1 = new ArrayList<>();
        b1.add(Arrays.asList(1, 2));

        List<List<Integer>> f2 = new ArrayList<>();
        f2.add(Arrays.asList(1, 3));
        f2.add(Arrays.asList(4, 10));
        f2.add(Arrays.asList(2, 5));
        f2.add(Arrays.asList(3, 7));
        List<List<Integer>> b2 = new ArrayList<>();
        b2.add(Arrays.asList(3, 4));
        b2.add(Arrays.asList(1, 2));
        b2.add(Arrays.asList(2, 3));
        b2.add(Arrays.asList(4, 5));

        // res should be [[2, 1]]
        List<List<Integer>> res1 = devicePair.optimalUtilization(7, f1, b1);
        for (List<Integer> list : res1) {
            System.out.print(list.get(0) + ", " + list.get(1));
        }
        System.out.println();

        // res should be [[2, 4], [3, 2]]
        List<List<Integer>> res2 = devicePair.optimalUtilization(10, f2, b2);
        for (List<Integer> list : res2) {
            System.out.print(list.get(0) + ", " + list.get(1) + ";  ");
        }
    }

}
