package com.cgi.collection.effective.java;

/**
 * Created by ychang on 9/8/2016.
 */
public class Circle extends Shape implements Cloneable {
  private final int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Circle)) return false;

    Circle circle = (Circle) o;
    return radius == circle.radius;

  }

  @Override
  public int hashCode() {
    return radius;
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof Circle) {
      return radius - ((Circle) o).radius;
    } else {
      return -1;
    }
  }
}
