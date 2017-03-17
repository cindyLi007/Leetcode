package com.cgi.interfaceExtend;

/**
 * Created by ychang on 7/25/2016.
 */
public class SavingAccount extends Account implements AccountOperations{

  Double rateOfInterest = 0.06;

  public SavingAccount(double balance) {
    super(balance);
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public void deposit(double amount) {
    balance += amount;
    balance += balance * rateOfInterest;
  }

  @Override
  public boolean withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
      return true;
    }
    return false;
  }

  @Override
  public String getDescription() {
    return "Saving Account";
  }

  @Override
  public String toString() {
    return getDescription() + " balance is " + balance;
  }
}
