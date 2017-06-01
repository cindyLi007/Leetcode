package com.google.linked.list;

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
    intervalList.add(new Interval(1, 5));
    intervalList.add(new Interval(6, 8));

    // When
    List<Interval> insertResult = insertInterval.insert(intervalList, new Interval(5, 6));
  }

}