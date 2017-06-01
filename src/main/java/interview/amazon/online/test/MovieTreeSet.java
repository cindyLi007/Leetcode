package interview.amazon.online.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import interview.amazon.online.test.Movie;

/**
 * Created by ychang on 1/16/2017.
 * Compared to MoviePriorityQueue, MovieTreeSet need not use a HashSet to keep visited Movie's Id, it keep all visited
 * movies in the TreeSet. However, for huge movie network, that means we need store all Movie data structure in this
 * TreeSet, if use Priority Queue, anytime only store N Movie data structure in the Priority Queue.
 */
public class MovieTreeSet {
  public Set<Movie> getMovieRecommendations(Movie movie, int N) {
    TreeSet<Movie> set = new TreeSet<>((m1, m2) -> Float.compare(m2.getRating(), m1.getRating()));
    if (N<=0)
      return set;
    Queue<Movie> queue = new LinkedList();
    queue.offer(movie);
    set.add(movie);
    while (!queue.isEmpty()) {
      Movie current = queue.poll();
      List<Movie> movieRecommendations = current.getMovieRecommendations();
      movieRecommendations.stream().forEach(m -> {
        if (!set.contains(m)) {
          set.add(m);
          queue.offer(m);
        }
      });
    }
    Set<Movie> res = new HashSet<>();
    for (int i = 0; i<N && !set.isEmpty(); i++) {
      res.add(set.pollFirst());
    }
    return res;
  }
}

