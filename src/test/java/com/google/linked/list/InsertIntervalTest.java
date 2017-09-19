package com.google.linked.list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 5/10/2017.
 */
public class InsertIntervalTest {
  @Test
  public void insert() throws Exception {
    // Given
    InsertInterval insertInterval = new InsertInterval();
    List<Interval> intervalList = new ArrayList();
    //[1,2],[3,5],[6,7],[8,10],[12,16]
    intervalList.add(new Interval(1, 2));
    intervalList.add(new Interval(3, 5));
    intervalList.add(new Interval(6, 7));
    intervalList.add(new Interval(8, 10));
    intervalList.add(new Interval(13, 16));

    // When
    List<Interval> insertResult = insertInterval.insert_BS(intervalList, new Interval(11, 12));

    // Then
    assertThat(insertResult, hasSize(2));
  }

}