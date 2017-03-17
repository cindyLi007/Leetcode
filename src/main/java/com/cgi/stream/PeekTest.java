package com.cgi.stream;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by ychang on 7/15/2016.
 */
public class PeekTest {
  public static void main(String[] arges) {
    List<SalesTxn> tList = SalesTxn.createTxnList();
    Consumer<SalesTxn> taxReport = t -> System.out.printf("Id: " + t.getTxnId()
        + " Buyer: " + t.getBuyerName() + " Txn amt: $%,9.2f ", t.getTransactionTotal());

    System.out.println("*** Widget Pro Sales Tax in CA ***");

    tList.stream().filter(t -> t.getState().equals(State.CA))
        .filter(t -> t.getProduct().equals("Widget Pro"))
        .peek(taxReport) // peek will NOT execute in the middle, only when forEach execute, add it
        .map(t -> t.getTransactionTotal() * TaxRate.byState(t.getState()))
        .forEach(amt -> System.out.printf("Tax tax: $%,9.2f%n", amt));
  }

}
