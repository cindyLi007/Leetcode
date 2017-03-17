package com.cgi.collection.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ychang on 7/28/2016.
 */
public class TestComparator {

  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    Comparator<Student> sortName = new StudentSortName();
    Comparator<Student> sortGpa = new StudentSortGpa();

    studentList.add(new Student("Thomas Jefferson", 1111, 3.8));
    studentList.add(new Student("John Adams", 2222, 3.9));
    studentList.add(new Student("George Washington", 3333, 3.4));

    Collections.sort(studentList, sortName);
    System.out.println("---- Students sorted by Name -----");
    studentList.stream().forEach(student -> System.out.println(student));

    Collections.sort(studentList, sortGpa);
    System.out.println("---- Students sorted by GPA -----");
    studentList.stream().forEach(student -> System.out.println(student));
  }
}
