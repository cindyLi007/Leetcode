package com.cgi.interfaceExtend;

/**
 * Created by ychang on 7/25/2016.
 */
public abstract class Account {
  protected double balance;

  public Account(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Current balance is " + balance;
  }
}
