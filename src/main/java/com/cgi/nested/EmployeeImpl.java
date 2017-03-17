package com.cgi.nested;

import com.cgi.exception.example.InvalidOperationException;

/**
 * Created by ychang on 7/24/2016.
 */
public class EmployeeImpl {
  private Employee[] employeeArray;

  public EmployeeImpl() {
    employeeArray = new Employee[10];
  }

  public EmployeeImpl add(Employee employee) throws InvalidOperationException {
    if (employeeArray[employee.getId()] != null) {
      throw new InvalidOperationException("Error adding employee, employee id already exists");
    }
    try {
      employeeArray[employee.getId()] = employee;
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new InvalidOperationException("Error adding employee, id must less than " + employeeArray.length);
    }
    return this;
  }

  public void delete(int id) {
    if (employeeArray[id] == null) {

    }
  }

  public Employee[] getAllEmpoyees() {
    return employeeArray;
  }
}
