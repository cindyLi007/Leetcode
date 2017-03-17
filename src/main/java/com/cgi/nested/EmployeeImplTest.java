package com.cgi.nested;

import java.util.Arrays;

import com.cgi.exception.example.InvalidOperationException;

/**
 * Created by ychang on 7/24/2016.
 */
public class EmployeeImplTest {

  public static void main(String[] aregs) throws InvalidOperationException {
    EmployeeImpl empArr = new EmployeeImpl();

    Employee e1 = new Employee(0, "bob", "builder", 1250.50f);
    Employee e2 = new Employee(1, "John", "Doe", 1250.50f);
    Employee e3 = new Employee(5, "Jane", "Doe", 1250.50f);

    empArr.add(e1).add(e2).add(e3);

    Employee[] allEmps = empArr.getAllEmpoyees();
    Arrays.asList(allEmps).forEach(emp -> System.out.println(emp + "\n"));
  }
}
