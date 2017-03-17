package com.cgi.interfaceExtend;

/**
 * Created by ychang on 7/26/2016.
 */
public interface BankOperations {

  void addCustomer(String f, String l, Branch branch);
  Customer getCustomer(int customerIndex);
  int getNumberOfCustomers();

  default void generateReport() {
    System.out.println("\t\t\tCUSTOMER REPORT");
    System.out.println("\t\t\t===============");

    for (int customerIndex=0; customerIndex < this.getNumberOfCustomers(); customerIndex++) {
      Customer customer = this.getCustomer(customerIndex);

      System.out.println();
      System.out.println("Customer: " + customer.getLastName() + ", "
                        + customer.getFirstName() + "\nBranch: " + customer.getBranch()
                        + ", " + customer.getBranch().getServiceLevel());

      for (int acctIndex = 0; acctIndex < customer.getNumOfAccounts(); acctIndex++) {
        Account account = customer.getAcct(acctIndex);
        System.out.println("       " + account);
      }

    }
  }


}
