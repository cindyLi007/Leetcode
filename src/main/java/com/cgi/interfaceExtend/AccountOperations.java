package com.cgi.interfaceExtend;

/**
 * Created by ychang on 7/25/2016.
 */
public interface AccountOperations {

  double getBalance();

  void deposit(double amount);

  boolean withdraw(double amount);

  String getDescription();
}
