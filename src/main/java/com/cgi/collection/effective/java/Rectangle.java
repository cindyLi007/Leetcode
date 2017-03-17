package com.cgi.collection.effective.java;

/**
 * Created by ychang on 9/8/2016.
 */
public class Rectangle extends Shape {
  private int length, width;

  public Rectangle(int length, int width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Rectangle)) return false;

    Rectangle rectangle = (Rectangle) o;

    if (length != rectangle.length) return false;
    return width == rectangle.width;

  }

  @Override
  public int hashCode() {
    int result = length;
    result = 31*result + width;
    return result;
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof Rectangle) {
      return (width + length) - (((Rectangle) o).width + ((Rectangle) o).length);
    } else {
      return -1;
    }
  }
}
