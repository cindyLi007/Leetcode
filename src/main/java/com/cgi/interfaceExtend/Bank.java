package com.cgi.interfaceExtend;

/**
 * Created by ychang on 7/26/2016.
 */
public class Bank implements BankOperations{

  private Customer[] customers;
  private int numberOfCustomer;

  public Bank() {
    customers = new Customer[10];
    numberOfCustomer = 0;
  }

  public void addCustomer(String f, String l, Branch b) {
    int i = numberOfCustomer++;
    customers[i] = new Customer(f, l, b);
  }

  @Override
  public int getNumberOfCustomers() {
    return numberOfCustomer;
  }

  @Override
  public Customer getCustomer(int customerIndex) {
    return customers[customerIndex];
  }

}
