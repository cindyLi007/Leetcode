package com.cgi.interfaceExtend;

/**
 * Created by ychang on 7/26/2016.
 */
public class Customer {

  private final String firstName;
  private final String lastName;
  private final Branch branch;

  public Customer(String f, String l, Branch b) {
    firstName = f;
    lastName = l;
    branch = b;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Branch getBranch() {
    return branch;
  }

  public int getNumOfAccounts() {
    return 0;
  }

  public Account getAcct(int acctIndex) {
    return null;
  }
}
