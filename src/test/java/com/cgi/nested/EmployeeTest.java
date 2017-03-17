package com.cgi.nested;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ychang on 7/13/2016.
 */
public class EmployeeTest {
  private Employee jane, john;

  @Test
  public void getWithholding() throws Exception {
    System.out.println("Jane's withholding: " + jane.getWithholding());
  }

  @Test
  public void getBonus() throws Exception {
    System.out.println("John's Bonus: " + john.getBonus() );
  }

  @Before
  public void setUp() throws Exception {
    jane = new Employee("Jane Doe", "Manager", "HR", 65000);
    john = new Employee("John Doe", "Staff", "HR", 55000);
  }
}