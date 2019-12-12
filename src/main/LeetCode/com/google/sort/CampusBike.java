package com.google.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CampusBike {
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    PriorityQueue<Item> pq = new PriorityQueue<>();
    int i = 0, j = 0;
    for (int[] worker : workers) {
      j = 0;
      for (int[] bike : bikes) {
        int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
        pq.offer(new Item(dist, i, j++));
      }
      i++;
    }
    int N = workers.length;
    int[] res = new int[N];
    int[] visited = new int[bikes.length];
    Arrays.fill(res, -1);
    Arrays.fill(visited, 0);
    int count = 0;
    while (count < N) {
      Item cur = pq.poll();
      if (res[cur.worker] == -1 && visited[cur.bike] == 0) {
        res[cur.worker] = cur.bike;
        count++;
        visited[cur.bike] = 1;
      }
    }
    return res;
  }

  class Item implements Comparable<Item> {
    int distance, worker, bike;

    public Item(int d, int w, int b) {
      distance = d;
      worker = w;
      bike = b;
    }

    public int compareTo(Item i) {
      if (i.distance == distance) {
        if (i.worker == worker) {
          return bike - i.bike;
        }
        return worker - i.worker;
      }
      return distance - i.distance;
    }
  }

  // Time: O(M*N), O(M*N)
  // Bucket sort is much better than PriorityQueue, the latter one Time Complexity is O((M*N)lg(M*N)), bucket sort is only (M*N)
  // that is because bucket sort need not to order-insert into queue when loop through all distance. it take O(1) to
  // insert into the array, PriorityQueue will take O(lg(M*N)) to insert into it
  public int[] assignBikes_bucketSort(int[][] workers, int[][] bikes) {
    List<int[]>[] dist = (List<int[]>[]) new List[2000];
    int M = workers.length, N = bikes.length;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        int d = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
        if (dist[d] == null) dist[d] = new ArrayList<>();
        dist[d].add(new int[]{i, j});
      }
    }
    int[] res = new int[M];
    int[] visited = new int[N];
    Arrays.fill(res, -1);
    Arrays.fill(visited, -1);
    for (int i = 0; i < 2000; i++) {
      if (dist[i] == null) continue;
      for (int[] item : dist[i]) {
        int w = item[0], b = item[1];
        if (res[w] == -1 && visited[b] == -1) {
          res[w] = b;
          visited[b] = w;
        }
      }
    }
    return res;
  }

  public static void main(String... args) {
    CampusBike campusBike = new CampusBike();
    int[][] workers = new int[][]{{0, 0}, {1, 1}, {2, 0}};
    int[][] bikes = new int[][]{{1, 0}, {2, 2}, {2, 1}};
    int[] assignBikes = campusBike.assignBikes(workers, bikes);
    Arrays.stream(assignBikes).forEach(a -> System.out.print(a + ", "));
  }
}
