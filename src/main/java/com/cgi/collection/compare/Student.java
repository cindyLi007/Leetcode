package com.cgi.collection.compare;

/**
 * Created by ychang on 7/28/2016.
 */
public class Student {
  private String name;
  private long id = 0;
  private double gpa = 0.0;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  @Override
  public String toString() {
    return "name:'" + name + "', Id: " + id + ", GPA: " + gpa ;
  }

  public Student(String name, long id, double gpa) {
    this.name = name;
    this.id = id;
    this.gpa = gpa;
  }
}
