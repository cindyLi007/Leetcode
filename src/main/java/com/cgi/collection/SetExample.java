package com.cgi.collection;

import static org.apache.commons.lang.StringUtils.join;
import static org.apache.commons.lang.StringUtils.splitByCharacterTypeCamelCase;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ychang on 7/28/2016.
 */
public class SetExample {

  public static void main(String[] args) {
    Set<String> set = new TreeSet<>();

    set.add("one");
    set.add("two");
    set.add("three");
    set.add("three");

    set.stream().forEach(s -> System.out.println("Item: " + s));

    String emailSubject = join(splitByCharacterTypeCamelCase("QuarterlyWorkItemDeletion"), ' ')
        .concat(" Report");

    System.out.println(emailSubject);

  }
}
