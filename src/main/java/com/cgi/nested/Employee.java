package com.cgi.nested;

/**
 * Created by ychang on 7/13/2016.
 */
public class Employee {
  private String name, role, dept;
  private double salary;
  private BenefitsHelper helper = new BenefitsHelper();
  private int id;

  public Employee(String name, String role, String dept, double salary) {
    this.name = name;
    this.role = role;
    this.dept = dept;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", salary=" + salary +
        ", dept='" + dept + '\'' +
        ", role='" + role + '\'' +
        '}';
  }

  public Employee(int id, String role, String dept, double salary) {
    this.id = id;
    this.role = role;
    this.dept = dept;
    this.salary = salary;
  }

  public int getId() {
    return id;
  }

  private class BenefitsHelper {
    private final double bonusRate = 0.02;
    private final double withholdingRate = 0.07;

    protected double calcBonus(double salary) {
      return salary * bonusRate;
    }

    protected double calcWithholding(double salary) {
      return salary * withholdingRate;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public double getWithholding() {
    return helper.calcWithholding(salary);
  }

  public double getBonus() {
    return helper.calcBonus(salary);
  }
}
