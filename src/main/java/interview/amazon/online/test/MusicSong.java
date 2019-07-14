package interview.amazon.online.test;

import java.util.*;

/**
 * Amazon music is working on a new feature to pair songs together to play while on the bus. The goal of this feature is
 * to select tow songs from a list that will end exactly 30 seconds before that listener reaches their stop. You are tasked
 * with writing the method, that selects the songs from a list. Each song is assigned a unique ID, numbered from 0 to N-1
 *
 * Assumptions:
 * 1. You will pick exactly 2 songs,
 * 2. You cannot pick the same song twice,
 * 3. If you have multiple pairs with the same total time, select teh pari with the longest song
 * Input
 * The input to teh function/method consists of 2 arguments
 * rideDuration, an integer representing the duration of the ride in seconds.
 * songDurations, a list of integers representing the duration of the songs
 * Output
 * Return a list of intergers representing the IDs of two songs
 */
public class MusicSong {

    public static void main(String... args) {
        List<Integer> songs = new ArrayList<>();
        songs.add(100);
        songs.add(180);
        songs.add(40);
        songs.add(120);
        songs.add(10);
        ArrayList<Integer> res = IDsOfSongs(250, songs);
        res.stream().forEach(System.out::println);
        songs.clear();
        songs.add(20);
        songs.add(110);
        songs.add(70);
        songs.add(90);
        songs.add(30);
        songs.add(60);
        res = IDsOfSongs(160, songs);
        res.stream().forEach(System.out::println);
    }

     static ArrayList<Integer> IDsOfSongs(int rideDuration, List<Integer> songDurations) {
         ArrayList<Integer> res = new ArrayList<>();
         rideDuration -= 30;
         int max=0;
         Map<Integer, Integer> map = new HashMap<>();
         for (int i=0; i<songDurations.size(); i++) {
             if (map.containsKey(songDurations.get(i))) {
                 int l1 = songDurations.get(i);
                 int l2 = songDurations.get(map.get(songDurations.get(i)));
                 if (l1 + l2==rideDuration) {
                     int curMax = Math.max(l1, l2);
                     if (res.isEmpty() || curMax>max) {
                         if (!res.isEmpty()) res.clear();
                         res.add(map.get(songDurations.get(i)));
                         res.add(i);
                         max = curMax;
                     }
                 }
             } else {
                 map.put(rideDuration - songDurations.get(i), i);
             }
         }
         return res;
    }

}
