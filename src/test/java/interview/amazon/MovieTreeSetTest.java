package interview.amazon;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Set;

import org.junit.Test;

/**
 * Created by ychang on 1/16/2017.
 */
public class MovieTreeSetTest {
  @Test
  public void getMovieRecommendations() throws Exception {
    // Given
    MovieTreeSet movieTreeSet = new MovieTreeSet();
    Movie a = new Movie(1, 1.2f);
    Movie b = new Movie(2, 2.4f);
    Movie c = new Movie(3, 3.6f);
    Movie d = new Movie(4, 4.8f);
    Movie e = new Movie(5, 5.8f);
    a.getMovieRecommendations().add(c);
    a.getMovieRecommendations().add(b);
    b.getMovieRecommendations().add(d);
    b.getMovieRecommendations().add(e);
    c.getMovieRecommendations().add(d);

    // When
    Set<Movie> movieRecommendations = movieTreeSet.getMovieRecommendations(a, 4);

    // Then
    assertThat(movieRecommendations.size(), is(3));
  }

}