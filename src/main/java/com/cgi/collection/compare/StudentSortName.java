package com.cgi.collection.compare;

import java.util.Comparator;

/**
 * Created by ychang on 7/28/2016.
 */
public class StudentSortName implements Comparator<Student> {
  @Override
  public int compare(Student s1, Student s2) {
    return s1.getName().compareTo(s2.getName());
  }
}
