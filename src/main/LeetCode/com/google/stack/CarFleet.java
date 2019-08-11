package com.google.stack;

import java.util.*;

/**
 * Leetcode 853
 * Algorithm: If the car S (Second) behind the lead car F (First) would arrive earlier, then S forms a fleet with the lead car F.
 * Otherwise, fleet F is final as no car can catch up to it - cars behind S would form fleets with S, never F.
 */
public class CarFleet {

    // Time: O(N*lgN) for sort, then O(N) for loop
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];
        for (int i = 0; i < N; i++) {
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, (o1, o2) -> o1.pos - o2.pos);
        int count = N;
        // must backward, that is because if a car is blocked by it's previous car, need reset it time, it can be caught by
        // its successor car.
        for (int i=N-2; i>=0; i--) {
            if (cars[i].time <= cars[i+1].time) {
                count--;
                // if cars[i] can catch up cars[i+1], we need reset the cars[i].time, because it will be bloked by cars[i+1]
                // its time will change to the time of cars[i]
                cars[i].time=cars[i+1].time;
            }
        }
        return count;
    }

    public int carFleet_treeMap(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> cars = new TreeMap<>(Comparator.reverseOrder());
        for (int i=0; i<position.length; i++) {
            cars.put(position[i], (double)(target-position[i])/speed[i]);
        }
        int res=0;
        double prevTime=0;
        for (Double t : cars.values()) {
            // everyTime t > prevTime means current car could not catch up previous car fleet, so we need reset time
            // prevTime is like new car fleet arriving time
            if (t>prevTime) {
                prevTime = t;
                res++;
            }
        }
        return res;
    }

    class Car {
        int pos;
        double time;

        Car(int p, double t) {
            pos = p;
            time = t;
        }
    }

    public static void main(String... args) {
        CarFleet carFleet = new CarFleet();
        int[] positions = new int[]{0, 4, 2};
        int[] speed = new int[]{2, 1, 3};
        System.out.println(carFleet.carFleet(10, positions, speed));
    }
}
