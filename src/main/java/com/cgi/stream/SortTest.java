package com.cgi.stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by ychang on 7/15/2016.
 */
public class SortTest {
  public static void main(String[] arges) {
    List<SalesTxn> tList = SalesTxn.createTxnList();
    Consumer<SalesTxn> transReport = t -> System.out.printf("Seller: " + t.getBuyerName().substring(0, 6)
        + " Buyer: " + t.getBuyerName().substring(6) + " -- Quantity: %,9.0f%n", t.getTransactionTotal());

    System.out.println("*** PriceCA Transaction ***");

    Predicate<SalesTxn> salesTxnPredicate = t -> t.getState().equals(State.CA);
    tList.stream().filter(salesTxnPredicate)
        .sorted(Comparator.comparing(SalesTxn::getTransactionTotal))
        .forEach(transReport);

    System.out.println("*** PriceCA Transaction Reversed ***");

    tList.stream().filter(salesTxnPredicate)
        .sorted(Comparator.comparing(SalesTxn::getTransactionTotal).reversed())
        .forEach(transReport);

    System.out.println("*** Triple PriceCA Transaction ***");

    tList.stream().sorted(Comparator.comparing(SalesTxn::getBuyerName)
      .thenComparing(SalesTxn::getTxnId).thenComparing(SalesTxn::getTransactionTotal))
        .forEach(transReport);

  }

}
