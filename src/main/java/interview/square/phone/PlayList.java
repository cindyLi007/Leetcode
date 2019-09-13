package interview.square.phone;

import java.util.ArrayList;
import java.util.List;

/*
Background
- One factor that make a good song transition is the key of the next song.
- For our problem, each song's key is represented by 0-11
- you can move between songs that have keys that are adjacent on the wheel, or stay in the same key.

This is a chart that diagrams which keys you can easily move between: https://drive.google.com/open?id=0B_C9jIe7uj9AV3czV282aGdPcWc

*/
public class PlayList {

  // Time: O(N)
  /* The start of our problem we'll solve today is given a playlist, return if it is valid
     These is a valid playlist since each transition is valid:
    0 [{"key":2,"title":"Mr.Brightside"},
    1 {"key":1,"title":"All Star"},
    2 {"key":0,"title":"I Miss You"},
    3 {"key":11,"title":"Counting Stars"}]
   */
  public static boolean isValid(List<Song> list) {
    for (int i=1; i<list.size(); i++) {
      Song cur = list.get(i);
      if (Math.abs((cur.key-list.get(i-1).key) % 11) > 1)
        return false;
    }
    return true;
  }

  // Given a valid list and a song, return a list which is all pos the song can insert
  // for ex. is the list is [2, 1, 0, 11] and the inserted one is 0, pos should be 2, 3, 4
  public static List<Integer> insert(List<Song> list, Song one) {
    List<Integer> res = new ArrayList<>();

    int prev=-1, k = one.key;
    for (int i=0; i<=list.size(); i++) {
      if (i==list.size() && (prev==-1 || checkValid(k, prev))) {
        res.add(list.size());
      } else {
        int cur = list.get(i).key;
        if (checkValid(k, cur) && (prev==-1 || checkValid(k, prev))) {
            res.add(i);
        }
        prev = cur;
      }
    }
    return res;
  }

  private static boolean checkValid(int k, int prev) {
    return Math.abs((k - prev) % 11) <= 1;
  }

  public static void main(String[] args) {
    // song data for testing - You can use these to make test playlists
    // sKey = new Song(key, title);
    Song s0 = new Song(0,"I Want It That Way");
    Song s0_1 = new Song(0, "Yellow");

    Song s1 = new Song(1, "All Star");
    Song s1_1 = new Song(1, "Good Life");

    Song s2 = new Song(2, "Somebody Told Me");
    Song s2_1 = new Song(2, "Mr.Brightside");

    Song s3 = new Song(3, "Clarity");

    Song s4 = new Song(4, "Chasing Pavements");

    Song s9 = new Song(9, "Royals");

    Song s10 = new Song(10, "Wonderwall");

    Song s11 = new Song(11, "Counting Stars");

    List<Song> songs = new ArrayList<>();
    songs.add(s2);
    songs.add(s1);
    songs.add(s0);
    songs.add(s11);

    System.out.println(isValid(songs)); // should return true;

    List<Integer> index = insert(songs, s0_1);
    for (int i=0; i<index.size(); i++) {
      System.out.println("insert idx is " + index.get(i));
      printIncludingNewSong(songs, index.get(i), s0_1);
      System.out.println("*********");
    }
    Song test = new Song(0, "TEST");
  }

  // print out the new list which includes the new inserted song
  private static void printIncludingNewSong(List<Song> list, int idx, Song s) {
    for (int i = 0; i < list.size(); i++) {
      if (i == idx) {
        System.out.println(s.key + ", " + s.title);
      }
      System.out.println(list.get(i).key + ", " + list.get(i).title);
    }
    if (idx == list.size()) {
      System.out.println(s.key + ", " + s.title);
    }
  }
}

class Song{
  int key;
  String title;

  public Song(int key, String title){
    this.key = key;
    this.title = title;
  }
}