package com.cgi.stream;

import java.util.List;

/**
 * Created by ychang on 7/15/2016.
 */
public class MapTest {
  public static void main(String[] arges) {
    List<SalesTxn> tList = SalesTxn.createTxnList();

    System.out.println("=== Widget Pro Sales Tax in CA ==========");

    tList.stream().filter(t -> t.getState().equals(State.CA))
                  .filter(t -> t.getProduct().equals("Widget Pro"))
                  .map(t -> t.getTransactionTotal() * TaxRate.byState(t.getState()))
                  .forEach(amt -> System.out.printf("Tax tax: $%,6.2f%n", amt));
  }

}
