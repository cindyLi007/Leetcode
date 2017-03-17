package com.cgi.collection.builder.pattern;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Created by ychang on 7/28/2016.
 */
public class BuilderPatternTest {

  public static void main(String[] args) {
    List<Person> people = Lists.newArrayList();
    people.add(new Person.Builder("Grace", "Chang")
        .address("3725 Millpond Ct.")
        .age(40)
        .city("Seattle")
        .code("22033")
        .email("gracechang007@gmail.com")
        .gender(Gender.FEMALE)
        .phone("703 310 9363")
        .state("CA")
        .build()
    );

    people.forEach(p -> {
      System.out.printf("SysMind: %,8d%n", p.getGender().multiply(1));
      System.out.printf("MicroStrategy Web: %,8d%n", p.getGender().multiply(2));
      System.out.printf("MicroStrategy CM: %,8d%n", p.getGender().multiply(3));
      System.out.printf("Freddie Mac: %,8d%n", p.getGender().multiply(4));
      System.out.printf("Appian: %,8d%n", p.getGender().multiply(5));
      System.out.printf("CGI Federal: %,8d%n", p.getGender().multiply(6));
      System.out.printf("Google: %,8d%n", p.getGender().multiply(7));
    });
  }
}
