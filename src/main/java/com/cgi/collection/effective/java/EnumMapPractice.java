package com.cgi.collection.effective.java;

import java.util.EnumMap;

import com.cgi.collection.builder.pattern.Gender;
import com.google.common.collect.Maps;

/**
 * Created by ychang on 9/27/2016.
 */
public class EnumMapPractice {
  // EnumMap is ordered collection, the order depends on how you define the enum constants, NOT the order insert to map
  static EnumMap<Gender, String> enumMap = Maps.newEnumMap(Gender.class);

  public static void main(String[] args) {
    enumMap.put(Gender.MALE, "Wei");
    enumMap.put(Gender.FEMALE, "Grace");
    enumMap.put(Gender.UNKNOWN, "Others");

    System.out.println(enumMap);


  }
}
