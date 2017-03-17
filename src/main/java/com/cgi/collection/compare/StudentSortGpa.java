package com.cgi.collection.compare;

import java.util.Comparator;

/**
 * Created by ychang on 7/28/2016.
 */
public class StudentSortGpa implements Comparator<Student> {
  @Override
  public int compare(Student s1, Student s2) {
    return Double.compare(s2.getGpa(), s1.getGpa());
  }
}