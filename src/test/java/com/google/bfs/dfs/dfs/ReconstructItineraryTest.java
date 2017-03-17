package com.google.bfs.dfs.dfs;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 2/27/2017.
 */
public class ReconstructItineraryTest {

  @Test
  public void findItinerary() throws Exception {
    // Given
    String[][] tickets = new String[][]{{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
    ReconstructItinerary reconstructItinerary = new ReconstructItinerary();

    // When
    List<String> itinerary = reconstructItinerary.findItinerary(tickets);

    // Then
    assertThat(itinerary, is(Arrays.asList("JFK", "NRT", "JFK", "KUL")));
  }

}