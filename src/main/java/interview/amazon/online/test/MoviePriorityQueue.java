package interview.amazon.online.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ychang on 1/16/2017.
 */
public class MoviePriorityQueue {
  public Set<Movie> getMovieRecommendations(Movie movie, int N) {
    Set<Movie> res = new HashSet();
    if (movie==null || N<=0)
      return res;

    /**
     * must have Movie generic in initialize PriorityQueue, otherwise could not use lambda comparator
     */
    PriorityQueue<Movie> pq = new PriorityQueue<>((m1, m2) -> Float.compare(m1.getRating(), m2.getRating()));
    Queue<Movie> neighbor = new LinkedList();
    Set<Integer> visited = new HashSet();

    neighbor.add(movie);
    visited.add(movie.getId());
    pq.add(movie);
    while (!neighbor.isEmpty()) {
      Movie c = neighbor.poll();
      List<Movie> list = c.getMovieRecommendations();
      list.stream().forEach(m -> {
        if (!visited.contains(m.getId())) {
          visited.add(m.getId());
          neighbor.add(m);
          pq.add(m);
          if (pq.size()>N)
            pq.remove();
        }
      });
    }
    pq.stream().forEach(m -> res.add(m));
    return res;
  }

}

class Movie {
  private final int id;
  private float rating;
  private List<Movie> re;

  public Movie(int i, float v) {
    id = i;
    rating = v;
    re = new LinkedList();
  }

  public List<Movie> getMovieRecommendations() {
    return re;
  }

  public int getId() {
    return id;
  }

  public float getRating() {
    return rating;
  }
}
