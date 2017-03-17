package com.cgi.collection.compare;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ychang on 7/28/2016.
 */
public class TestComparable {

  public static void main(String[] args) {
    Set<ComparableStudent> studentList = new TreeSet<>();

    studentList.add(new ComparableStudent("Thomas Jefferson", 1111, 3.8));
    studentList.add(new ComparableStudent("John Adam", 2222, 3.9));
    studentList.add(new ComparableStudent("George Washington", 3333, 3.4));

    studentList.stream().forEach(s -> System.out.println(s));
  }
}
