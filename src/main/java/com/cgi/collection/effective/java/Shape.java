package com.cgi.collection.effective.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ychang on 9/8/2016.
 */
public abstract class Shape implements Comparable{
  public static void main(String[] args) {
    List<Shape> shapeList = new ArrayList<>();

    Circle circle = new Circle(5);
    Shape rectangle = new Rectangle(3, 4);
    try {
      Object cloneCircle = circle.clone();
      System.out.println(cloneCircle==circle);
      System.out.println(circle.equals(cloneCircle));
      rectangle.clone();
    } catch (CloneNotSupportedException e) {
      System.out.println("Circle could not be cloned");
    }

    shapeList.add(circle);
    shapeList.add(rectangle);

    Collections.sort(shapeList);

    for (Shape shape : shapeList) {
      System.out.println(shape.getClass().getSimpleName());
    }



  }
}
